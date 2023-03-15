package com.ztoais.nycschools.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ztoais.nycschools.data.model.School

@Database(entities = [School::class], version = 1)
abstract class SchoolDatabase:RoomDatabase() {
    abstract fun schoolDao(): SchoolDao
}