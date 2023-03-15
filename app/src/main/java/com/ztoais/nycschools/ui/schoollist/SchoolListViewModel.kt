package com.ztoais.nycschools.ui.schoollist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ztoais.nycschools.data.SchoolRepository
import com.ztoais.nycschools.data.model.School
import dagger.hilt.android.lifecycle.HiltViewModel
import com.ztoais.nycschools.ui.schoollist.SchoolListUiState.Loading
import com.ztoais.nycschools.ui.schoollist.SchoolListUiState.Error
import com.ztoais.nycschools.ui.schoollist.SchoolListUiState.Success
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository,
) : ViewModel() {

    val uiState: StateFlow<SchoolListUiState> = schoolRepository
        .schoolList.map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun navigateToDetailScreen(dbn: String,navController:NavController) {
        Log.d("School App log",dbn)
        navController.navigate("schooldetail/$dbn")
    }

}

sealed interface SchoolListUiState {
    object Loading : SchoolListUiState
    data class Error(val throwable: Throwable) : SchoolListUiState
    data class Success(val data: List<School>) : SchoolListUiState
}