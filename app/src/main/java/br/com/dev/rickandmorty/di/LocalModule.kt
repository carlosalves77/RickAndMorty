package br.com.dev.rickandmorty.di

import android.content.Context
import androidx.room.Room
import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.CharacterDatabase
import br.com.dev.rickandmorty.model.CharacterModel
import br.com.dev.rickandmorty.presenter.CharacterPresenter
import br.com.dev.rickandmorty.repository.DatabaseRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val LocalModule = module {

    single {
        provideDatabase(androidContext())
    }

    single {
        provideDao(get())
    }

    single {
      CharacterModel(get())
    }
    single {
        DatabaseRepository(get())

    }
    factory {
        (view: FavoriteContract.View) -> CharacterPresenter(view, get())
    }

}

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, CharacterDatabase::class.java, "character_database")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(database: CharacterDatabase) = database.noteDao()