package com.aguas.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aguas.myapplication.databinding.ItemNobelBinding

class DetailItemActivity : AppCompatActivity() {

    private lateinit var binding: ItemNobelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemNobelBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}