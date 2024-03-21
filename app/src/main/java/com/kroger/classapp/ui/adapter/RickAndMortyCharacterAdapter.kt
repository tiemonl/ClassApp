package com.kroger.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kroger.classapp.R
import com.kroger.classapp.databinding.CharacterCardViewBinding
import com.kroger.classapp.model.RickAndMortyCharacter

class RickAndMortyCharacterAdapter(
    private val onCharacterClicked: (character: RickAndMortyCharacter, position: Int) -> Unit,
) : RecyclerView.Adapter<RickAndMortyCharacterAdapter.RickAndMortyCharacterViewHolder>() {

    inner class RickAndMortyCharacterViewHolder(
        private val binding: CharacterCardViewBinding,
        private val onCharacterClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onCharacterClicked(adapterPosition)
            }
        }

        fun bind(character: RickAndMortyCharacter) {
            binding.characterTitle.text = binding.root.context.getString(R.string.character_name, character.name)
            Glide.with(binding.root).load(character.image).into(binding.characterImage)
        }
    }

    private val rickAndMortyCharacters = mutableListOf<RickAndMortyCharacter>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(characters: List<RickAndMortyCharacter>) {
        rickAndMortyCharacters.clear()
        rickAndMortyCharacters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RickAndMortyCharacterViewHolder {
        val binding =
            CharacterCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickAndMortyCharacterViewHolder(binding) { position ->
            onCharacterClicked(rickAndMortyCharacters[position], position)
        }
    }

    override fun getItemCount() = rickAndMortyCharacters.size

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: RickAndMortyCharacterViewHolder, position: Int) {
        val character = rickAndMortyCharacters[position]
        holder.bind(character)
    }
}
