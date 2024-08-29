package br.com.dev.rickandmorty.model

import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.repository.DatabaseRepository

class CharacterModel(
    private val databaseRepository: DatabaseRepository
)  {

     suspend fun saveCharacter(character: CharacterDataBaseModel) {
        databaseRepository.saveCharacter(character)
    }

     fun getCharacters() : List<CharacterDataBaseModel> {
       return databaseRepository.getAllCharacters()
    }

     suspend fun deleteCharacter(id: Int) {
        databaseRepository.deleteCharacter(id)
    }

}