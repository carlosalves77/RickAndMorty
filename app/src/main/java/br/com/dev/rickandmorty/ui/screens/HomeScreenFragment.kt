package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.contracts.MainActivityContract
import br.com.dev.rickandmorty.data.ApiService
import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import br.com.dev.rickandmorty.databinding.FragmentHomescreenScreenBinding
import br.com.dev.rickandmorty.model.MainModel
import br.com.dev.rickandmorty.presenter.MainPresenter
import br.com.dev.rickandmorty.ui.adapter.CharacterAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class HomeScreenFragment : Fragment(), MainActivityContract.View, View.OnClickListener {

    private var _binding: FragmentHomescreenScreenBinding? = null
    private val binding by lazy {
        _binding!!
    }

//    private val characterPresenter: CharacterPresenter by inject { parametersOf(this) }

    private val apiService: ApiService by inject()

    private lateinit var presenter: MainPresenter

    private val characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomescreenScreenBinding.inflate(inflater, container, false)

        binding.favoriteIconButton.setOnClickListener(this)

        presenter = MainPresenter(this, MainModel(apiService))

        presenter.getCharacters()

//        characterPresenter.getCharacters()


        initRecyclerView()

        binding.favoriteIconButton.setOnClickListener(this)

        return binding.root
    }


    override fun onClick(v: View?) {
        when (v) {
            binding.favoriteIconButton -> {
                findNavController().navigate(R.id.action_homeScreenFragmentScreen_to_favoriteCharacterScreen)
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvHome.adapter = characterAdapter
        binding.rvHome.setHasFixedSize(true)
    }

    override fun onLoading() {
        lifecycleScope.launch {
            binding.progressbar.visibility = View.VISIBLE
        }
    }

    override fun onSuccess(characters: ListOfCharactersDTO) {
        lifecycleScope.launch {
            characterAdapter.setData(characters.results)
            binding.progressbar.visibility = View.GONE
            binding.rvHome.visibility = View.VISIBLE
        }

    }

    override fun onError(message: String) {
        Log.d("onErrorCharacters", "onError: $message")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}