package com.example.converter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private  val dirham="DH"
    private  val dollar="American dollar"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn: Button = findViewById(R.id.button)
        val amount: TextInputEditText = findViewById(R.id.amount)
        val result: TextInputEditText = findViewById(R.id.result)

        val select1: AutoCompleteTextView = findViewById(R.id.select1)
        val select2: AutoCompleteTextView = findViewById(R.id.select2)

        val list = listOf(dirham, dollar)
        val adapter = ArrayAdapter(this, R.layout.choix, list)
        select1.setAdapter(adapter)
        select2.setAdapter(adapter)

        btn.setOnClickListener {
            val a = amount.text.toString().toDouble()
            var res: Double = 0.0

            val value1 =select1.text.toString()
            val value2 =select2.text.toString()
            when (value1) {
                dirham-> when (value2) {
                    dirham -> res = a
                    dollar -> res = a.times(0.091)
                }
                dollar -> when (value2) {
                    dollar -> res = a
                    dirham -> res = a.times(10.91)
                }

            }
            result.setText(res.toString())


        }
    }
}


