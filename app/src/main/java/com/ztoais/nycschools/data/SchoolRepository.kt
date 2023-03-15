package com.ztoais.nycschools.data

import com.ztoais.nycschools.data.di.fakeSchoolDetail
import com.ztoais.nycschools.data.di.fakeSchoolList
import com.ztoais.nycschools.data.model.School
import com.ztoais.nycschools.data.model.SchoolDetail
import com.ztoais.nycschools.data.source.local.database.SchoolDao
import com.ztoais.nycschools.data.source.network.SchoolApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface SchoolRepository{
    val schoolList: Flow<List<School>>
    fun schoolDetail(dbn:String): Flow<SchoolDetail>
}

class DefaultSchoolRepository @Inject constructor(
    private val schoolDao: SchoolDao,
    schoolApi: SchoolApi
): SchoolRepository{
    override val schoolList: Flow<List<School>> = flowOf(fakeSchoolList)//schoolDao.getSchoolList()
    override fun schoolDetail(dbn: String): Flow<SchoolDetail> {
        return  flowOf(fakeSchoolDetail.copy(dbn = dbn))
    }
}