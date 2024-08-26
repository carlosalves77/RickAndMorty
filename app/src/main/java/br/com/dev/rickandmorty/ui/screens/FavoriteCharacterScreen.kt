package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.databinding.FragmentFavoriteCharacterScreenBinding
import br.com.dev.rickandmorty.databinding.FragmentHomescreenBinding


class FavoriteCharacterScreen : Fragment() {

    private var _binding: FragmentFavoriteCharacterScreenBinding? = null
    private val binding by lazy {
        _binding!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteCharacterScreenBinding.inflate(inflater, container, false)
        return binding.root


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}