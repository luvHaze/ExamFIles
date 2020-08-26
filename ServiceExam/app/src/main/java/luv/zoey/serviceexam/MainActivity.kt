package luv.zoey.serviceexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // [IntentServce]
        /*
        btnStart.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                serviceStatus_TextView.text = "Service running"
            }
        }

        btnStop.setOnClickListener {
            MyIntentService.stopService()
            serviceStatus_TextView.text = "Service stopped"
        }

        */

        // [Service]
        btnStart.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                serviceStatus_TextView.text = "Service Running"
            }
        }

        btnStop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                serviceStatus_TextView.text = "Service Stopped"
            }
        }

        btnSendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = data_editText.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }
    }
}