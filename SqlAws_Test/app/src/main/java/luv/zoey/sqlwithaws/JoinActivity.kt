package luv.zoey.sqlwithaws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import luv.zoey.sqlwithaws.Data.JoinData
import luv.zoey.sqlwithaws.Data.JoinResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {

    private var service: ServiceAPI = RetrofitClient.getClient().create(ServiceAPI::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)


        button_start.setOnClickListener {

            var data : JoinData = JoinData(editName.text.toString(),editMail.text.toString(),editPwd.text.toString())
            startJoin(data)

        }
    }

    fun startJoin(data: JoinData) {
        //object 알아둬야
        service.userJoin(data).enqueue(object : Callback<JoinResponse> {

            override fun onResponse(call: Call<JoinResponse>, response: Response<JoinResponse>) {
                val result =response.body()
                Toast.makeText(this@JoinActivity,result?.message,Toast.LENGTH_LONG).show()

                if(result?.code==200){
                    Log.d("응답 성공","응답성공")
                    //finish()
                }

            }

            override fun onFailure(call: Call<JoinResponse>, t: Throwable) {

                Toast.makeText(this@JoinActivity,"회원가입 에러 발생",Toast.LENGTH_LONG).show()
                Log.e("회원가입 에러 발생",t.message)
            }



        })

    }
}
