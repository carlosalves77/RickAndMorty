package br.com.dev.rickandmorty.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dev.rickandmorty.data.model.CharacterDataBaseModel
import br.com.dev.rickandmorty.databinding.FavoriteCardBinding
import coil.load


class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>() {

    private var mFavoriteCharacters = listOf<CharacterDataBaseModel>()

    interface onDeleteClickListener {
        fun onDeleteClick(id: Int)
    }


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

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
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
                deleteCharacter(currentCharacters.id)

            }
        }

    }

    override fun getItemCount() = mFavoriteCharacters.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(characters: List<CharacterDataBaseModel>) {
        this.mFavoriteCharacters = characters
        notifyDataSetChanged()
    }

    fun deleteCharacter(id: Int)  {

    }


}