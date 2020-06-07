package luv.zoey.nodelogintest2

import com.google.gson.annotations.SerializedName

data class authPOJO (
    @SerializedName("token")
    var token : Boolean,
    @SerializedName("code")
    var code : String
)