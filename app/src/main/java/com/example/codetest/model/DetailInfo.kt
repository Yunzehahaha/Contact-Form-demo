package com.example.codetest.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "info_table")
data class DetailInfo (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = "",
    @ColumnInfo(name = "firstName")
    var firstName: String = "frist name",
    @ColumnInfo(name = "lastName")
    var lastName: String = "last name",
    @ColumnInfo(name = "email")
    var email: String  = "",
    @ColumnInfo(name = "phone")
    var phone: String = ""
)



