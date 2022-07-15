package com.serdar.mnlist.data.grocery

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Grocery::class], version =2, exportSchema = false)
abstract class GroceryDatabase: RoomDatabase() {

    abstract fun groceryDao(): GroceryDao

    companion object{
        @Volatile
        private var INSTANCE:GroceryDatabase? = null

        fun getDatabase(context: Context):GroceryDatabase{
            val tempInstance= INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,GroceryDatabase::class.java,"grocery_database").build()
                INSTANCE=instance
                return instance
            }
        }

    }
}