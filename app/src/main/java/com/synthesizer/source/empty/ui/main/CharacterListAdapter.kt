package com.synthesizer.source.empty.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.synthesizer.source.empty.data.mapper.Character
import com.synthesizer.source.empty.databinding.ItemCharacterListBinding
import com.synthesizer.source.empty.ui.main.CharacterListAdapter.CustomViewHolder
import com.synthesizer.source.empty.utils.load

class CharacterListAdapter : ListAdapter<Character, CustomViewHolder>(DIFF) {

    var itemClickListener: (id: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterListBinding.inflate(inflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CustomViewHolder(private val binding: ItemCharacterListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character) {
            binding.apply {
                photo.load(item.image)
                name.text = item.name
                status.text = item.status
                root.setOnClickListener {
                    itemClickListener(item.id)
                }
            }
        }
    }

    object DIFF : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(
            oldItem: Character,
            newItem: Character
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Character,
            newItem: Character
        ): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }
}