package br.com.dev.rickandmorty.presenter

import br.com.dev.rickandmorty.contracts.HomeContract
import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomePresenter (
    private val view: HomeContract.View,
    private val model: HomeContract.Model
): HomeContract.Presenter, HomeContract.Model.OnFinishListener{


    private val scope = CoroutineScope(Dispatchers.IO)

    override fun getCharacters() {
       scope.launch {
           model.fetchCharacters(this@HomePresenter)
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