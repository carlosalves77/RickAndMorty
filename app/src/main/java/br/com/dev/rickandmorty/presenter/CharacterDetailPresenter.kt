package br.com.dev.rickandmorty.presenter

import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.model.CharacterModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CharacterDetailPresenter(
    private val view: FavoriteContract.DetailView,
    private val model: CharacterModel
) {

    private val scope = CoroutineScope(Dispatchers.IO)

    suspend fun saveCharacter(characters: CharacterDataBaseModel) {
        scope.launch {
                model.saveCharacter(characters)
        }
    }


}