package com.kroger.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kroger.classapp.R
import com.kroger.classapp.databinding.FragmentCharacterListBinding
import com.kroger.classapp.ui.adapter.RickAndMortyCharacterAdapter
import com.kroger.classapp.model.RickAndMortyCharacter
import com.kroger.classapp.viewmodel.RickAndMortyCharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    private val rickAndMortyCharacterViewModel: RickAndMortyCharacterViewModel by activityViewModels()
    private val characterAdapter = RickAndMortyCharacterAdapter { character, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, CharacterDetailFragment.newInstance(character.id))
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
        rickAndMortyCharacterViewModel.fillData()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            rickAndMortyCharacterViewModel.characters.collect { event ->
                when (event) {
                    RickAndMortyCharacterViewModel.RickAndMortyCharacterEvent.Failure -> {
                        binding.progressBar.isVisible = false
                        binding.recyclerView.isVisible = false
                        binding.errorMessage.isVisible = true
                    }

                    RickAndMortyCharacterViewModel.RickAndMortyCharacterEvent.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.recyclerView.isVisible = false
                        binding.errorMessage.isVisible = false
                    }

                    is RickAndMortyCharacterViewModel.RickAndMortyCharacterEvent.Success -> {
                        characterAdapter.refreshData(event.characters)
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = false
                        binding.recyclerView.isVisible = true
                    }
                }
            }
        }
    }
}
