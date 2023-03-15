package com.ztoais.nycschools.data.source.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ztoais.nycschools.data.model.School
import kotlinx.coroutines.flow.Flow

@Dao
interface SchoolDao {
    @Query("SELECT * from school")
    fun getSchoolList(): Flow<List<School>>
}