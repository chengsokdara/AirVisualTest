package com.sokdara.cheng.airvisualtest.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sokdara.cheng.airvisualtest.R
import kotlinx.android.synthetic.main.fragment_map.view.*


class MapFragment : Fragment(), OnMapReadyCallback {

    companion object {
        private const val PERMISSION_REQUEST_CODE = 7777
    }

    private lateinit var mGoogleMap: GoogleMap
    private lateinit var mMapView: MapView

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_map, container, false)
        mMapView = v.mainMap
        mMapView.onCreate(savedInstanceState)
        mMapView.getMapAsync(this)
        return v
    }

    override fun onResume() {
        super.onResume()
        mMapView.onResume()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
        if (ContextCompat.checkSelfPermission(activity!!, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission()
        } else {
            configureMapView()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if ((grantResults.isEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED)) {
                    requestLocationPermission()
                } else {
                    configureMapView()
                }
            }
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            activity!!,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            PERMISSION_REQUEST_CODE
        )
    }

    private fun configureMapView() {
        val phnomPenh = LatLng(11.5564, 104.9282)
        mGoogleMap.isMyLocationEnabled = true
        val locationButton =
            (mMapView.findViewById<View>("1".toInt()).parent as View).findViewById<View>(
                "2".toInt()
            )
        val rlp =
            locationButton.layoutParams as RelativeLayout.LayoutParams

        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0)
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE)
        rlp.setMargins(0, 260, 180, 0)
        mGoogleMap.addMarker(MarkerOptions().position(phnomPenh).title("Marker in Phnom Penh"))
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(phnomPenh, 5.0f))
    }

    override fun onPause() {
        super.onPause()
        mMapView.onPause()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mMapView.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView.onLowMemory()
    }
}