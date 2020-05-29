package luv.zoey.mythread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var textview: TextView

    var handler2 = Handler()
    var value = 0
    var running: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.textView)

        button.setOnClickListener {
            Thread(Runnable {
                    run {
                        running = true
                        while (running) {
                            value += 1

                            handler2.post {
                                run {
                                    textview.text = value.toString()
                                }
                            }
                            try {
                                Thread.sleep(1000)
                            } catch (e: Exception) {

                            }

                        }

                    }

                }
            ).start()


        }

        button2.setOnClickListener {


        }
    }


}
