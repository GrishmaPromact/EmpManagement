package com.grishma.adddemo.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "department")
data class DepartmentItem(
    @ColumnInfo(name = "dep_name") var name: String,
    @ColumnInfo(name = "emp_list") var empList: MutableList<EmployeeItem>
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}