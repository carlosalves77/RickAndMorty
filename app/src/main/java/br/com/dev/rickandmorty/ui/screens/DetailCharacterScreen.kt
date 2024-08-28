package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.databinding.FragmentDetailCharacterScreenBinding


class DetailCharacterScreen : Fragment() {

    private var _binding: FragmentDetailCharacterScreenBinding? = null
    private val binding by lazy {
        _binding!!
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCharacterScreenBinding.inflate(inflater, container, false)


        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailCharacterScreen_to_homeScreenFragmentScreen)
        }

        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}