package com.grishma.adddemo.data.repositories

import com.grishma.adddemo.db.EmpDatabase
import com.grishma.adddemo.db.entities.EmployeeItem

class EmployeeRepository(
    private val db: EmpDatabase
) {
    suspend fun insert(item: EmployeeItem) = db.getEmpDao().insert(item)

    suspend fun delete(item: EmployeeItem) = db.getEmpDao().delete(item)

    fun getAllEmpItems() = db.getEmpDao().getAllEmpItems()
}