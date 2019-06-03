package com.example.bkbapp.activities

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bkbapp.R
import com.example.bkbapp.activities.fragmentos.fragmento_detalle
import com.example.bkbapp.activities.fragmentos.fragmento_lista
import com.example.bkbapp.database.entities.Match
import kotlinx.android.synthetic.main.activity_listado_partidos.*

class listado_partidos : AppCompatActivity(), fragmento_lista.OnFragmentInteractionListener, fragmento_detalle.OnFragmentInteractionListener {

    override fun onClickLisElement(match: Match) {

    }

    override fun onClickScores(match: Match) {

    }

    private lateinit var frag1 : fragmento_lista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_partidos)

        frag1 = fragmento_lista.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, frag1).commit()
    }

    fun iniciarFragmento(match: Match){
        if(resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT){
            if(match.winner == ""){

            }

        }
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){

        }
    }
}
