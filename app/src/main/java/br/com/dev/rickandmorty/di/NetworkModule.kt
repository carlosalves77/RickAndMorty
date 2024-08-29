package br.com.dev.rickandmorty.di

import br.com.dev.rickandmorty.data.ApiService
import br.com.dev.rickandmorty.model.MainModel
import br.com.dev.rickandmorty.util.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val NetworkModule = module {

    single {
        provideMoshi()
    }
    single {
        createRetrofit(get())
    }

}


fun provideMoshi() : Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


fun createRetrofit(moshi: Moshi) : ApiService {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(ApiService::class.java)

}






