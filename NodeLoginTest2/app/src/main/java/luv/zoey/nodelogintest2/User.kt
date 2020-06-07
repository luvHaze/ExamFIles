package luv.zoey.nodelogintest2

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

class User (
    @SerializedName("id")
    var id : String,
    @SerializedName("pw")
    var pw : String
)
