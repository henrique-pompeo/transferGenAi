package com.example.transfergenai.presentation.transferenceList

import androidx.recyclerview.widget.RecyclerView
import com.example.transfergenai.databinding.TransferenceItemBinding
import com.example.transfergenai.domain.model.TransferenceItemModel

class TransferenceListViewHolder(
    private val binding: TransferenceItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    //Create a function called bind to receive a TransferenceItemModel object and the onItemClicked function
    fun bind(
        transferenceItemModel: TransferenceItemModel,
        onItemClicked: (String) -> Unit
    ) {
        with(binding) {
            //Set the sender_name, amount and date text to the views
            //Set the on click listener to the root view
            senderName.text = transferenceItemModel.sender_name
            amount.text = transferenceItemModel.amount
            date.text = transferenceItemModel.date
            root.setOnClickListener {
                onItemClicked(transferenceItemModel.transaction_id)
            }
        }
    }

}