package com.example.bkbapp.activities.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bkbapp.R
import com.example.bkbapp.database.entities.Match
import kotlinx.android.synthetic.main.partido_item.view.*

class Recycler_adapter(val click: (Match) -> Unit) : RecyclerView.Adapter<Recycler_adapter.ViewHolder>(){

    private var partidos = emptyList<Match>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Match,click: (Match) -> Unit) = with(itemView){

            tv_equipo1_card.text = item.team1
            tv_equipo2_card.text = item.team2
            tv_ganador_card.text = item.winner
            tv_fecha_card.text = item.date
            tv_hora_card.text = item.time
            tv_point1_card.text = item.point1
            tv_point2_card.text = item.point2

            this.setOnClickListener {
                click(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Recycler_adapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.partido_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = partidos.size

    override fun onBindViewHolder(holder: Recycler_adapter.ViewHolder, position: Int) = holder.bind(partidos[position],click)

    internal fun setPartidos(partido : List<Match>){
        this.partidos = partido
        notifyDataSetChanged()
    }

}