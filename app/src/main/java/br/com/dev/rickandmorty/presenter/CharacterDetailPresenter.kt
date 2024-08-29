package br.com.dev.rickandmorty.presenter

import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.model.CharacterModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailPresenter(
    private val view: FavoriteContract.DetailView,
    private val model: CharacterModel
) {

    private val scope = CoroutineScope(Dispatchers.IO)

    fun saveCharacter(characters: CharacterDataBaseModel) {
        scope.launch {
            withContext(Dispatchers.Main) {
                model.saveCharacter(characters)
                withContext(Dispatchers.Main) {
                    view.saveCharacter()
                }
            }
        }
    }


}