package com.example.calculater

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calculater.dao.HistoryDao
import com.example.calculater.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}