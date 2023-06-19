package com.example.transfergenai.domain.mappers

import com.example.transfergenai.domain.model.TransferenceItemModel
import com.example.transfergenai.domain.model.TransferenceModel

class TransferenceMapper {
    private fun toItem(TransferenceModel: TransferenceModel): TransferenceItemModel {
        return TransferenceItemModel(
            transaction_id = TransferenceModel.transaction_id,
            sender_name = TransferenceModel.sender_name,
            date = TransferenceModel.timestamp,
            amount = TransferenceModel.amount
        )
    }

    fun toList(transferenceModelList: List<TransferenceModel>): List<TransferenceItemModel> {
        return transferenceModelList.map(::toItem)
    }
}