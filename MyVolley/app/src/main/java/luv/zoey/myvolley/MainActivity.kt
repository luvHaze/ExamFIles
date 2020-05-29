package luv.zoey.myvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.textclassifier.TextLinks
import android.widget.ProgressBar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            progressBar.visibility=ProgressBar.VISIBLE
            sendRequest()
        }

        button2.setOnClickListener {

            sendImageRequest()
        }

        AppHelper.requestQueue = Volley.newRequestQueue(applicationContext)

    }

    private fun sendImageRequest() {

        var url = "https://movie-phinf.pstatic.net/20191007_102/1570413335279it2JM_JPEG/movie_image.jpg?type=m665_443_2"

        var task = ImageLoadTask(url,imageView)
        task.execute()

    }

    fun sendRequest() {


        var url =
            "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101"
        var request = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {
                println("응답 -> $it")

                processResponse(it)
            },
            Response.ErrorListener {
                println("응답 -> ${it.message}")
            }
        )

        //이전결과 있더라도 새로 추가해줌
        request.setShouldCache(false)
        AppHelper.requestQueue.add(request)
        println("요청 보냄냄")

    }

    private fun processResponse(response: String) {
        // Gson 사용방법
        var gson = Gson()
        var movieList: MovieList = gson.fromJson(response, MovieList::class.java)
                                    // 응답받은 문자열에서 MovieList타입으로 풀어쓰겠다.
        movieList.boxOfficeResult.showRange
        if (movieList != null) {
            var countMovie = movieList.boxOfficeResult.dailyBoxOfficeList.size
            println("박스오피스 타입 : ${movieList.boxOfficeResult.boxofficeType}")
            println("응답받은 영화 갯수 : $countMovie")
            progressBar.visibility=ProgressBar.INVISIBLE
        }
    }


    private fun println(data: String) {
        textview.append(data + "\n")
    }
}
