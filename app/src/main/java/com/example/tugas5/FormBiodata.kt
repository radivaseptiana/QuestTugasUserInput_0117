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

