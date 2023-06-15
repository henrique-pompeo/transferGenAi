package com.example.transfergenai.domain.model

// Implement the fields transaction_id, sender_name, date and amount inside data class TransferenceItemModel
data class TransferenceItemModel(
    val transaction_id: String,
    val sender_name: String,
    val date: String,
    val amount: String
)
