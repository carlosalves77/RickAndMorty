package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import br.com.dev.rickandmorty.databinding.FragmentDetailCharacterScreenBinding
import br.com.dev.rickandmorty.databinding.FragmentHomescreenBinding


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
        return binding.root


    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}