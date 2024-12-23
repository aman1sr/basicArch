package com.aman.basearchsetup

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.aman.basearchsetup.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

const val TAG = "BASE_ARCH_d"

class MainActivity : AppCompatActivity() {
    val viewModel: NewsViewModel by viewModels()
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        observeData()
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel?.data?.collect {
                // observe data here
            }
        }
    }
}