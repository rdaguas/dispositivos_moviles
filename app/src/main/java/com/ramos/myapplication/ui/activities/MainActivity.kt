package com.ramos.myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ramos.myapplication.data.local.repository.ListUsers
import com.ramos.myapplication.logic.LoginUserCase
import com.ramos.myapplication.databinding.ActivityMainBinding
import com.ramos.myapplication.logic.userCases.GetAllUsersUserCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //varianble de tipo binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        initListeners()
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                GetAllUsersUserCase().invoke()
            }
//            var loginUserCase = LoginUserCase(ListUsers())

//            // Llamo a la funcion de la clase de forma muuuuuuy explícita
//            var result = loginUserCase(
//                binding.etxtUser.text.toString(),
//                binding.etxtPass.text.toString()
//            )
//
//            // Funciones lambda en vez de un condicional if
//            result.onSuccess {
//                user -> var intentToConstrainAct =
//                    Intent(this,
//                        ConstrainActivity::class.java)
//                        .apply {
//                            putExtra("idUser", user.id)
//                        }
//
//                startActivity(intentToConstrainAct)
//            }
//
//            result.onFailure {
//                Toast.makeText(
//                    this, "Credenciales incorrectas, no sea imbecil",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("UCE", "Metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("UCE", "Metodo onResume")
    }

}