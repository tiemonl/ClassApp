package com.kroger.classapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kroger.classapp.R
import com.kroger.classapp.databinding.CharacterCardViewBinding
import com.kroger.classapp.model.RickAndMortyCharacter

class RickAndMortyCharacterAdapter(
    private val characters: List<RickAndMortyCharacter>,
    private val onCharacterClicked: (position: Int) -> Unit,
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
            binding.characterAge.text =
                binding.root.context.getString(R.string.character_age, character.age)
            binding.characterTitle.text =
                binding.root.context.getString(R.string.character_name, character.name)
            Glide.with(binding.root).load(character.picture).into(binding.characterImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RickAndMortyCharacterViewHolder {
        val binding =
            CharacterCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickAndMortyCharacterViewHolder(binding) { position ->
            onCharacterClicked(position)
        }
    }

    override fun getItemCount() = characters.size


    override fun onBindViewHolder(holder: RickAndMortyCharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }
}
