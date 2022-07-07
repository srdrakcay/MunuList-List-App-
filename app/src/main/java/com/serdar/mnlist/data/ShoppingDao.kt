package com.serdar.mnlist.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ShoppingDao {


    @Query(value = "SELECT * FROM shoppingList ORDER BY id ASC")
    fun readAllData():LiveData<List<Shopping>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addShopping(shopping: Shopping):Long

    @Update
     fun updateShopping(shopping: Shopping)

    @Delete
     fun deleteShopping(shopping: Shopping)
}