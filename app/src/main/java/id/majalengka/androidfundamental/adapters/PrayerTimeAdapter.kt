package id.majalengka.androidfundamental.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.majalengka.androidfundamental.databinding.ListItemPrayerTimeBinding
import id.majalengka.androidfundamental.model.Item

class PrayerTimeAdapter: ListAdapter<Item, PrayerTimeAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemPrayerTimeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data  = getItem(position)
        holder.apply {
            bind(data)
        }
    }

    class ViewHolder(private val binding: ListItemPrayerTimeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Item){
            binding.apply {
                item = data
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback: DiffUtil.ItemCallback<Item>(){
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.date_for == newItem.date_for
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}