package luv.zoey.coroutines.RetrofitWithCoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import luv.zoey.coroutines.R
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://jsonplaceholder.typicode.com/"


class RetrofitWithCoroutine : AppCompatActivity() {

    val TAG = "RetrofitWithCoroutine"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_with_coroutine)


        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)

        // Normal Retrofit Use case
        /*
        api.getCommnetns().enqueue(object : Callback<List<Comment>> {

            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if(response.isSuccessful){
                    response.body().let{
                        for(comment in it!!){
                            Log.d(TAG,comment.toString())
                        }
                    }
                }
            }
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Log.e(TAG,"ERROR: $t")
            }
        })
        */

        // Coroutine을 이용한 Retrofit
        // 상당히 간단하다.
        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getCommnents().awaitResponse()
            if (response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.d(TAG, comment.toString())
                }
            }
        }


    }
}