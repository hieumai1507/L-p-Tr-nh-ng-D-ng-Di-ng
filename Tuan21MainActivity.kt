package com.example.tuan21.ui.theme.tuan21

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tuan21.R

class Tuan21MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tuan21_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txt1=findViewById<TextView>(R.id.Tuan21txt1);
        var txt2=findViewById<TextView>(R.id.Tuan21txt2);
        var btn1=findViewById<Button>(R.id.tuan21btn1);
        btn1!!.setOnClickListener(View.OnClickListener {
            var i =Intent(this@Tuan21MainActivity, Tuan21MainActivityResult::class.java)
            i.putExtra("so1", txt1!!.text.toString())
            i.putExtra("so2", txt2!!.text.toString())
            startActivity(i)
        })
    }
}