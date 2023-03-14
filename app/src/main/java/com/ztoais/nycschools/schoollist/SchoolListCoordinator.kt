package com.ztoais.nycschools.schoollist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class SchoolListCoordinator(
    val viewModel: SchoolListViewModel
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {

    }
}

@Composable
fun rememberSchoolListCoordinator(
    viewModel: SchoolListViewModel = hiltViewModel()
): SchoolListCoordinator {
    return remember(viewModel) {
        SchoolListCoordinator(
            viewModel = viewModel
        )
    }
}