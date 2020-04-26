package luv.zoey.sqlwithaws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import luv.zoey.sqlwithaws.Data.JoinData
import luv.zoey.sqlwithaws.Data.JoinResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {

    var service = RetrofitClient.getClient().create(ServiceAPI::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)


    }

    fun startJoin( data : JoinData){        //object 알아둬야
        service.userJoin(data).enqueue(object : Callback<JoinResponse> {
            override fun onFailure(call: Call<JoinResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<JoinResponse>, response: Response<JoinResponse>) {
                TODO("Not yet implemented")
            }

        })

    }
}
