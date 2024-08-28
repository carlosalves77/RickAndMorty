package br.com.dev.rickandmorty.presenter

import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDatabasePresenter(
    private val view: FavoriteContract.View,
) : FavoriteContract.Presenter {

    private val scope = CoroutineScope(Dispatchers.IO)

    override suspend fun saveCharacter(characters: CharacterDataBaseModel) {
        scope.launch {
            view.saveCharacter(characters)
        }
    }

    override fun getCharacters() {
        view.getCharacters()
    }

    override suspend fun deleteCharacter(id: Int) {
        scope.launch {
            view.deleteCharacter(id)
        }
    }


}