package com.example.unit2tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.unit2tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickCalculate()
    }

    private fun onClickCalculate() {
        binding.btnCalculate.setOnClickListener {
            binding.tvTipAmount.text = getString(R.string.tip_amount, formatTip())
        }
    }

    private fun formatTip(): String {
        return NumberFormat.getCurrencyInstance().format(calculateTip())
    }


    private fun calculateTip(): Double {
        val tipPercentage: Double
        val serviceCost: Double? = binding.etCost.text.toString().toDoubleOrNull()
        val selectedRbId: Int = binding.rgService.checkedRadioButtonId

        if (serviceCost == null) return 0.0

        tipPercentage = when (selectedRbId) {
            R.id.rbAmazing -> 0.2
            R.id.rbGood -> 0.18
            R.id.rbOkay -> 0.15
            else -> 0.0
        }

        var tip: Double = serviceCost * tipPercentage
        if (binding.swRoundUp.isChecked) tip = ceil(tip)

        return tip
    }
}