package com.ztoais.nycschools.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ztoais.nycschools.ui.schoolDetail.SchoolDetailScreen
import com.ztoais.nycschools.ui.schoollist.SchoolListScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "schoollist") {
        composable("schoollist") {
            SchoolListScreen(
                navController = navController,
                modifier = Modifier.padding(16.dp)
            )
        }
        //This destination takes a String argument
        composable(
            "schooldetail"
                .plus("/{dbn}")
        ) { backStackEntry ->
            val dbn = backStackEntry.arguments?.getString("dbn")
            dbn?.let {
                SchoolDetailScreen(dbn = it)
            }
        }
    }
}