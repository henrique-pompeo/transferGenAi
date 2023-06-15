package com.example.transfergenai.presentation.transferenceList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.transfergenai.databinding.TransferenceItemBinding
import com.example.transfergenai.domain.model.TransferenceItemModel

class TransferenceListAdapter(
    private val transferenceList: List<TransferenceItemModel>,
    private val onItemClicked: (String) -> Unit
) : RecyclerView.Adapter<TransferenceListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferenceListViewHolder {
        return TransferenceListViewHolder(
            TransferenceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = transferenceList.size

    override fun onBindViewHolder(holder: TransferenceListViewHolder, position: Int) {
        holder.bind(transferenceList[position], onItemClicked)
    }
}