package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.databinding.FragmentDetailCharacterScreenBinding
import br.com.dev.rickandmorty.presenter.CharacterDetailPresenter
import coil.load
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone


class DetailCharacterScreen : Fragment(), FavoriteContract.DetailView {

    private var _binding: FragmentDetailCharacterScreenBinding? = null
    private val binding by lazy {
        _binding!!
    }

    private val characterDetailPresenter: CharacterDetailPresenter by inject { parametersOf(this) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCharacterScreenBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val createDate = arguments?.getString("characterCreated")


        val formattedDate = createDate?.let {
            dataFormatter(it)
        }

        binding.createdName.text = formattedDate


        binding.favoriteStar.setOnClickListener {
            lifecycleScope.launch {
                saveCharacter()
            }
        }


    }

    private fun dataFormatter(inputDate: String): String {


        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")

        val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        val date = inputFormat.parse(inputDate)
        return outputFormat.format(date!!)

    }

    override suspend fun saveCharacter() {

        val id = arguments?.getInt("characterId")
        val image = arguments?.getString("characterImage").toString()


        val character = CharacterDataBaseModel(
            id = id!!,
            name = binding.characterName.text.toString(),
            species = binding.speciesName.text.toString(),
            picture = image,
        )
        characterDetailPresenter.saveCharacter(
            character
        )
        Log.d("saveCharacter", "saveCharacter: $")
        Toast.makeText(
            context?.applicationContext,
            "Personagem salvo com sucesso!",
            Toast.LENGTH_SHORT
        ).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}