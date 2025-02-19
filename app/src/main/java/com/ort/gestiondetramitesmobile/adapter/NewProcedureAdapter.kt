package com.ort.gestiondetramitesmobile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ort.gestiondetramitesmobile.R
import com.ort.gestiondetramitesmobile.models.Procedure

class NewProcedureAdapter (private var procedureList: MutableList<Procedure>,
                           var context : Context,
                           val onItemClick : (Int) -> Unit
    ) : RecyclerView.Adapter<NewProcedureAdapter.ProcedureHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewProcedureAdapter.ProcedureHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_procedures,parent,false)
        return(ProcedureHolder(view))
    }

    override fun onBindViewHolder(holder: NewProcedureAdapter.ProcedureHolder, position: Int) {
        holder.setName(procedureList[position].name)
        holder.setDescription(procedureList[position].description)
        holder.getCardView().setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return procedureList.size
    }

    class ProcedureHolder(v: View) : RecyclerView.ViewHolder(v){

        private var view: View
        init {
            this.view = v
        }

        fun setName(name : String){
            val txt: TextView = view.findViewById(R.id.procedureName)
            txt.text = name
        }
        fun setDescription(description : String){
            val txt: TextView = view.findViewById(R.id.procedureDescription)
            txt.text = description
        }

        fun getCardView () : CardView {
            return view.findViewById(R.id.procedureCard)
        }
    }
}