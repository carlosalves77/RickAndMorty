package br.com.dev.rickandmorty.ui.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.dev.rickandmorty.contracts.MainActivityContract
import br.com.dev.rickandmorty.data.ApiService
import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import br.com.dev.rickandmorty.databinding.FragmentHomescreenBinding
import br.com.dev.rickandmorty.model.MainModel
import br.com.dev.rickandmorty.presenter.MainPresenter
import org.koin.android.ext.android.inject

class HomeScreenFragment : Fragment(), MainActivityContract.View {

    private var _binding: FragmentHomescreenBinding? = null
    private val binding by lazy {
        _binding!!
    }

    val apiService: ApiService by inject()

    private lateinit var presenter: MainPresenter

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

    }

    override fun onLoading() {
      Log.d("onLoadingCharacters", "onLoading")
    }

    override fun onSuccess(characters: List<ListOfCharactersDTO>) {
      Log.d("onSuccessCharacters", "onSuccess: $characters")
    }

    override fun onError(message: String) {
       Log.d("onErrorCharacters", "onError: $message")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}