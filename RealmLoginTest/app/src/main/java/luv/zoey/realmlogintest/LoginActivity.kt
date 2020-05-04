package luv.zoey.realmlogintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_login.*
import luv.zoey.realmlogintest.Model.User

class LoginActivity : AppCompatActivity() {

    private var realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvJoin.setOnClickListener {
            var moveJoinIntent = Intent(this,JoinActivity::class.java)
            startActivity(moveJoinIntent)

            Toast.makeText(this,realm.where(User::class.java).count().toString(),Toast.LENGTH_LONG).show()
        }

        btnLogin.setOnClickListener {

            var loginUser = realm.where(User::class.java).equalTo("Id",edtId.text.toString()).findFirst()
            if(loginUser?.Pw.toString()==edtPassword.text.toString()){

                Toast.makeText(this,"${loginUser?.Id} 님 환영합니다.",Toast.LENGTH_LONG).show()
            }else{
                Log.d("id :" ,loginUser?.Id.toString())
            }

        }

    }
}
