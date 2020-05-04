package luv.zoey.realmlogintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_join.*
import luv.zoey.realmlogintest.Model.User

class JoinActivity : AppCompatActivity() {

    private var realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        btnJoin_Join.setOnClickListener {
            var moveLoginIntent = Intent(this, LoginActivity::class.java)
            startActivity(moveLoginIntent)

            insertUser()
            val result = realm.where(User::class.java).count().toString()
            Log.d("결과 : ",result)

        }

    }
    fun insertUser(){

        val user = User()
        user.Id=edtID_Join.text.toString()
        user.Pw = edtPW_Join.text.toString()
        user.Email = edtEmail_Join.text.toString()
        user.phoneNum = edtPhone_Join.text.toString()
        realm.executeTransactionAsync {
            it.insert(user)

        }


    }
}
