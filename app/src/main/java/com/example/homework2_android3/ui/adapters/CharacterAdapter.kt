package com.example.homework2_android3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework2_android3.ProgressTarget
import com.example.homework2_android3.databinding.ItemCharacterBinding
import com.example.homework2_android3.models.CharacterModel

class CharacterAdapter(private val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<CharacterModel, CharacterAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(absoluteAdapterPosition + 1)
            }
        }


        fun onBind(characterModel: CharacterModel?) {

            binding.textViewNameHero.text = characterModel?.name
            binding.itemCharacterStatus.text = characterModel?.status
            binding.itemCharacterSpecies.text = characterModel?.species

            val progressTarget = ProgressTarget(binding.progressBar, binding.imageViewHero)

            Glide.with(binding.imageViewHero)
                .load(characterModel?.image)
                .into(progressTarget)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        class DiffUtilCallback() : DiffUtil.ItemCallback<CharacterModel>() {

            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
