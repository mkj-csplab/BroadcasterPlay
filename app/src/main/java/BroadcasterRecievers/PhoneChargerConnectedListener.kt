package BroadcasterRecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_POWER_CONNECTED
import android.widget.Toast

class PhoneChargerConnectedListener: BroadcastReceiver() {
    override fun onReceive(ctx: Context?, intent: Intent?) {
        // get action that is bound (via IntentFilter @)
        val action: String? = intent?.getAction()

        if(Intent.ACTION_POWER_CONNECTED == action) {
            // CHK@ Check kotlin
            //ctx?.startService(
                //Intent(PhoneService.ACTION_POWER_CONNECTED))
            Toast.makeText(ctx, "Powerconnected", Toast.LENGTH_LONG).show()
        } else if (Intent.ACTION_POWER_DISCONNECTED == action) {
            //ctx?.startService(
                //Intent(PhoneService.ACTION_POWER_CONNECTED))
            Toast.makeText(ctx, "PowerDISconnected", Toast.LENGTH_LONG).show()

        }
    }
}