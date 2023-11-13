package com.example.fuelondemand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.fuelondemand.databinding.ActivityChooseLocationBinding


class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationlist = arrayOf("Chandigarh","Ludhiana","Delhi","Amritsar")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationlist)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)

    }
}