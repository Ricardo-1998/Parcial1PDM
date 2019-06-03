package com.example.bkbapp.activities

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bkbapp.R
import com.example.bkbapp.activities.fragmentos.fragmento_detalle
import com.example.bkbapp.activities.fragmentos.fragmento_lista
import com.example.bkbapp.database.entities.Match
import kotlinx.android.synthetic.main.activity_listado_partidos.*
import kotlinx.android.synthetic.main.fragment_fragmento_detalle.*

class listado_partidos : AppCompatActivity(), fragmento_lista.OnFragmentInteractionListener, fragmento_detalle.OnFragmentInteractionListener {
    override fun onClickListElementLand(match: Match) {
        iniciarFragmento(match)

    }

    override fun onClickLisElementLand(match: Match) {
        iniciarFragmento(match)

    }

    private lateinit var match: Match
    private lateinit var frag1_lista : fragmento_lista
    private lateinit var frag2_detalles : fragmento_detalle

    override fun onClickLisElement(match: Match) {
        iniciarFragmento(match)

    }

    override fun onClickScores(match: Match) {
        iniciarFragmento(match)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_partidos)
        match = Match(0,"","","","","","","")
        iniciarFragmento(match)


    }

    fun iniciarFragmento(match: Match){
        if(resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT){
            if(match.winner == ""){
                frag1_lista = fragmento_lista.newInstance()
                elegirFragmento(R.id.frameLayout,frag1_lista)
            }else{
                frag2_detalles = fragmento_detalle.newInstance(match)
                elegirFragmento(R.id.frameLayout,frag2_detalles)
            }

        }
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            frag1_lista = fragmento_lista.newInstance()
            frag2_detalles = fragmento_detalle.newInstance(match)

            elegirFragmento(R.id.fragmento1,frag1_lista)
            elegirFragmento(R.id.fragmento2,frag2_detalles)
        }
    }

    fun elegirFragmento(id: Int, frag: Fragment){
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }
}
