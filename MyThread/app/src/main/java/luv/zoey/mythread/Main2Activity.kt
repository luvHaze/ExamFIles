package luv.zoey.mythread

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.lang.Exception

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        progress_button.setOnClickListener {

            var task = TestAsyncTask()
            task.execute("시작")

        }


    }

    inner class TestAsyncTask : AsyncTask<String, Int, Int>() {

        var value: Int = 0

        override fun doInBackground(vararg params: String?): Int {
            while (true) {

                if (value > 100) break

                value += 1

                publishProgress(value)

                try {
                    Thread.sleep(100)
                } catch (e: Exception) {

                }
            }

            return value
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

            progressBar.progress = values[0]!!
        }

        override fun onPostExecute(result: Int?) {
            super.onPostExecute(result)

            Toast.makeText(applicationContext, "완료됨", Toast.LENGTH_LONG).show()
        }
    }
}
