package com.serdar.mnlist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Shopping::class], version = 1, exportSchema = false)
abstract class ShoppingDatabase:RoomDatabase() {

    abstract fun shoppingDao():ShoppingDao

    companion object{
        @Volatile
        private var INSTANCE:ShoppingDatabase? = null

        fun getDatabase(context: Context):ShoppingDatabase{
            val tempInstance= INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,ShoppingDatabase::class.java,"shopping_database").build()
                INSTANCE=instance
                return instance
            }
        }

    }
}