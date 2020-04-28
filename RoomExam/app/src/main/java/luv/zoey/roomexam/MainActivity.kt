package luv.zoey.roomexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries()
            .build()

        result_TextView.text = db.todoDao().getAll().toString()

        addButton.setOnClickListener {
            db.todoDao().insert(Todo(todo_edit.text.toString()))
            result_TextView.text = db.todoDao().getAll().toString()
        }

    }
}
