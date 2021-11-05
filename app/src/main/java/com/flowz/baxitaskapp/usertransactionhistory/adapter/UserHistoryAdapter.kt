package com.flowz.baxitaskapp.usertransactionhistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.flowz.baxitaskapp.R
import com.flowz.baxitaskapp.databinding.TransactionHistoryListItemBinding
import com.flowz.baxitaskapp.usertransactionhistory.data.local.DataX


typealias urlListener = (item: DataX) -> Unit


class UserHistoryAdapter  (val listener: urlListener) :ListAdapter<DataX, UserHistoryAdapter.ImageViewHolder>(UserHistoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  ImageViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.transaction_history_list_item, parent, false)

        return ImageViewHolder(TransactionHistoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)) {
            getItem(it)?.let{item-> listener(item)}
        }

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        val currentItem = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                transactionDescription.text = currentItem.transactionDescription
                transactionDate.text = currentItem.transactionDate.format()
                transactionAmount.text = currentItem.transactionAmount.toString()

            }
        }
    }

    inner class ImageViewHolder(val binding: TransactionHistoryListItemBinding, private val listener: (Int)-> Unit): RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {
                listener(absoluteAdapterPosition)
            }
        }
    }

}