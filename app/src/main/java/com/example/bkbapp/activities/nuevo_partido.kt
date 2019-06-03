package com.example.bkbapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.bkbapp.R
import com.example.bkbapp.database.entities.Match
import com.example.bkbapp.database.viewModel.MatchViewModel
import kotlinx.android.synthetic.main.activity_nuevo_partido.*

class nuevo_partido : AppCompatActivity() {

    lateinit var vmMatch : MatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_partido)



        vmMatch=ViewModelProviders.of(this).get(MatchViewModel::class.java)


        tv_point1.text=vmMatch.point1.toString()
        tv_point2.text=vmMatch.point2.toString()


    }

    fun sumarPuntos(view: View){
        when(view){
            bt_sumar_1_a ->{
                vmMatch.point1+=1
            }
            bt_sumar_2_a ->{
                vmMatch.point1+=2
            }
            bt_sumar_3_a ->{
                vmMatch.point1+=3
            }
            bt_sumar_1_b ->{
                vmMatch.point2+=1
            }
            bt_sumar_2_b ->{
                vmMatch.point2+=2
            }
            bt_sumar_3_b ->{
                vmMatch.point2+=3
            }

        }
        tv_point1.text=vmMatch.point1.toString()
        tv_point2.text=vmMatch.point2.toString()
    }

    fun saveMatch(view: View){
         if(et_equipo1!=null && et_equipo2!=null && et_date!=null && et_time!=null){
             var winner : String =""

             when(view){
                 bt_save ->{
                     if(vmMatch.point1>vmMatch.point2){
                         winner=et_equipo1.text.toString()
                     }else{
                         if(vmMatch.point1<vmMatch.point2){
                             winner=et_equipo2.text.toString()
                         }else{
                             winner="Empate"
                         }
                     }

                 }
             }



             val match = Match(0,et_equipo1.text.toString(),et_equipo2.text.toString(),vmMatch.point1.toString(),vmMatch.point2.toString(),winner,et_date.text.toString(),et_time.text.toString())
             vmMatch.insert(match)

             finish()
         }
    }
}
