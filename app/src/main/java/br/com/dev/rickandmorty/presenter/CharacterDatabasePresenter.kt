package br.com.dev.rickandmorty.presenter

import br.com.dev.rickandmorty.contracts.FavoriteContract
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel

class CharacterDatabasePresenter(
    private val view: FavoriteContract.View,
) : FavoriteContract.Presenter {


    override suspend fun saveCharacter(characters: CharacterDataBaseModel) {
            view.saveCharacter(characters)
    }

    override fun getCharacters() {
        view.getCharacters()
    }

    override suspend fun deleteCharacter(id: Int) {
            view.deleteCharacter(id)
    }


}