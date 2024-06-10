package com.ramos.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramos.myapplication.databinding.ItemNasaBinding

class DetailItemActivity : AppCompatActivity() {

    private lateinit var binding: ItemNasaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemNasaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}