package br.com.dev.rickandmorty.contracts

import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO

interface HomeContract {

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