package com.example.navigasidengandata.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigasidengandata.view.Siswa
import kotlinx.coroutines.flow.MutableStateFlow

class SiswaViewModel : ViewModel (){
    private val _statusUI = MutableStateFlow(Siswa())
}