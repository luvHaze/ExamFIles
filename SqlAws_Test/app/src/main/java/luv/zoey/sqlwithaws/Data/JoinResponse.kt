package luv.zoey.sqlwithaws.Data

import com.google.gson.annotations.SerializedName

data class JoinResponse (
    @SerializedName("code")
    var code : Int,
    @SerializedName("message")
    var message : String

)