package com.example.homework4android3.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homework4android3.R
import com.example.homework4android3.databinding.FragmentFirstBinding
import com.example.homework4android3.ui.adapter.AnimeAdapter

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding get() = _binding!!
    private val adapter = AnimeAdapter()
    private val viewModel by viewModels<SecondViewModels>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribe()
        initialize()
    }

    private fun subscribe() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) {
            Log.e("bleach", "subscribe: ${it.success}")
            adapter.setCharacter(it.success!!)
        }
    }

    private fun initialize() = with(binding) {
        rvCharacter.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}