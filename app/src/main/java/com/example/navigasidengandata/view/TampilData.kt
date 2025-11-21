package com.example.navigasidengandata.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    statusUiSiswa: Siswa,
    onBackButtonCliked: () -> Unit
) {