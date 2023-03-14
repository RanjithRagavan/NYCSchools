package com.ztoais.nycschools.schoollist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SchoolListScreen(
    state: SchoolListState = SchoolListState(),
    actions: SchoolListActions = SchoolListActions()
) {
    Text(text = "Hello")
}

@Composable
@Preview(name = "SchoolList")
private fun SchoolListScreenPreview() {
    SchoolListScreen()
}

