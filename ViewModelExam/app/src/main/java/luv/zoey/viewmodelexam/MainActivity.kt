package luv.zoey.viewmodelexam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import luv.zoey.viewmodelexam.ui.main.SecondActivity

class MainActivity : AppCompatActivity(),ToastListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        var scdActivity =SecondActivity(this)

    }

    override fun onToast(context: Context) {
        Log.d("Toast발생","${context.toString()}o")

    }
}
