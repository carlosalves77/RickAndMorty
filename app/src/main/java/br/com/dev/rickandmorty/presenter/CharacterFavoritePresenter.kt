package br.com.dev.rickandmorty.presenter

import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.model.CharacterModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterFavoritePresenter(
    private val view: FavoriteContract.FavoriteView,
    private val model: CharacterModel
) {

    private val scope = CoroutineScope(Dispatchers.IO)

    fun getCharacters() {
        scope.launch {
            val characters = model.getCharacters()
            withContext(Dispatchers.Main) {
                view.getCharacters(characters)
            }

        }
    }

    suspend fun deleteCharacter(id: Int) {
        scope.launch {
            model.deleteCharacter(id)
            withContext(Dispatchers.IO) {
                view.deleteCharacter(id)
            }
        }
    }


}