package br.com.dev.rickandmorty

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.com.dev.rickandmorty.contracts.MainActivityContract
import br.com.dev.rickandmorty.data.ApiService
import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import br.com.dev.rickandmorty.databinding.ActivityMainBinding
import br.com.dev.rickandmorty.model.MainModel
import br.com.dev.rickandmorty.presenter.MainPresenter
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    val apiService: ApiService by  inject ()

    private lateinit var presenter: MainPresenter

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, MainModel(apiService))


    }

    override fun onStart() {
        super.onStart()
        presenter.getCharacters()
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


}