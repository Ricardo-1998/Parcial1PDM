package com.example.bkbapp.activities.fragmentos

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.bkbapp.R
import com.example.bkbapp.activities.adapter.Recycler_adapter
import com.example.bkbapp.database.entities.Match
import com.example.bkbapp.database.viewModel.MatchViewModel
import kotlinx.android.synthetic.main.fragment_fragmento_lista.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragmento_lista.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragmento_lista.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragmento_lista : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var matchViewModel: MatchViewModel
    private lateinit var matchAdapter : Recycler_adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragmento_lista,container,false)
        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel::class.java)
        initRecyclerView(view)
        return view
    }

    fun initRecyclerView(view : View){
        val linearLayoutManager = LinearLayoutManager(this.context)
        matchAdapter = Recycler_adapter({match : Match -> listener?.onClickLisElement(match)})
        view.rv_book_list.adapter = matchAdapter as Recycler_adapter
        matchViewModel.getAll().observe(this, Observer { datos ->
            datos?.let{matchAdapter.setPartidos(it)}
        })
        view.rv_book_list.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
        }


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onClickLisElement(match: Match)
        fun onClickScores(match:Match)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmento_lista.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() : fragmento_lista{
            var fragment = fragmento_lista()
            return fragment
            }
    }
}
