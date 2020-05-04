package luv.zoey.viewmodelexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import luv.zoey.viewmodelexam.ui.main.BlankFragment
import luv.zoey.viewmodelexam.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        if(intent.extras!=null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BlankFragment.newInstance())
                .commitNow()
        }


    }
}
