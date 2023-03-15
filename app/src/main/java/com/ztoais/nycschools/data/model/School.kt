package com.ztoais.nycschools.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class School(
    @SerializedName("dbn")
    @PrimaryKey
    var dbn: String = "",

    @SerializedName("school_name")
    @ColumnInfo(name = "school_name")
    var schoolName: String = "",

    @SerializedName("num_of_sat_test_takers")
    @ColumnInfo(name = "num_of_sat_test_takers")
    var numOfSatTestTakers: String = "",

    @SerializedName("sat_critical_reading_avg_score")
    @ColumnInfo(name = "sat_critical_reading_avg_score")
    var satCriticalReadingAvgScore: String = "",

    @SerializedName("sat_math_avg_score")
    @ColumnInfo(name = "sat_math_avg_score")
    var satMathAvgScore: String = "",

    @SerializedName("sat_writing_avg_score")
    @ColumnInfo(name = "sat_writing_avg_score")
    var satWritingAvgScore: String = ""
)