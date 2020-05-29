package luv.zoey.myhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    var handler = Handler()
    lateinit var urlStr: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            urlStr = editText.text.toString()

            var thread = RequestThread()
            thread.start()

        }
    }

    inner class RequestThread : Thread() {

        override fun run() {

            try {
                var url = URL(urlStr)

                var conn: HttpURLConnection = url.openConnection() as HttpURLConnection

                if (conn !== null) {
                    // 10 초 기다려서 응답없으면 종료
                    conn.connectTimeout = 10000
                    // GET 방식 요청
                    conn.requestMethod = "GET"
                    //입력과 출력 둘다 가능하게끔
                    conn.doInput = true
                    conn.doOutput = true

                    var resCode = conn.responseCode
                    var reader = BufferedReader(InputStreamReader(conn.inputStream))
                    var line: String? = null

                    while (true) {

                        line = reader.readLine()

                        if (line == null) {
                            break
                        }

                        println(line)
                    }

                    reader.close()
                    conn.disconnect()

                }

            } catch (e: Exception) {
                e.printStackTrace()
            }


        }
    }

    fun println(data: String) {
        //append = 추가
        handler.post {
            run {
                textView.append(data + "\n")
            }
        }

    }


}
