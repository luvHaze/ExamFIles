package luv.zoey.viewmodelexam.ui.main

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface NumberDAO {

    @Query("SELECT * FROM Number")
    fun getNumber(): Number

    @Insert
    fun insert(number: Number)

    @Update
    fun update(number: Number)
}