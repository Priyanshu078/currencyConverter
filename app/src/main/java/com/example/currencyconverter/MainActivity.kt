package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convertButton.setOnClickListener {
            val convertedValue = convert()
            val checkedId = binding.radioGroup.checkedRadioButtonId
            val unit = when(checkedId){
                R.id.rupeetoDollar -> "dollars"
                R.id.dollarToRupee -> "rupees"
                R.id.rupeetoEuro -> "euros"
                R.id.euroToRupee -> "rupees"
                R.id.RupeeToYen -> "yen"
                R.id.YenTORupee -> "rupees"
                R.id.dollarsToEuro -> "euros"
                else -> {
                    "dollars"
                }
            }
            val convertedText = "$convertedValue $unit"
            binding.convertedCurrency.text = convertedText
        }
    }

    fun convert():Double{
        val value = if(binding.valuesEditText.text.toString() != ""){
            binding.valuesEditText.text.toString().toDouble()
        }
        else{
            0.0
        }
        val checkedId = binding.radioGroup.checkedRadioButtonId
        val conversionFactor = when(checkedId){
            R.id.rupeetoDollar -> 0.013
            R.id.dollarToRupee -> 75.80
                R.id.rupeetoEuro -> 0.012
            R.id.euroToRupee -> 85.63
                R.id.RupeeToYen -> 1.50
                R.id.YenTORupee -> 0.67
                R.id.dollarsToEuro -> 0.89
            else -> {
                1.13
            }
        }

        return "%.2f".format(value*conversionFactor).toDouble()
    }
}