package luv.zoey.realmlogintest

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvJoin.setOnClickListener {
            var moveJoinIntent = Intent(this,JoinActivity::class.java)
            startActivity(moveJoinIntent)

        }
    }
}
