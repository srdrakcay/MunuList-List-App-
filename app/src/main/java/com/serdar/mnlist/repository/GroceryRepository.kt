package com.serdar.mnlist.repository

import androidx.lifecycle.LiveData
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.data.ShoppingDao
import com.serdar.mnlist.data.grocery.Grocery
import com.serdar.mnlist.data.grocery.GroceryDao

class GroceryRepository (private val groceryDao: GroceryDao) {

    val readAllDataGrocery : LiveData<List<Grocery>> = groceryDao.readAllDataGrocery()


    suspend fun addGrocery(grocery: Grocery){
        groceryDao.addGrocery(grocery)
    }
    suspend fun updateShopping(grocery: Grocery){
        groceryDao.updateGrocery(grocery)
    }
    suspend fun deleteShopping(grocery: Grocery){
        groceryDao.deleteGrocery(grocery)
    }
}