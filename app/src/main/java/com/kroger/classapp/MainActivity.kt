package com.kroger.classapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characters = mutableListOf<RickAndMortyCharacter>()

        for (i in 0..30) {
            characters.add(createCharacter(i))
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RickAndMortyCharacterAdapter(characters)
    }

    private fun createCharacter(id: Int) = RickAndMortyCharacter(
        name = "Ray Reid",
        picture = R.drawable.ic_launcher_background,
        age = Random.nextInt(10, 99),
        id = id,
        planet = "patrioque",
        relation = listOf(),
    )
}
