package br.com.dev.rickandmorty.di

import br.com.dev.rickandmorty.util.Constants
import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val NetworkModule = module {

    single {
        MoshiConverterFactory.create()
    }
    single {
        Moshi.Builder()
    }
    single {
        createRetrofit()
    }


}

fun createRetrofit() : Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create()).build()
}

