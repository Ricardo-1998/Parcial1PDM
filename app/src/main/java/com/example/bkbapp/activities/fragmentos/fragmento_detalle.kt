package com.example.bkbapp.activities.fragmentos

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.service.autofill.FieldClassification
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.example.bkbapp.R
import com.example.bkbapp.database.entities.Match
import com.example.bkbapp.database.viewModel.MatchViewModel
import kotlinx.android.synthetic.main.fragment_fragmento_detalle.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragmento_detalle.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragmento_detalle.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragmento_detalle : Fragment() {
    // TODO: Rename and change types of parameters
    var match :  Match? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var matchViewModel: MatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragmento_lista,container,false)
        view.apply {
            tv_equipo1_result.text= match?.team1
            tv_equipo2_result.text= match?.team2
            tv_fecha_result.text=match?.date
            tv_hora_result.text=match?.time
            tv_point1_result.text=match?.point1.toString()
            tv_point2_result.text=match?.point2.toString()
            tv_winner_result.text=match?.winner

            bt_atras.setOnClickListener{
                var atras = Match(0,"","","","","","","")

                listener?.onClickScores(atras)
            }

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
         * @return A new instance of fragment fragmento_detalle.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(match:Match):fragmento_detalle{
            var fragment = fragmento_detalle()
            return fragment
        }
            }
    }
}
