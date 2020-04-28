package luv.zoey.roomexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel :MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewModel.getAll().observe(this, Observer { todos ->
            result_TextView.text = todos.toString()
        })

        addButton.setOnClickListener {
            // launch 안에 있는 블럭은 백그라운드 쓰레드에서 동작하게된다.
            // Dispatchers.IO는 UI 작업을 할때 넣어준다.
            lifecycleScope.launch (Dispatchers.IO){
                viewModel.insert(Todo(todo_edit.text.toString()))
            }

        }

    }
}
