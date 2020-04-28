package luv.zoey.sqlwithaws

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient() {



    companion object {
        private val BASE_URL: String = "DNS ID"
        private var retrofit: Retrofit? = null


        fun getClient(): Retrofit {

            if(retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }


            return retrofit!!
        }
    }
}