package com.grishma.adddemo.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emp")
data class EmployeeItem(
    @ColumnInfo(name = "emp_email")
    var email: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}