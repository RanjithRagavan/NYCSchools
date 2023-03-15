package com.ztoais.nycschools.data.source.local.di

import android.content.Context
import androidx.room.Room
import com.ztoais.nycschools.data.source.local.database.SchoolDao
import com.ztoais.nycschools.data.source.local.database.SchoolDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideSchoolDao(schoolDatabase: SchoolDatabase):SchoolDao{
        return schoolDatabase.schoolDao()
    }

    @Provides
    @Singleton
    fun provideSchoolDatabase(@ApplicationContext appContext: Context):SchoolDatabase{
        return Room.databaseBuilder(
            appContext,
            SchoolDatabase::class.java,
            "School"
        ).build()
    }
}