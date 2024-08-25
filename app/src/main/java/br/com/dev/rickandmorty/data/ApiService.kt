package br.com.dev.rickandmorty.data

import br.com.dev.rickandmorty.data.model.ListOfCharacters
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters() : Response<ListOfCharacters>
}