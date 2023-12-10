package com.example.iqbaalrafi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.iqbaalrafi.data.local.UserDao
import com.example.iqbaalrafi.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

}