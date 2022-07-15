package com.serdar.mnlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.serdar.mnlist.data.grocery.Grocery
import com.serdar.mnlist.data.grocery.GroceryDatabase
import com.serdar.mnlist.repository.GroceryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroceryViewModel(application: Application): AndroidViewModel(application) {


    val readAllDataGrocerys: LiveData<List<Grocery>>
    private val repository: GroceryRepository


    init{
        val groceryDao = GroceryDatabase.getDatabase(application).groceryDao()
        repository= GroceryRepository(groceryDao)
        readAllDataGrocerys=groceryDao.readAllDataGrocery()

    }

    fun addGrocery(grocery: Grocery){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGrocery(grocery)
        }
    }

    fun updateGrocery(grocery: Grocery) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateShopping(grocery)
        }
    }
    fun deleteGrocery(grocery: Grocery) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteShopping(grocery)
        }
    }
}