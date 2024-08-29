package br.com.dev.rickandmorty.contracts

import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel

interface FavoriteContract {

    interface View {
        suspend fun saveCharacter(characters: CharacterDataBaseModel)
        fun getCharacters()
        suspend fun deleteCharacter(id: Int)
    }

    interface Presenter {
        suspend fun saveCharacter(characters: CharacterDataBaseModel)
        fun getCharacters()
        suspend fun deleteCharacter(id: Int)
    }


}