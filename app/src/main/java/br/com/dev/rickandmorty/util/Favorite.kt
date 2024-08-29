package br.com.dev.rickandmorty.util

object Favorite {

    val idList: MutableList<Int> = mutableListOf()

    fun addId(id: Int) {
        idList.add(id)
    }

    fun getAllIds(): List<Int> {
        return idList
    }

}