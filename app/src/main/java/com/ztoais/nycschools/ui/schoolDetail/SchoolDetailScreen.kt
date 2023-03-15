package com.ztoais.nycschools.ui.schoolDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.ztoais.nycschools.data.model.SchoolDetail
import com.ztoais.nycschools.ui.theme.SchoolsTheme

@Composable
fun SchoolDetailScreen(
    dbn:String,
    modifier: Modifier = Modifier,
    viewModel: SchoolDetailViewModel = hiltViewModel()
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val value by produceState<SchoolDetailUiState>(
        initialValue = SchoolDetailUiState.Loading,
        key1 = lifecycle,
        key2 = viewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            viewModel.uiState.collect { value = it }
        }
    }

    if(value is SchoolDetailUiState.Success){
        LoadSchoolDetailScreen((value as SchoolDetailUiState.Success).data, modifier)
    }
}

@Composable
internal fun LoadSchoolDetailScreen(
    value: SchoolDetail,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        value.dbn?.let {
            Text(
                text = it
            )
        }
    }
}

// Previews
@Preview(showBackground = true)
@Composable
private fun DefaultPreview(){
    val schoolDetail = SchoolDetail(dbn = "SchoolDetail1")
    SchoolsTheme{
        LoadSchoolDetailScreen(schoolDetail)
    }
}

@Preview(showBackground = true, widthDp = 480)
@Composable
private fun PortraitPreview(){
    val schoolDetail = SchoolDetail(dbn = "SchoolDetail1")
    SchoolsTheme{
        LoadSchoolDetailScreen(schoolDetail)
    }
}