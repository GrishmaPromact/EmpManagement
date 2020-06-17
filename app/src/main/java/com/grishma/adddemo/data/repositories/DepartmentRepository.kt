package com.grishma.adddemo.data.repositories

import com.grishma.adddemo.db.DepartmentDatabase
import com.grishma.adddemo.db.entities.DepartmentItem

class DepartmentRepository(
    private val db: DepartmentDatabase
) {
    suspend fun insert(item: DepartmentItem) = db.getDepartmentDao().insert(item)

    suspend fun delete(item: DepartmentItem) = db.getDepartmentDao().delete(item)

    fun getAllDepartmentItems() = db.getDepartmentDao().getAllDepartmentItems()
}