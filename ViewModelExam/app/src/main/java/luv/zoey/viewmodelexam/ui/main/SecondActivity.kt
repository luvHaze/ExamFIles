package luv.zoey.viewmodelexam.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import luv.zoey.viewmodelexam.R
import luv.zoey.viewmodelexam.ToastListener

class SecondActivity(var listener: ToastListener) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        listener.onToast(this)
    }

}

