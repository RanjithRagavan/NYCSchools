package com.ztoais.nycschools.data.di

import com.ztoais.nycschools.data.DefaultSchoolRepository
import com.ztoais.nycschools.data.SchoolRepository
import com.ztoais.nycschools.data.model.School
import com.ztoais.nycschools.data.model.SchoolDetail
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Singleton
    @Binds
    fun bindsSchoolRepository(schoolRepository: DefaultSchoolRepository): SchoolRepository
}

class FakeSchoolRepository @Inject constructor(): SchoolRepository{
    override val schoolList: Flow<List<School>> = flowOf(fakeSchoolList)
    override fun schoolDetail(dbn: String): Flow<SchoolDetail> {
        TODO("Not yet implemented")
    }

}

val school1 = School(dbn = "123", schoolName = "ABC")
val school2 = School(dbn = "4356",schoolName = "DEF")
val schoolDetail = SchoolDetail(dbn = "353245")
val fakeSchoolList = listOf(school1,school2)
val fakeSchoolDetail = schoolDetail