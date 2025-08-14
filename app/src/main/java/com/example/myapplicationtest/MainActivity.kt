package com.example.myapplicationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val allowedKeys = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "#")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvent()
    }

    private fun setEvent() {
        val buttons = listOf(
            binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9,
            binding.btnStar, binding.btn0, binding.btnHash
            )

        buttons.forEach { btn ->
            btn.setOnClickListener {
                val value = btn.text.toString()
                if (allowedKeys.contains(value)) {
                    binding.tvInput.text = binding.tvInput.text.toString() + value
                }
            }
        }

        binding.btnDelete.setOnClickListener {
            val current = binding.tvInput.text.toString()
            if(current.isNotEmpty()) {
                binding.tvInput.text = current.dropLast(1)
            }
        }
    }
}