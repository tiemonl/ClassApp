package com.kroger.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val characters = mutableListOf<RickAndMortyCharacter>()

        val characterNames = listOf("Rick", "Morty", "Summer", "Beth")

        val characterImages = listOf(
            "https://rickandmortyapi.com/api/character/avatar/100.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/23.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/26.jpeg",
            "https://rickandmortyapi.com/api/character/avatar/24.jpeg",
            )

        for (i in 0..30) {
            characters.add(createCharacter(i, characterNames.random(), characterImages.random()))
        }

        val adapter = RickAndMortyCharacterAdapter(characters)
        recyclerView.adapter = adapter

        return view
    }

    private fun createCharacter(id: Int, name: String, image: String) = RickAndMortyCharacter(
        name = name,
        picture = image,
        age = Random.nextInt(10, 99),
        id = id,
        planet = "patrioque",
        relation = listOf(),
    )
}
