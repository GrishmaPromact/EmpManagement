package com.grishma.adddemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.grishma.adddemo.db.entities.EmpDao
import com.grishma.adddemo.db.entities.EmployeeItem

@Database(
    entities = [EmployeeItem::class],
    version = 1
)
abstract class EmpDatabase: RoomDatabase() {

    abstract fun getEmpDao(): EmpDao

    companion object {
        @Volatile
        private var instance: EmpDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                EmpDatabase::class.java, "EmpDB.db").build()
    }
}