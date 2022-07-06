package com.serdar.mnlist.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ShoppingDao {


    @Query(value = "SELECT * FROM shoppingList ORDER BY id ASC")
    fun readAllData():LiveData<List<Shopping>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addShopping(shopping: Shopping):Int

    @Update
    suspend fun updateShopping(shopping: Shopping)

    @Delete
    suspend fun deleteShopping(shopping: Shopping)
}