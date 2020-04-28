package luv.zoey.roomexam

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application){
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    // suspend가 붙으면 무조건 코루틴 안에서 동작해야만 한다.
    // 즉 무조건 비동기로 처리를 하려는 함수에는 suspend를 붙여준다.
    suspend fun insert(todo: Todo){
        db.todoDao().insert(todo)
    }
}