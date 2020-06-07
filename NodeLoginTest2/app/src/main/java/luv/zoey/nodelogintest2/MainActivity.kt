package luv.zoey.nodelogintest2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val client = RetorfitInstance.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {

            val user = User(editText_ID.text.toString(),editText_PW.text.toString())
            val login = client?.executeLogin(user)
            login?.enqueue(object : retrofit2.Callback<authPOJO>{
                override fun onFailure(call: Call<authPOJO>, t: Throwable) {
                    Log.e("error",t.toString())
                }

                override fun onResponse(call: Call<authPOJO>, response: Response<authPOJO>) {
                    Toast.makeText(applicationContext,response.message().toString(),Toast.LENGTH_LONG).show()
                    Log.d("response : ",response.body().toString() )
                }

            })

        }

    }
}