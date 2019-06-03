package com.example.bkbapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bkbapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_new_partido.setOnClickListener {
            val intent = Intent(this, nuevo_partido::class.java)
            startActivity(intent)
       }

        bt_list_partido.setOnClickListener {
            val intent2 = Intent(this, listado_partidos::class.java)
            startActivity(intent2)
        }
    }
}
