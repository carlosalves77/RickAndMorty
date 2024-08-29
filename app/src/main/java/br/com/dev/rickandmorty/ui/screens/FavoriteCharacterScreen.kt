package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.databinding.FragmentFavoriteCharacterScreenBinding
import br.com.dev.rickandmorty.presenter.CharacterPresenter
import br.com.dev.rickandmorty.ui.adapter.CharacterAdapter
import br.com.dev.rickandmorty.ui.adapter.FavoriteAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class FavoriteCharacterScreen : Fragment(), FavoriteContract.View {

    private var _binding: FragmentFavoriteCharacterScreenBinding? = null
    private val binding by lazy {
        _binding!!
    }

    private val characterPresenter: CharacterPresenter by inject { parametersOf(this) }

    private val favoriteAdapter  = FavoriteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteCharacterScreenBinding.inflate(inflater, container, false)

        initRecyclerView()


        characterPresenter.getCharacters()

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_favoriteCharacterScreen_to_homeScreenFragmentScreen)
        }

        return binding.root

    }

    private fun initRecyclerView() {

        binding.favoriteRv.adapter = favoriteAdapter
        binding.favoriteRv.setHasFixedSize(true)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override suspend fun saveCharacter() {
        TODO("Not yet implemented")
    }

    override fun getCharacters(characters: List<CharacterDataBaseModel>) {
        lifecycleScope.launch {
            favoriteAdapter.setData(characters)
        }
    }

    override fun onCharacterDeleted() {
        TODO("Not yet implemented")
    }


}