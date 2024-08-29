package br.com.dev.rickandmorty.data

import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO
import br.com.dev.rickandmorty.data.model.Result
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters() : Response<ListOfCharactersDTO>

}