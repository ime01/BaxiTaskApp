package com.flowz.baxitaskapp.usertransactionhistory.adapter

import androidx.recyclerview.widget.DiffUtil
import com.flowz.baxitaskapp.usertransactionhistory.data.local.DataX


class UserHistoryDiffCallback : DiffUtil.ItemCallback<DataX>(){
    override fun areItemsTheSame(oldItem: DataX, newItem:DataX): Boolean {
        return oldItem.id == newItem.id
    }
    override fun areContentsTheSame(oldItem:DataX, newItem: DataX): Boolean {
        return oldItem == newItem
    }
}