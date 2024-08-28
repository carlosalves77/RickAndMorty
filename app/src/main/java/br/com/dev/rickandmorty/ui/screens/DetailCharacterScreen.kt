package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.databinding.FragmentDetailCharacterScreenBinding
import coil.load


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

        binding.characterName.text = arguments?.getString("characterName")
        binding.speciesName.text = arguments?.getString("characterSpecie")
        binding.characterImage.load(arguments?.getString("characterImage")) {
            crossfade(true)
            crossfade(1000)
        }
        binding.statusName.text = arguments?.getString("characterStatus")
        binding.genderName.text = arguments?.getString("characterGender")
        binding.createdName.text = arguments?.getString("characterCreated")


        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}