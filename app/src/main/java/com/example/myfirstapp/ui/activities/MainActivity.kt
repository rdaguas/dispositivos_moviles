package com.example.myfirstapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myfirstapp.data.repository.ListUsers
import com.example.myfirstapp.logic.usercases.LoginUserCase
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.logic.usercases.GetAllUsersUserCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //lateinit : es un tipo de inicializacion
    private lateinit var binding: ActivityMainBinding


    //en kotlin "fun" es una palabra reservada para funciones
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()

    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                GetAllUsersUserCase().invoke()
            }


        }
    }
}

