package com.example.transfergenai.presentation.transferenceList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transfergenai.databinding.TransferenceListActivityBinding

class TransferenceListActivity : AppCompatActivity() {

    private lateinit var binding: TransferenceListActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransferenceListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
