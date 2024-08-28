package br.com.dev.rickandmorty.contracts

import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.data.model.ListOfCharactersDTO

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

    interface Model {
        interface OnFinishListener {
            fun getCharacters()
        }

        interface OnSaveListener {
            suspend fun saveCharacter(characters: CharacterDataBaseModel)
        }

        interface OnDeleteListener {
            suspend fun deleteCharacter(id: Int)
        }

        fun getCharacters(onFinishListener: OnFinishListener)
        suspend fun saveCharacters(onSaveListener: OnSaveListener, characters: CharacterDataBaseModel)
        suspend fun deleteCharacters(onDeleteListener: OnDeleteListener, id: Int)

    }


}