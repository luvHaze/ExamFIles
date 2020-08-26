package luv.zoey.coroutinetest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        _number.value = 0
    }

    fun increaseNumber() {
        _number.value = _number.value?.plus(1)
        Log.d("ViewModel","${_number.value}")
    }

    fun decreaseNumber() {
        _number.value = _number.value?.minus(1)
    }

}