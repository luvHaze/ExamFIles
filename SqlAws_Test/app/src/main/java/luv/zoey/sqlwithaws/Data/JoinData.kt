package luv.zoey.sqlwithaws.Data

import com.google.gson.annotations.SerializedName

data class JoinData(
    @SerializedName("userName")
    private var userName: String,
    @SerializedName("userEmail")
    private var userEmail: String,
    @SerializedName("userPwd")
    private var userPwd: String
)