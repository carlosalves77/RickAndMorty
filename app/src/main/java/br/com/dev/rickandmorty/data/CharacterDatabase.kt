package br.com.dev.rickandmorty.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.dev.rickandmorty.data.dao.CharacterDao
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel

@Database(entities = [CharacterDataBaseModel::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun noteDao() : CharacterDao

}