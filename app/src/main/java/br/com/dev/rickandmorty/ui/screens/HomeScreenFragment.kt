package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import br.com.dev.rickandmorty.contracts.MainActivityContract
import br.com.dev.rickandmorty.data.ApiService
import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import br.com.dev.rickandmorty.databinding.FragmentHomescreenBinding
import br.com.dev.rickandmorty.model.MainModel
import br.com.dev.rickandmorty.presenter.MainPresenter
import br.com.dev.rickandmorty.ui.adapter.CharacterAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class HomeScreenFragment : Fragment(), MainActivityContract.View, View.OnClickListener {

    private var _binding: FragmentHomescreenBinding? = null
    private val binding by lazy {
        _binding!!
    }

    private val apiService: ApiService by inject()
    private lateinit var presenter: MainPresenter

    private val characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomescreenBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MainPresenter(this, MainModel(apiService))

        presenter.getCharacters()

        initRecyclerView()

        binding.favoriteIconButton.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v) {
            binding.favoriteIconButton -> {

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