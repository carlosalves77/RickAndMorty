package br.com.dev.rickandmorty.ui.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.data.model.Result
import br.com.dev.rickandmorty.databinding.CharacterRowBinding
import br.com.dev.rickandmorty.databinding.FavoriteCardBinding
import br.com.dev.rickandmorty.presenter.CharacterPresenter
import coil.load
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {

    private var mFavoriteCharacters = listOf<CharacterDataBaseModel>()

    inner class MyViewHolder(val binding: FavoriteCardBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteAdapter.MyViewHolder {

        val binding =
            FavoriteCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FavoriteAdapter.MyViewHolder, position: Int) {
        val currentCharacters = this.mFavoriteCharacters[position]

        holder.binding.apply {

            characterName.text = currentCharacters.name
            speciesName.text = currentCharacters.species
            favoriteCharacterImage.load(currentCharacters.picture) {
                crossfade(true)
                crossfade(1000)
            }

            favoriteStar.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {

                }
            }
        }

    }

    override fun getItemCount() = mFavoriteCharacters.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(characters: List<CharacterDataBaseModel>) {
        Log.d("AdapterFavorite", "setData called with $characters items")
        this.mFavoriteCharacters = characters
        notifyDataSetChanged()
    }



}