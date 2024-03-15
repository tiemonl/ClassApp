package com.kroger.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kroger.classapp.R
import com.kroger.classapp.databinding.FragmentCharacterListBinding
import com.kroger.classapp.ui.adapter.RickAndMortyCharacterAdapter
import com.kroger.classapp.model.RickAndMortyCharacter
import com.kroger.classapp.viewmodel.RickAndMortyCharacterViewModel
import kotlin.random.Random

class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    private val rickAndMortyCharacterViewModel: RickAndMortyCharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.recyclerView
        val characters = rickAndMortyCharacterViewModel.fillData()

        val adapter = RickAndMortyCharacterAdapter(characters) { position ->
            val character = characters[position]
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, CharacterDetailFragment.newInstance(character.id))
                addToBackStack(null)
            }
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }

        return binding.root
    }
}
