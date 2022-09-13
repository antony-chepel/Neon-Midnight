package com.pnixgames.blackneon

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.viewModels
import com.appsflyer.AppsFlyerLib
import com.orhanobut.hawk.Hawk
import com.pnixgames.R
import com.pnixgames.blackneon.NEONST.DEV
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        if (prefs.getBoolean("activity_exec", false)) {
            Intent(this, NeonFilt::class.java).also { startActivity(it) }
            finish()
        } else {
            val exec = prefs.edit()
            exec.putBoolean("activity_exec", true)
            exec.apply()
        }
        Log.d("DevChecker", hsysytweqwe(this).toString())
        Hawk.put(DEV, hsysytweqwe(this).toString())

        viewModel.kjsdjfsdf(this)
        AppsFlyerLib.getInstance()
            .init(NEONST.AF_DEV_KEY, viewModel.conversionDataListener, applicationContext)
        AppsFlyerLib.getInstance().start(this)
        nxhhsasdasd(1500)
    }
    private fun toTestGrounds() {
        Intent(this, NeonFilt::class.java)
            .also { startActivity(it) }
        finish()

    }

    private fun nxhhsasdasd(timeInterval: Long): Job {
        return CoroutineScope(Dispatchers.IO).launch {
            while (NonCancellable.isActive) {
                val hawk1: String? = Hawk.get(NEONST.C1)
                if (hawk1 != null) {
                    Log.d("TestInUIHawk", hawk1.toString())
                    toTestGrounds()
                    break
                } else {
                    val hawk1: String? = Hawk.get(NEONST.C1)
                    Log.d("TestInUIHawkNulled", hawk1.toString())
                    delay(timeInterval)
                }
            }
        }
    }
    private fun hsysytweqwe(context: Context): Boolean {
        return run {
            Settings.Secure.getInt(context.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0
        }
    }
}