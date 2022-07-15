package com.serdar.mnlist.data.grocery

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "groceryList")
data class Grocery(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int=0,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "size") val size: Int,
    @ColumnInfo(name = "store") val store: String



): Parcelable
