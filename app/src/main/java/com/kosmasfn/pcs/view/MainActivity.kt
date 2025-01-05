package com.kosmasfn.pcs.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kosmasfn.pcs.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ViewModel by viewModels()
    private val adapter by lazy { TestAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserver()
        initAdapter()
        viewModel.fetchData()
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchData()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            lifecycleScope.launch {
                viewModel.isLoading.collect { data ->
//                showMessage(data)
//                showLoading(false)
                }
            }
            viewModel.errorMessage.collect { data ->
//                showMessage(data)
//                showLoading(false)
            }
        }
        lifecycleScope.launch {
            viewModel.data.collect { data ->
//                showMessage(data)
//                showLoading(false)
                adapter.addItems(data)
            }
        }
    }

    private fun initAdapter() {
        binding.rvData.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvData.adapter = adapter
    }
}