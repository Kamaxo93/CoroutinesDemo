package com.example.coroutinesdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutinesdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var count = 0
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            btnCount.setOnClickListener {
                tvCount.text = count++.toString()
            }
            btnDownloadUserData.setOnClickListener {
                //CoroutinesScope para crear la corrutina
                CoroutineScope(Dispatchers.Main).launch {
                    tvUserMessage.text = UserDataManagerStructure().getTotalUserCount().toString()
                }
            }
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}