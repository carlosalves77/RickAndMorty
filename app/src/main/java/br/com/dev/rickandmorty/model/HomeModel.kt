package br.com.dev.rickandmorty.model

import br.com.dev.rickandmorty.contracts.HomeContract
import br.com.dev.rickandmorty.data.ApiService

class MainModel(
   private val apiService: ApiService
) : HomeContract.Model {

    override suspend fun fetchCharacters(onFinishListener: HomeContract.Model.OnFinishListener) {

        onFinishListener.onLoading()

        try {
                val response = apiService.getCharacters()

                if (response.isSuccessful) {
                    response.body()?.let {
                        onFinishListener.onSuccess(it)
                    }
                } else {
                    onFinishListener.onError(message = response.errorBody().toString())
                }

        } catch (e: Exception) {
            onFinishListener.onError(message = e.message.toString())
        }


    }
}