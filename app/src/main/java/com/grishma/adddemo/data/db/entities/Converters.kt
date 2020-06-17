package com.grishma.adddemo.data.db.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.grishma.adddemo.db.entities.EmployeeItem

class Converters {

    @TypeConverter
    fun listToJson(value: MutableList<EmployeeItem>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<EmployeeItem>::class.java).toMutableList()
}