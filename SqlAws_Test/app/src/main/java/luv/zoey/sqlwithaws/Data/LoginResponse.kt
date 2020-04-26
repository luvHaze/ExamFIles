package luv.zoey.sqlwithaws.Data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    private var code: Int,
    @SerializedName("message")
    private var message: String,
    @SerializedName("userId")
    private var userId: Int

)