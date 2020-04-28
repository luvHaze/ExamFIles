package luv.zoey.sqlwithaws

import luv.zoey.sqlwithaws.Data.JoinData
import luv.zoey.sqlwithaws.Data.JoinResponse
import luv.zoey.sqlwithaws.Data.LoginData
import luv.zoey.sqlwithaws.Data.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

public interface ServiceAPI {

    @POST("/user/login")
    fun userLogin(@Body data : LoginData) : Call<LoginResponse>

    @POST("/user/join")
    fun userJoin(@Body data : JoinData) : Call<JoinResponse>
}