package br.com.dev.rickandmorty.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterDataBaseModel)

    @Query("SELECT * FROM CHARACTER_TABLE")
    fun getAllCharacters(): List<CharacterDataBaseModel>

    @Query("DELETE FROM CHARACTER_TABLE WHERE id = :id")
    suspend fun deleteCharacter(id: Int)


}