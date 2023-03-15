package com.ztoais.nycschools.data.source.network

import com.ztoais.nycschools.data.model.School
import com.ztoais.nycschools.data.model.SchoolDetail
import com.ztoais.nycschools.data.source.network.Constants.Companion.SCHOOL_DETAIL
import com.ztoais.nycschools.data.source.network.Constants.Companion.SCHOOL_LIST
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolApi {
    @GET(SCHOOL_LIST)
    suspend fun getSchoolList(): List<School>

    @GET(SCHOOL_DETAIL)
    suspend fun getSchoolDetail(
        @Query("dbn") searchQuery: String
    ): SchoolDetail
}