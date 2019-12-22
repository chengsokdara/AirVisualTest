package com.sokdara.cheng.airvisualtest.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sokdara.cheng.airvisualtest.R
import com.sokdara.cheng.airvisualtest.lib.PlaceListAdapter
import com.sokdara.cheng.airvisualtest.mock.Places.Companion.MOCK_PLACES

class PlaceFragment : Fragment() {

    private lateinit var mRecycler: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    private var listener: OnFragmentInteractionListener? = null

    interface OnFragmentInteractionListener {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLayoutManager = LinearLayoutManager(activity)
        mAdapter = PlaceListAdapter(MOCK_PLACES)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_place, container, false)
        mRecycler = v.findViewById(R.id.placeRecycler)
        mRecycler.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            addItemDecoration(ItemDecoration(resources.getDimension(R.dimen.item_spacing).toInt()))
            adapter = mAdapter
        }
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mRecycler.adapter = null
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}