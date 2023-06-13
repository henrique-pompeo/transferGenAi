package com.example.transfergenai.domain.model

// Implement the fields transaction_id, sender_name, sender_account, amount, currency, timestamp and type
data class TransferenceModel(
    val transaction_id: String,
    val sender_name: String,
    val sender_account: String,
    val amount: String,
    val currency: String,
    val timestamp: String,
    val type: String
)
