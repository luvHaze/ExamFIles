package luv.zoey.nodelogintest2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {

    @POST("/login")
    fun executeLogin(@Body user: User) : Call<authPOJO>

    @POST("/signup")
    fun executeLogin(@Body user: User) : Call<authPOJO>

}