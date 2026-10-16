package com.example.tugas5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodata(modifier: Modifier = Modifier) {
    //Variable-variable untuk mengingatkan nilai masukkan dari keyboard
    var textNamaDepan by remember { mutableStateOf(value = "") }
    var textNamaBelakang by remember { mutableStateOf(value = "") }
    var textEmail by remember { mutableStateOf(value = "") }
    var textTgl by remember { mutableStateOf(value = "") }
    var textExp by remember { mutableStateOf(value = "") }
    var cekAndroid by remember { mutableStateOf(value = false) }
    var cekUiux by remember { mutableStateOf(value = false) }
    var cekWeb by remember { mutableStateOf(value = false) }

    //Variable-variable untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var tgl by remember { mutableStateOf(value = "") }
    var exp by remember { mutableStateOf(value = "") }
    var skill by remember { mutableStateOf(value = "") }
    var tampil by remember { mutableStateOf(value = false) }

    //Variable-variable untuk kalender dan dropdown
    var bukaKalender by remember { mutableStateOf(value = false) }
    var bukaDropdown by remember { mutableStateOf(value = false) }
    val kalenderState = rememberDatePickerState()
    val formatTanggal = stringResource(id = R.string.format_tanggal)
    val listExp: List<String> = listOf(
        stringResource(id = R.string.exp_pertama),
        stringResource(id = R.string.exp_kedua),
        stringResource(id = R.string.exp_ketiga),
        stringResource(id = R.string.exp_keempat)
    )

    val teksAndroid = stringResource(id = R.string.skill_android)
    val teksUiux = stringResource(id = R.string.skill_uiux)
    val teksWeb = stringResource(id = R.string.skill_web)
    val durasi = integerResource(id = R.integer.durasi_hasil).toLong()

    //Card hasil disembunyikan lagi setelah 5 detik
    LaunchedEffect(key1 = tampil) {
        if (tampil) {
            delay(timeMillis = durasi)
            tampil = false
        }
    }

    //Box putih yang mengapung di atas gambar dan Scaffold
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.putih),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_box))
            )
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.judul_form),
                style = MaterialTheme.typography.headlineMedium,
                color = colorResource(id = R.color.biru_judul)
            )
            Text(
                text = stringResource(id = R.string.subjudul_form),
                color = colorResource(id = R.color.abu)
            )
            Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {
                OutlinedTextField(
                    value = textNamaDepan,
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    label = { Text(text = stringResource(id = R.string.nama_depan)) },
                    onValueChange = { textNamaDepan = it }
                )
                OutlinedTextField(
                    value = textNamaBelakang,
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    label = { Text(text = stringResource(id = R.string.nama_belakang)) },
                    onValueChange = { textNamaBelakang = it }
                )
            }
            OutlinedTextField(
                value = textEmail,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = stringResource(id = R.string.email)) },
                onValueChange = { textEmail = it }
            )
