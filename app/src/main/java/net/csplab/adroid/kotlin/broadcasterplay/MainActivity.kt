package net.csplab.adroid.kotlin.broadcasterplay

import BroadcasterRecievers.PhonechargerConnectedListenerRegUnreg
import BroadcasterRecievers.PhoneChargerConnectedListener
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.csplab.adroid.kotlin.broadcasterplay.databinding.ActivityMainBinding
import java.util.Arrays.asList

// Broadcasting
// https://android.camposha.info/en/android-broadcastreceiver/
// Broadcasts, Intent intentsFilter: > **action's category's data**

// Checkout Register and Unregister receiver

class MainActivity : AppCompatActivity() {
    // Viewbinding
    private lateinit var bind: ActivityMainBinding

    val phoneChargerListener =  PhoneChargerConnectedListener()
    val phoneReceiver = PhonechargerConnectedListenerRegUnreg()

    var packageString: String = "" //
    //var actionList = listOf<String>() // make it Val var @
    var actionList = listOf<String>() // make it Val var @

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        val mainView = bind.root
        //setContentView(R.layout.activity_main)
        setContentView(mainView)

        val tvText1 = bind.tvText1
        val tvText2 = bind.tvText2
        val btOkButton = bind.btOkButton

        tvText1.text = "TEXT1!!"
        tvText2.text = "TEXT2!!"
        btOkButton.text = "CLEAR!!"

        btOkButton.setOnClickListener {

            sendABroadcast(packageString, actionList)
        }
    }

    override fun onResume() {
        super.onResume()
        // Register Broadcasts for wanted recivers
        // Set what actions we want to have to listen for inside the Broadcaster
        // Set the IntentFilter, thar whows what intents we get
        val intentFilter = IntentFilter()
        //intentFilter.addDataPath()
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_USAGE_SUMMARY)
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        registerReceiver(phoneReceiver, intentFilter)
    }

    fun sendABroadcast(packagename: String, actions: List<String>) {
        intent = Intent()
        intent.action = BATTERY_SERVICE

        sendBroadcast(intent)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(phoneReceiver)

    }
}
