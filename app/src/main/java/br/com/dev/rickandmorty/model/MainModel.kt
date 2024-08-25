package br.com.dev.rickandmorty.model

import android.util.Log
import br.com.dev.rickandmorty.contracts.MainActivityContract
import br.com.dev.rickandmorty.data.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainModel(
    private val apiService: ApiService
) : MainActivityContract.Model {

    override suspend fun fetchCharacters(onFinishListener: MainActivityContract.Model.OnFinishListener) {

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