package com.ramos.myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ramos.myapplication.databinding.ActivityConstrainBinding
import com.ramos.myapplication.logic.userCases.GetNasaPhotosUserCase
import com.ramos.myapplication.ui.adapters.NasaAdapter
import com.ramos.myapplication.ui.entities.NasaDataUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConstrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConstrainBinding
    private var items: MutableList<NasaDataUI> = mutableListOf()
    private lateinit var nasaAdapter: NasaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVariables()
        initListeners()
        initData()
    }

    private fun initVariables() {
        nasaAdapter = NasaAdapter { descriptionItem(it) }
        binding.rvNasaPhotos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNasaPhotos.adapter = nasaAdapter
    }

    private fun initListeners() {
        binding.refreshRV.setOnRefreshListener {
            initData()
            binding.refreshRV.isRefreshing = false
        }
    }

    private fun initData() {
        binding.pgbarLoadData.visibility = View.VISIBLE
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val resultItems = GetNasaPhotosUserCase().invoke()
                Log.d("ConstrainActivity", "API Result: $resultItems")
                withContext(Dispatchers.Main) {
                    binding.pgbarLoadData.visibility = View.INVISIBLE
                    resultItems.onSuccess {
                        Log.d("ConstrainActivity", "Success: $it")
                        items = it.toMutableList()
                        nasaAdapter.itemList = items
                        nasaAdapter.notifyDataSetChanged()
                    }
                    resultItems.onFailure {
                        showError(it.message.toString())
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    binding.pgbarLoadData.visibility = View.INVISIBLE
                    Log.e("ConstrainActivity", "Error fetching data", e)
                    showError(e.message.toString())
                }
            }
        }
    }

    private fun showError(message: String) {
        Snackbar.make(binding.refreshRV, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun descriptionItem(data: NasaDataUI) {
        Snackbar.make(binding.rvNasaPhotos, "nasaaaaaaa", Snackbar.LENGTH_LONG).show()
        val intent = Intent(this, DetailItemActivity::class.java)
        startActivity(intent)
    }
}
