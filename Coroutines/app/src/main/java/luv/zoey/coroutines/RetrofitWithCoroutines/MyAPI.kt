package luv.zoey.coroutines.RetrofitWithCoroutines

import retrofit2.Call
import retrofit2.http.GET

interface MyAPI {

    @GET("/comments")
    fun getCommnents(): Call<List<Comment>>
}
