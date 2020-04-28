package luv.zoey.sqlwithaws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

// [전체적인 AWS 사용 방법]
/*
           1. AWS EC2  -> PUTTY로 원격으로 접속한다.
           2. AWS RDS (MY SQL) -> MY SQL bench 이용해서 DB 제작
           3. AWD EC2 컴퓨터에 Node js 설치하고 express, mysql, bodyparser (json 파일 해석) 포함된 서버코드를
              작성한다. 여기에는 DB의 정보, post나 get 요청이 들어왔을때 어떻게 처리를 할것인지 설정을 해준다. (JavaScript이용)
           4. 안드로이드 코드쪽에서는 ServiceAPI 인터페이스 구현, Retrofit2 구현, 하고 EC2 주소로 Post 요청을 보내주도록 처리.
               * ServiceAPI -> AWS로 요청할 메소드 선언 인터페이스
               * RetrofitClient -> companion object로 하나의 Retrofit 클라이언트만 생성되게 함
               * JoinActivity -> 정보를 기입하고 가입을 클릭하면 AWS 서버에 연동된 RDS DB 로 정보가 들어가게끔 한다

               #결론  Client (사용자,안드로이드)  <->    AWS EC2(컴퓨팅장치)   <->   Node.js (서버)   <->    MySQL(DB)
*/

