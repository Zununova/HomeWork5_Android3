package com.example.homework2_android3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2_android3.databinding.ItemLocationBinding
import com.example.homework2_android3.models.LocationModel

class LocationAdapter(private val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<LocationModel, LocationAdapter.ViewHolder>(DiffUtilCallback()) {

    inner class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(absoluteAdapterPosition + 1)
            }
        }

        fun onBind(locationModel: LocationModel?) {
            binding.textViewLocation.text = locationModel?.name
            binding.tvTypeLocation.text = locationModel?.type
            binding.tvIdLocation.text = locationModel?.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(
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

        class DiffUtilCallback : DiffUtil.ItemCallback<LocationModel>() {

            override fun areItemsTheSame(oldItem: LocationModel, newItem: LocationModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
