package com.grishma.adddemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.grishma.adddemo.data.db.entities.Converters
import com.grishma.adddemo.db.entities.DepartmentDao
import com.grishma.adddemo.db.entities.DepartmentItem

@Database(
    entities = [DepartmentItem::class],
    version = 1
)
@TypeConverters( Converters::class)
abstract class DepartmentDatabase: RoomDatabase() {

    abstract fun getDepartmentDao(): DepartmentDao

    companion object {
        @Volatile
        private var instance: DepartmentDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                DepartmentDatabase::class.java, "DepartmentDB.db").build()
    }
}