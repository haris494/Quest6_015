package com.example.navigasicompose.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mainnavigationdata.R
import com.example.mainnavigationdata.model.Mahasiswa

@Composable
fun MahasiswaFormView(
    modifier: Modifier,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = "",
                modifier = Modifier.padding(45.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column {
                Text(
                    text = "Universitas Muhamadiyah Yogyakarta",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Unggul Islami",
                    color = Color.Red,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Box(
            modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp))
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Masukan Data Kamu",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Text(
                    text = "Isi sesuai data yang kamu daftarkan",
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = nim,
                    onValueChange = { nim = it },
                    label = { Text(text = "Nomor Induk Mahasiswa") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = "")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text(text = "Nama") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = "")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Info, contentDescription = "")
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp)
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = { onBackButtonClicked() }) {
                        Text(text = "Kembali")
                    }
                    Button(onClick = {
                        val updatedListData = mutableListOf(nim, nama, email)
                        onSubmitButtonClicked(updatedListData)
                    }) {
                        Text(text = "Simpan")
                    }
                }
            }
        }
    }
}

