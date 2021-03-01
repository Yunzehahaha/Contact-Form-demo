package com.example.codetest.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.codetest.model.DetailInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Query("SELECT * FROM info_table ORDER BY firstName ASC")
    fun getAllData(): Flow<List<DetailInfo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewData(detailInfo: DetailInfo)

    @Query("UPDATE info_table SET firstName = :firstName, lastName = :lastName, email = :email, phone = :phone WHERE id =:id")
    suspend fun updateData(id: String, firstName: String, lastName: String, email: String, phone: String)

    @Query("DELETE FROM info_table")
    suspend fun deleteAll()
}