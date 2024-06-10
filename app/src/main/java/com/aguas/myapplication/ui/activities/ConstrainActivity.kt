package com.aguas.myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.aguas.myapplication.databinding.ActivityConstrainBinding
import com.aguas.myapplication.logic.userCases.GetPremiosNobelUserCase
import com.aguas.myapplication.ui.adapters.PremiosNobelAdapter
import com.aguas.myapplication.ui.entities.PremiosNobelDataUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConstrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConstrainBinding
    private var items: MutableList<PremiosNobelDataUI> = mutableListOf()
    private lateinit var nobelAdapter: PremiosNobelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVariables()
        initListeners()
        initData()
    }

    private fun initVariables() {
        nobelAdapter = PremiosNobelAdapter { descriptionItem(it) }
        binding.rvNobel.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNobel.adapter = nobelAdapter
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
                val resultItems = GetPremiosNobelUserCase().invoke()
                Log.d("ConstrainActivity", "API Result: $resultItems")
                withContext(Dispatchers.Main) {
                    binding.pgbarLoadData.visibility = View.INVISIBLE
                    resultItems.onSuccess {
                        Log.d("ConstrainActivity", "Success: $it")
                        items = it.toMutableList()
                        nobelAdapter.itemList = items
                        nobelAdapter.notifyDataSetChanged()
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

    private fun descriptionItem(data: PremiosNobelDataUI) {
        Snackbar.make(binding.rvNobel, "Premios Noveel", Snackbar.LENGTH_LONG).show()
        val intent = Intent(this, DetailItemActivity::class.java)
        startActivity(intent)
    }
}
