package luv.zoey.nodelogintest2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetorfitInstance {

    private var retrofit = Retrofit.Builder()
        .baseUrl("http://14.37.30.45:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var client = retrofit.create(LoginInterface::class.java)


    fun getInstance(): LoginInterface? { return client}
}