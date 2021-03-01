package com.example.codetest

import android.app.Application
import com.example.codetest.model.room.MyDatabase
import com.example.codetest.repository.Repository
import com.example.codetest.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App : Application(){
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { MyDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { Repository(database.myDao()) }
}