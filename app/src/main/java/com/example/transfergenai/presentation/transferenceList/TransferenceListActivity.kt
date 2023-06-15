package com.example.transfergenai.presentation.transferenceList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transfergenai.databinding.TransferenceListActivityBinding
import com.example.transfergenai.presentation.viewmodel.TransferencesViewModel

class TransferenceListActivity : AppCompatActivity() {

    private lateinit var binding: TransferenceListActivityBinding
    private val viewModel: TransferencesViewModel by lazy {
        TransferencesViewModel()
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
                //Set the adapter to the recycler view
            }
            transferenceByIdLiveData.observe(this@TransferenceListActivity) {

            }
        }
    }

    //TODO -- TERMINAR DE FAZER O CONTEÚDO QUE MOSTRA A LISTAGEM (VIEWMODEL, VIEWHOLDER E ADAPTER FEITOS)

    //Create a function to setup the recycler view adapter receiving a list of TransferenceModel as parameter
    private fun updateList() {
        binding.transferenceList.apply {
            adapter = TransferenceListAdapter(
                listOf(),
                onItemClicked = { transactionId ->
                    //Call the viewModel function to get the transference by id
                }
            )
        }
    }

    //Create the function to get the data from TransferencesView.ModelgetTransferences(context) and set the adapter
    //to the recycler view
    private fun getTransferences() {

    }
}
