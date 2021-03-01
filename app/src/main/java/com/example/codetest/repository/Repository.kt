package com.example.codetest.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.codetest.model.DetailInfo
import com.example.codetest.model.room.MyDao
import kotlinx.coroutines.flow.Flow

class Repository(private val dao: MyDao) {

    val allData: Flow<List<DetailInfo>> = dao.getAllData()

    @WorkerThread
    suspend fun update(detailInfo: DetailInfo) {
        dao.updateData(detailInfo.id, detailInfo.firstName, detailInfo.lastName, detailInfo.email ?: "", detailInfo.phone ?: "")
    }
}