package com.example.sandeep.app_sharing

import android.content.Context
import android.net.wifi.WifiManager
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.sandeep.app_sharing.databinding.ActivityWifiBinding
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.media.audiofx.BassBoost

import android.os.Build
import android.provider.Settings
import android.widget.ImageButton


class WifiActivity : AppCompatActivity() {

    lateinit var binding:ActivityWifiBinding
    lateinit var btnOnOff:ImageButton
    lateinit var btnDiscover:Button
    lateinit var imgbtn:ImageButton
    lateinit var btn:Button
    lateinit var list:ListView
    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWifiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
        executeLisner()
    }

    private fun executeLisner() {

        btnOnOff.setOnClickListener(View.OnClickListener {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) { // if build version is less than Q try the old traditional method
                wifiManager.isWifiEnabled = !wifiManager.isWifiEnabled
            } else { // if it is Android Q and above go for the newer way    NOTE: You can also use this code for less than android Q also
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(panelIntent, 1)
            }
        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1){
            if ( wifiManager.connectionInfo != null && wifiManager.isWifiEnabled) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "cli", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun initialize() {
        btnOnOff= binding.imgbtn
        list=binding.list
        wifiManager= applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }
}