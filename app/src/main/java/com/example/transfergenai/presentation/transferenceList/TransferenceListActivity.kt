package com.example.transfergenai.presentation.transferenceList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transfergenai.databinding.TransferenceListActivityBinding
import com.example.transfergenai.domain.mappers.TransferenceMapper
import com.example.transfergenai.domain.model.TransferenceModel
import com.example.transfergenai.presentation.transferenceDetails.TransferenceDetailsActivity
import com.example.transfergenai.presentation.viewmodel.TransferencesViewModel

class TransferenceListActivity : AppCompatActivity() {

    private lateinit var binding: TransferenceListActivityBinding

    private val viewModel: TransferencesViewModel by lazy {
        TransferencesViewModel()
    }

    private val mapper: TransferenceMapper by lazy {
        TransferenceMapper()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransferenceListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        getTransferences()
    }

    private fun setupObservers() {
        with(viewModel) {
            transferencesListLiveData.observe(this@TransferenceListActivity) {
                updateList(it)
            }
        }
    }

    private fun getTransferences() {
        //Call the viewModel function to get the transferences
        viewModel.getTransferences(this)
    }

    //Create a function to setup the recycler view adapter receiving a list of TransferenceModel as parameter
    private fun updateList(transferenceModelList: List<TransferenceModel>) {
        binding.transferenceList.apply {
            adapter = TransferenceListAdapter(
                mapper.toList(transferenceModelList),
                onItemClicked = { transactionId ->
                    openTransferenceDetails(transactionId)
                }
            )
        }
    }

    //Create a function in which will receive th transactionId and open transferenceDetailsActivity passing the transactionId as parameter
    private fun openTransferenceDetails(transactionId: String) {
        //Implement the intent to open transferenceDetailsActivity passing the transactionId as parameter
        TransferenceDetailsActivity.getIntent(this, transactionId).also {
            startActivity(it)
        }
    }
}
