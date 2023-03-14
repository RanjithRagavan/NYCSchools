package com.ztoais.nycschools.schoollist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * UI State that represents SchoolListScreen
 **/
class SchoolListState

/**
 * SchoolList Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class SchoolListActions(
    val onClick: () -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalSchoolListActions = staticCompositionLocalOf<SchoolListActions> {
    error("{NAME} Actions Were not provided, make sure ProvideSchoolListActions is called")
}

@Composable
fun ProvideSchoolListActions(actions: SchoolListActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalSchoolListActions provides actions) {
        content.invoke()
    }
}

