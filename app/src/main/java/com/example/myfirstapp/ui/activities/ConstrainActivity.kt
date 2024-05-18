package com.example.myfirstapp.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.databinding.ActivityConstrainBinding

class ConstrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConstrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var idUser: Int? = null
        intent.extras?.let { dato ->
            idUser = dato.getInt("idUser")
        }
        if (idUser != null) {
            binding.editTextText2.text = idUser.toString()
        } else {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
        }


    }

}