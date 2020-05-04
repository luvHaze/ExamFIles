package luv.zoey.viewmodelexam.ui.main

import androidx.lifecycle.ViewModel
import androidx.room.Room

class MainViewModel : ViewModel() {

    companion object{
        var num : Int =0
    }

    fun plusOne(){
        num+=1
    }
}
