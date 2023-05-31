package com.example.homework2_android3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2_android3.databinding.ItemEpisodeBinding
import com.example.homework2_android3.models.EpisodeModel

class EpisodeAdapter(private val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(absoluteAdapterPosition + 1)
            }
        }

        fun onBind(episodeModel: EpisodeModel?) {
            binding.tvEpisode.text = episodeModel?.episode
            binding.tvEpisodeName.text = episodeModel?.name
            binding.tvAirDate.text = episodeModel?.air_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(
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

        class DiffUtilCallback() : DiffUtil.ItemCallback<EpisodeModel>() {

            override fun areItemsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}