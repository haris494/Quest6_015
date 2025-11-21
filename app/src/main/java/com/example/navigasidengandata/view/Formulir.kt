package com.example.navigasidengandata.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.DividerDefaults.Thickness
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    pilihanJK: List<String>,
    onSubmitButtonClicked : (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNama by rememberSaveable{ mutableStateOf("")}
    var txtAlamat by remember { mutableStateOf("")}
    var txtGender by remember { mutableStateOf("")}
    var listData: MutableList<String> = mutableListOf( txtNama,txtAlamat,txtGender)

    Scaffold (modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text= stringResource(id= R.string.home), color = Color.White)},
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700))
            )}
    ){isiRuang ->
        Column (modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(
                value = txtNama,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.width(width = 250.dp).padding(top = 20.dp),
                label = {Text(text="nama Lengkap")},
                onValueChange = {
                    txtNama = it
                },
            )
            HorizontalDivider(modifier = Modifier
                .padding(all = 20.dp)
                .width(width = 250.dp), thickness = Thickness, color = Color.Red)
            Row{
                pilihanJK.forEach { item ->
                    Row (modifier = Modifier.selectable(
                        selected = txtGender == item,
                        onClick = {
                            txtGender = item
                        }
                    ),


}