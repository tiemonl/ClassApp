package com.kroger.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.kroger.classapp.databinding.FragmentCharacterDetailBinding
import com.kroger.classapp.viewmodel.RickAndMortyCharacterViewModel

class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    private val rickAndMortyCharacterViewModel: RickAndMortyCharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
//            val character = rickAndMortyCharacterViewModel.fetchById(
//                requireArguments().getInt(
//                    BUNDLE_ID
//                )
//            )
//            binding.characterNameDetail.text = character.name
//            Glide.with(this).load(character.image).into(binding.characterImageDetail)
        }
        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "character_id"

        fun newInstance(id: Int) = CharacterDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }

}