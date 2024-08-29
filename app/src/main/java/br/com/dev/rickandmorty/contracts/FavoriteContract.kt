package br.com.dev.rickandmorty.contracts

import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel

interface FavoriteContract {

    interface DetailView {
        suspend fun saveCharacter()
    }
    interface FavoriteView {
        fun getCharacters(characters: List<CharacterDataBaseModel>)
    }

}