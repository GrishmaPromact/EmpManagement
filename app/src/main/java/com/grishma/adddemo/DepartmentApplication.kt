package com.grishma.adddemo

import android.app.Application
import com.grishma.adddemo.data.repositories.DepartmentRepository
import com.grishma.adddemo.data.repositories.EmployeeRepository
import com.grishma.adddemo.data.viewmodel.DepartmentViewModelFactory
import com.grishma.adddemo.data.viewmodel.EmpViewModelFactory
import com.grishma.adddemo.db.DepartmentDatabase
import com.grishma.adddemo.db.EmpDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class DepartmentApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@DepartmentApplication))
        bind() from singleton { DepartmentDatabase(instance()) }
        bind() from singleton { DepartmentRepository(instance()) }
        bind() from provider { DepartmentViewModelFactory(instance()) }

        bind() from singleton { EmpDatabase(instance()) }
        bind() from singleton { EmployeeRepository(instance()) }
        bind() from provider { EmpViewModelFactory(instance()) }
    }
}