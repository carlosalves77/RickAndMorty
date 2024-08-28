package br.com.dev.rickandmorty.model

import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.repository.DatabaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDatabaseModel(
    private val databaseRepository: DatabaseRepository
) : FavoriteContract.View {


    override suspend fun saveCharacter(characters: CharacterDataBaseModel) {
        databaseRepository.saveCharacter(characters)
    }

    override  fun getCharacters() {
        databaseRepository.getAllCharacters()
    }

    override suspend fun deleteCharacter(id: Int) {
        databaseRepository.deleteCharacter(id)
    }

}