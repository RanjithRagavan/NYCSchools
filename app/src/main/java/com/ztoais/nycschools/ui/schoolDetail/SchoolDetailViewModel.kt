package com.ztoais.nycschools.ui.schoolDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ztoais.nycschools.data.DefaultSchoolRepository
import com.ztoais.nycschools.data.model.SchoolDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SchoolDetailViewModel @Inject constructor(
    schoolRepository: DefaultSchoolRepository,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    private val _dbn = checkNotNull(savedStateHandle.get<String>("dbn"))
    val uiState: StateFlow<SchoolDetailUiState> = schoolRepository
        .schoolDetail(_dbn).map(SchoolDetailUiState::Success)
        .catch { SchoolDetailUiState.Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), SchoolDetailUiState.Loading)
}

sealed interface SchoolDetailUiState {
    object Loading : SchoolDetailUiState
    data class Error(val throwable: Throwable) : SchoolDetailUiState
    data class Success(val data: SchoolDetail) : SchoolDetailUiState
}