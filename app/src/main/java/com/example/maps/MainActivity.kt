package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createMapFragment()
    }

    private fun createMapFragment (){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isZoomGesturesEnabled = false

        val myFavoritePlace = LatLng(19.303070,-99.158867)
        map.addMarker(MarkerOptions().position(myFavoritePlace).title("This is my best place").snippet("this is my snipet").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.ic_flag)
        ))

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(myFavoritePlace,18F), 4000, null)
    }
}