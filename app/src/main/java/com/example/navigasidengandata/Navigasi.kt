package com.example.navigasidengandata

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasidengandata.view.FormIsian
import com.example.navigasidengandata.view.TampilData

enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { padding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,
            modifier = Modifier.padding(padding)
        ) {
            composable(Navigasi.Formulirku.name) {
                FormIsian(
                    pilihanJK = listOf("Laki-laki", "Perempuan"),
                    onSubmitButtonClicked = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            composable(Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = {
                        navController.popBackStack(
                            Navigasi.Formulirku.name,
                            inclusive = false
                        )
                    }
                )
            }
        }
    }
}
