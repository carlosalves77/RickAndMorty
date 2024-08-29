package br.com.dev.rickandmorty.repository

import br.com.dev.rickandmorty.data.dao.CharacterDao
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel

class DatabaseRepository (private val dao: CharacterDao) {

    suspend fun saveCharacter(character: CharacterDataBaseModel) = dao.insertCharacter(character)

    fun getAllCharacters(): List<CharacterDataBaseModel> = dao.getAllCharacters()

    suspend fun deleteCharacter(id: Int) = dao.deleteCharacter(id)

}