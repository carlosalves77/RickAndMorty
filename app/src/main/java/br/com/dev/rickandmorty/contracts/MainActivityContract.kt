package br.com.dev.rickandmorty.contracts

import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import br.com.dev.rickandmorty.data.model.Result
import retrofit2.Response

interface MainActivityContract {

    interface View {
        fun onLoading()
        fun onSuccess(characters: ListOfCharactersDTO)
        fun onError(message: String)
    }

    interface Presenter {
        fun getCharacters()
        fun onDestroy()
    }

    interface Model {
        interface OnFinishListener {
            fun onLoading()
            fun onSuccess(characters: ListOfCharactersDTO)
             fun onError(message: String)
        }

        suspend fun fetchCharacters(onFinishListener: OnFinishListener)
    }
}