package com.ztoais.nycschools.schoollist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SchoolListRoute(
    coordinator: SchoolListCoordinator = rememberSchoolListCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(SchoolListState())

    // UI Actions
    val actions = rememberSchoolListActions(coordinator)

    // UI Rendering
    SchoolListScreen(uiState, actions)
}


@Composable
fun rememberSchoolListActions(coordinator: SchoolListCoordinator): SchoolListActions {
    return remember(coordinator) {
        SchoolListActions(
            onClick = coordinator::doStuff
        )
    }
}