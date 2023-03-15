package com.ztoais.nycschools.ui.schoollist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import com.ztoais.nycschools.data.model.School
import com.ztoais.nycschools.ui.theme.SchoolsTheme

@Composable
fun SchoolListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SchoolListViewModel = hiltViewModel()
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val items by produceState<SchoolListUiState>(
        initialValue = SchoolListUiState.Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.uiState.collect { value = it }
        }
    }

    if (items is SchoolListUiState.Success) {
        LoadSchoolListScreen(
            items = (items as SchoolListUiState.Success).data,
            onItemClick = viewModel::navigateToDetailScreen,
            modifier = modifier,
            navController = navController
        )
    }
}

@Composable
internal fun LoadSchoolListScreen(
    items: List<School>,
    onItemClick: (dbn: String,navController:NavController) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavController?
) {
    Column(modifier) {
        items.forEach {
            Text(
                modifier = Modifier.clickable(enabled = true) {
                    if (navController != null) {
                        onItemClick(it.dbn,navController)
                    }
                },
                text = it.schoolName
            )
        }
    }
}

// Previews
@Preview(showBackground = true)
@Composable
private fun DefaultPreview(){
    val school1 = School(schoolName = "ABC")
    val school2 = School(schoolName = "DEF")
    val schoolList:List<School> = listOf(school1,school2)
    SchoolsTheme{
        LoadSchoolListScreen(schoolList, onItemClick = { s: String, navController: NavController -> }, navController = null)
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview(){
    val school1 = School(schoolName = "ABC")
    val school2 = School(schoolName = "DEF")
    val schoolList:List<School> = listOf(school1,school2)
    SchoolsTheme{
        LoadSchoolListScreen(schoolList, onItemClick = { s: String, navController: NavController -> }, navController = null)
    }
}
