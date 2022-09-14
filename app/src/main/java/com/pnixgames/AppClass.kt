package com.pnixgames

import android.app.Application
import android.content.Context
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import com.pnixgames.blackneon.NEONST.MAIN_ID
import com.pnixgames.blackneon.NEONST.ONESIGNAL_APP_ID
import com.pnixgames.blackneon.NeonAdv
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@HiltAndroidApp
class AppClass: Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        GlobalScope.launch(Dispatchers.IO) {
            hdydtwqwqe(context = applicationContext)
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

    private suspend fun hdydtwqwqe(context: Context) {
        val advertisingInfo = NeonAdv(context)
        val idInfo = advertisingInfo.hsyydwqqw()
        Hawk.put(MAIN_ID, idInfo)
    }
}