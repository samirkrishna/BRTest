package com.hasini.samirkrishna.brtest

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var filter=IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        filter.addAction(Intent.ACTION_HEADSET_PLUG)
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        filter.addAction("myaction")
        registerReceiver(MyReceiver(),filter)//if any one of the configured events happen it will invoke onReceive() of BroadCastReceiver class
    }
    fun click(v:View)  //For user defined events
    {
        var i =Intent()
        i.setAction("myaction")
        sendBroadcast(i)//intent --> BroadcastReceiver
    }
}
