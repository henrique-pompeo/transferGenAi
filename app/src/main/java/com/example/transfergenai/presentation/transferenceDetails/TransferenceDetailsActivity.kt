package com.example.transfergenai.presentation.transferenceDetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transfergenai.databinding.ActivityTransferenceDetailsBinding
import com.example.transfergenai.domain.model.TransferenceModel
import com.example.transfergenai.presentation.viewmodel.TransferencesViewModel

class TransferenceDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransferenceDetailsBinding

    private val transactionId: String? by lazy {
        intent.getStringExtra(TRANSACTION_ID)
    }

    private val viewModel: TransferencesViewModel by lazy {
        TransferencesViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransferenceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        getTransferenceById()
    }

    private fun setupObservers() {
        with(viewModel) {
            transferenceByIdLiveData.observe(this@TransferenceDetailsActivity) {
                it?.let {
                    updateViews(it)
                }
            }
        }
    }

    private fun updateViews(transferenceModel: TransferenceModel) {
        with(binding) {
            //Set the value of the text views with the data from transferenceModel
            value.text = transferenceModel.amount
            senderName.text = transferenceModel.sender_name
            senderAccount.text = transferenceModel.sender_account
            date.text = transferenceModel.timestamp
        }
    }

    private fun getTransferenceById() {
        //Call the viewModel function to get the transference by id
        transactionId?.let {
            viewModel.getTransferenceById(this, it)
        }
    }

    companion object {
        const val TRANSACTION_ID = "transaction_id"

        fun getIntent(context: Context, transactionId: String): Intent {
            return Intent(context, TransferenceDetailsActivity::class.java).apply {
                putExtra(TRANSACTION_ID, transactionId)
            }
        }
    }
}