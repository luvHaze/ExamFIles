package luv.zoey.roomexam

import androidx.room.Entity
import androidx.room.PrimaryKey


//data 클래스 라는걸 붙여줘야 tostring이나 getter setter 를 자동으로 정의해준다.
@Entity
data class Todo(
    var title: String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}