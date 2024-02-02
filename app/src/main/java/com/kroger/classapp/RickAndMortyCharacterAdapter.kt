package com.kroger.classapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RickAndMortyCharacterAdapter(private val characters: List<RickAndMortyCharacter>) :
    RecyclerView.Adapter<RickAndMortyCharacterAdapter.RickAndMortyCharacterViewHolder>() {

    class RickAndMortyCharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_title)
        val characterAge: TextView = itemView.findViewById(R.id.character_description)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = RickAndMortyCharacterViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.character_card_view, parent, false),
    )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: RickAndMortyCharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.characterName.text = character.name
        holder.characterAge.text = character.age.toString()
        holder.characterImage.setImageResource(character.picture)
    }
}
