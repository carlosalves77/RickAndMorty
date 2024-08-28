package br.com.dev.rickandmorty.di

import android.content.Context
import androidx.room.Room
import br.com.dev.rickandmorty.data.CharacterDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val LocalModule = module {

    single {
        provideDatabase(androidContext())
    }

    single {
        provideDao(get())
    }


}

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, CharacterDatabase::class.java, "character_database")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(database: CharacterDatabase) = database.noteDao()