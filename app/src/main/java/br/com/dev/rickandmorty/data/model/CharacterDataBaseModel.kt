package br.com.dev.rickandmorty.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "CHARACTER_TABLE")
data class CharacterDataBaseModel(
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "picture")
    val picture: String,
    @ColumnInfo(name = "species")
    val species: String
)
