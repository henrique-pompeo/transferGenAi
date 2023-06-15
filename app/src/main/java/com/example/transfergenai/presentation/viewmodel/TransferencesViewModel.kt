package com.example.transfergenai.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.transfergenai.domain.model.TransferenceModel
import org.json.JSONArray

class TransferencesViewModel {

    private val _transferencesLiveData = MutableLiveData<List<TransferenceModel>>()
    val transferencesListLiveData: LiveData<List<TransferenceModel>> get() = _transferencesLiveData

    private val _transferenceByIdLiveData = MutableLiveData<TransferenceModel?>()
    val transferenceByIdLiveData: LiveData<TransferenceModel?> get() = _transferenceByIdLiveData

    //Implement the function to get the transferences from transfereces.json inside assets folder
    //and return a List<TransferenceModel>
    fun getTransferences(context: Context) {
        val transferences = context.assets.open(TRANSFERENCES_FILE).bufferedReader().use {
            it.readText()
        }

        //Parse the transference json to a list of TransferenceModel objects
        val jsonArray = JSONArray(transferences)
        val transferenceList: MutableList<TransferenceModel> = mutableListOf()

        //Iterate the json array and add each object to the list
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            transferenceList.add(
                TransferenceModel(
                    jsonObject.getString(TRANSACTION_ID),
                    jsonObject.getString(SENDER_NAME),
                    jsonObject.getString(SENDER_ACCOUNT),
                    jsonObject.getString(AMOUNT),
                    jsonObject.getString(CURRENCY),
                    jsonObject.getString(TIMESTAMP),
                    jsonObject.getString(TYPE)
                )
            )
        }

        //Return the list
        _transferencesLiveData.value = transferenceList
    }

    //Based on getTransferences function, implement the function to get the transference by transactionId
    //and return a TransferenceModel
    fun getTransferenceById(context: Context, transactionId: String) {
        val transferences = context.assets.open(TRANSFERENCES_FILE).bufferedReader().use {
            it.readText()
        }

        //Parse the transference json to a list of TransferenceModel objects
        val jsonArray = JSONArray(transferences)
        var transferenceModel: TransferenceModel? = null

        //Iterate the json array and add each object to the list
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            if (jsonObject.getString(TRANSACTION_ID) == transactionId) {
                transferenceModel = TransferenceModel(
                    jsonObject.getString(TRANSACTION_ID),
                    jsonObject.getString(SENDER_NAME),
                    jsonObject.getString(SENDER_ACCOUNT),
                    jsonObject.getString(AMOUNT),
                    jsonObject.getString(CURRENCY),
                    jsonObject.getString(TIMESTAMP),
                    jsonObject.getString(TYPE)
                )
            }
        }

        //Return the list
        _transferenceByIdLiveData.value = transferenceModel
    }

    companion object {
        private const val TRANSFERENCES_FILE = "transferences.json"
        private const val TRANSACTION_ID = "transaction_id"
        private const val SENDER_NAME = "sender_name"
        private const val SENDER_ACCOUNT = "sender_account"
        private const val AMOUNT = "amount"
        private const val CURRENCY = "currency"
        private const val TIMESTAMP = "timestamp"
        private const val TYPE = "type"
    }
}