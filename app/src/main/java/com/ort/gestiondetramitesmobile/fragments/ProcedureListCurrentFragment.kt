package com.ort.gestiondetramitesmobile.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ort.gestiondetramitesmobile.adapter.TramiteAdapter
import com.ort.gestiondetramitesmobile.R
import com.ort.gestiondetramitesmobile.activities.ProcedureActivity
import com.ort.gestiondetramitesmobile.models.Tramite
import com.ort.gestiondetramitesmobile.viewmodels.ProcedureListCurrentViewModel

class ProcedureListCurrentFragment : Fragment() {

        private lateinit var v: View
        private lateinit var  recTramite : RecyclerView
        lateinit var adapter: TramiteAdapter

    private lateinit var viewModel: ProcedureListCurrentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.procedure_list_current_fragment, container, false)
        recTramite = v.findViewById(R.id.ReciclerTramiteCurrent)
        var btnCreateNew = v.findViewById<FloatingActionButton>(R.id.btn_create_procedure)
        btnCreateNew.setOnClickListener {
            val intent = Intent(requireActivity(), ProcedureActivity::class.java)
            startActivity(intent)
        }
        return v
    }

    override fun onStart(){
        super.onStart()
        recTramite.setHasFixedSize(true)
        recTramite.layoutManager= LinearLayoutManager(context)
        recTramite.adapter = TramiteAdapter(obtenerTramites())

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProcedureListCurrentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun obtenerTramites(): MutableList<Tramite> {

        var tramiteList : MutableList<Tramite> = mutableListOf()
        /*me imagino que aca se llama a un endpoint*/
        tramiteList.add(Tramite("LICENCIA DE CONDUCIR","20/08/2021","En proceso"))
        tramiteList.add(Tramite("LICENCIA DE CONDUCIR","22/08/2021","Pendiente"))
        tramiteList.add(Tramite("LICENCIA DE CONDUCIR","01/10/2021","Pendiente"))
        tramiteList.add(Tramite("LICENCIA DE CONDUCIR","01/10/2021","Pendiente"))
        tramiteList.add(Tramite("LICENCIA DE CONDUCIR","01/10/2021","Pendiente"))
        tramiteList.add(Tramite("LICENCIA DE CONDUCIR","01/10/2021","Pendiente"))
        return tramiteList
    }

}