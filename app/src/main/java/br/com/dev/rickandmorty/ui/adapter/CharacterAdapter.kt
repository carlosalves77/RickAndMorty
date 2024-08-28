package br.com.dev.rickandmorty.ui.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.dev.rickandmorty.R
import br.com.dev.rickandmorty.data.model.Result
import br.com.dev.rickandmorty.databinding.CharacterRowBinding
import coil.load

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    private var mCharacters = listOf<Result>()

    inner class MyViewHolder(val binding: CharacterRowBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.MyViewHolder {

        val binding =
            CharacterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CharacterAdapter.MyViewHolder, position: Int) {
        val currentCharacters = this.mCharacters[position]

        holder.binding.apply {

            characterName.text = currentCharacters.name
            characterSpecie.text = currentCharacters.species
            characterImage.load(currentCharacters.image) {
                crossfade(true)
                crossfade(1000)
            }
            cardContainer.setOnClickListener { view ->
                val bundle = Bundle()
                bundle.putString("characterName", currentCharacters.name)
                bundle.putString("characterSpecie", currentCharacters.species)
                bundle.putString("characterImage", currentCharacters.image)
                bundle.putString("characterStatus", currentCharacters.status)
                bundle.putString("characterGender", currentCharacters.gender)
                bundle.putString("characterCreated", currentCharacters.created)

                view.findNavController().navigate(R.id.action_homeScreenFragmentScreen_to_detailCharacterScreen, bundle)

            }

            val isFavorite = false

            if (isFavorite) {
                favoriteStar.setImageResource(R.drawable.favorite_green_star)
            } else {
                favoriteStar.setImageResource(R.drawable.favorite_outline_star)
            }
        }

    }

    override fun getItemCount() = mCharacters.size


    @SuppressLint("NotifyDataSetChanged")
    fun setData(characters: List<Result>) {
        Log.d("Adapter", "setData called with ${characters} items")
        this.mCharacters = characters
        notifyDataSetChanged()
    }

}