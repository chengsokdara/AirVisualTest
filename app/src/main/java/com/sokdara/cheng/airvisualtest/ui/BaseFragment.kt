package com.sokdara.cheng.airvisualtest.ui

import android.content.Context
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    interface OnFragmentInteractionListener {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}