package com.serdar.mnlist.data.grocery

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GroceryDao {

    @Query(value = "SELECT * FROM groceryList ORDER BY id ASC")
    fun readAllDataGrocery(): LiveData<List<Grocery>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addGrocery(grocery: Grocery):Long


    @Update
    fun updateGrocery(grocery: Grocery)

    @Delete
    fun deleteGrocery(grocery: Grocery)
}