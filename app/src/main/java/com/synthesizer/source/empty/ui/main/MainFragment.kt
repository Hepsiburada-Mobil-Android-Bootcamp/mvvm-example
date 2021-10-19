package com.synthesizer.source.empty.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.synthesizer.source.empty.R
import com.synthesizer.source.empty.data.api.RetrofitBase
import com.synthesizer.source.empty.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val binding: FragmentMainBinding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private val viewModel = MainViewModel(RetrofitBase.service,"message")
    private val adapter = CharacterListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.characters.adapter = adapter
        adapter.itemClickListener = {
            navigateToDetail(it)
        }

        viewModel.characterList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun navigateToDetail(id: Int) {
        if (findNavController().currentDestination?.id != R.id.mainFragment) return
        val action = MainFragmentDirections.showDetail(id)
        findNavController().navigate(action)
    }
}