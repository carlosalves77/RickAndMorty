package br.com.dev.rickandmorty.contracts

import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel

interface FavoriteContract {

    interface View {
        suspend fun saveCharacter()
        fun getCharacters(characters: List<CharacterDataBaseModel>)
        fun onCharacterDeleted()
    }

}