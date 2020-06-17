package com.grishma.adddemo.db.entities

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmpDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: EmployeeItem)

    @Delete
    suspend fun delete(item: EmployeeItem)

    @Query("SELECT * FROM emp")
    fun getAllEmpItems(): LiveData<MutableList<EmployeeItem>>
}