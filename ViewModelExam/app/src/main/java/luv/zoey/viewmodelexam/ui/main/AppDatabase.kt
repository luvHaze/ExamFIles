package luv.zoey.viewmodelexam.ui.main

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Number::class],version = 1)
abstract class AppDatabase(): RoomDatabase(){

    abstract fun number() : Number



}