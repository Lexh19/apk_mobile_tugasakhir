package com.example.iqbaalrafi.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama: String,
    val email: String,
    val password: String
)