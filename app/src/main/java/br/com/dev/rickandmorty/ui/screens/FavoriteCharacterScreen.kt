package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.databinding.FragmentFavoriteCharacterScreenBinding
import br.com.dev.rickandmorty.presenter.CharacterFavoritePresenter
import br.com.dev.rickandmorty.ui.adapter.FavoriteAdapter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class FavoriteCharacterScreen : Fragment(), FavoriteContract.FavoriteView {

    private var _binding: FragmentFavoriteCharacterScreenBinding? = null
    private val binding by lazy {
        _binding!!
    }

    private val favoriteAdapter = FavoriteAdapter()


    private val characterDetailPresenter: CharacterFavoritePresenter by inject { parametersOf(this) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteCharacterScreenBinding.inflate(inflater, container, false)

        initRecyclerView()


        characterDetailPresenter.getCharacters()

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_favoriteCharacterScreen_to_homeScreenFragmentScreen)
        }



        return binding.root
    }

    private fun initRecyclerView() {

        binding.favoriteRv.adapter = favoriteAdapter
        binding.favoriteRv.setHasFixedSize(true)
    }



    override fun getCharacters(characters: List<CharacterDataBaseModel>) {
        lifecycleScope.launch {
            favoriteAdapter.setData(characters)
        }
    }

    override fun deleteCharacter(id: Int) {
        lifecycleScope.launch {
            characterDetailPresenter.deleteCharacter(id)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}