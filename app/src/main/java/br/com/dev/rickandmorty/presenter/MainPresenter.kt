package br.com.dev.rickandmorty.presenter

import br.com.dev.rickandmorty.contracts.MainActivityContract
import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import br.com.dev.rickandmorty.data.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainPresenter (
    private val view: MainActivityContract.View,
    private val model: MainActivityContract.Model
): MainActivityContract.Presenter, MainActivityContract.Model.OnFinishListener{


    private val scope = CoroutineScope(Dispatchers.IO)

    override fun getCharacters() {
       scope.launch {
           model.fetchCharacters(this@MainPresenter)
       }

    }

    override fun onDestroy() {
        scope.cancel()
    }

    override fun onLoading() {
        scope.launch {
            view.onLoading()
        }
    }

    override fun onSuccess(characters: ListOfCharactersDTO) {
        scope.launch {
            view.onSuccess(characters)
        }
    }


    override fun onError(message: String) {
        scope.launch {
            view.onError(message)
        }
    }

}