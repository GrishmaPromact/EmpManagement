package com.grishma.adddemo.db.entities

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DepartmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: DepartmentItem)

    @Delete
    suspend fun delete(item: DepartmentItem)

    @Query("SELECT * FROM department")
    fun getAllDepartmentItems(): LiveData<MutableList<DepartmentItem>>
}