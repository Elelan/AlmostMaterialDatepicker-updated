package com.shagi.example

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shagi.example.databinding.ActivityMainBinding
import com.shagi.materialdatepicker.date.DatePickerFragmentDialog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val dialog = DatePickerFragmentDialog.newInstance({ view, year, monthOfYear, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, monthOfYear, dayOfMonth)

                val simpleDateFormat = SimpleDateFormat("yyyy-MMM-dd", Locale.getDefault())

                Toast.makeText(applicationContext, simpleDateFormat.format(calendar.time), Toast.LENGTH_SHORT).show()
            }, 2017, 11, 4)
            dialog.show(supportFragmentManager, "tag")
        }
    }
}
