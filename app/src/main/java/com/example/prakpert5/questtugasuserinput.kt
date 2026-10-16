package com.example.prakpert5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun FormBiodataScreen() {

    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTglLahir by remember { mutableStateOf("") }
    var textExperience by remember { mutableStateOf("") }

    var isAndroid by remember { mutableStateOf(false) }
    var isUiUx by remember { mutableStateOf(false) }
    var isWeb by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Image(
                painter = painterResource(id = R.drawable.bg_header),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.bg_height))
                    .align(Alignment.TopCenter)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 250.dp) // <--- Tambahkan kode ini untuk mendorong form ke bawah
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.corner_radius_large),
                        topEnd = dimensionResource(id = R.dimen.corner_radius_large)
                    ))
                    .background(colorResource(id = R.color.white_bg))
                    .padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.form_title),
                        fontSize = dimensionResource(id = R.dimen.text_title).value.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.purple_title)
                    )
                    Text(
                        text = stringResource(id = R.string.form_subtitle),
                        fontSize = dimensionResource(id = R.dimen.text_body).value.sp,
                        color = colorResource(id = R.color.gray_subtitle),
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_small),
                            bottom = dimensionResource(id = R.dimen.padding_large)
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
                    ) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            onValueChange = { textNamaDepan = it },
                            label = { Text(stringResource(id = R.string.hint_nama_depan)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
                        )
                        OutlinedTextField(
                            value = textNamaBelakang,
                            onValueChange = { textNamaBelakang = it },
                            label = { Text(stringResource(id = R.string.hint_nama_belakang)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
                        )
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                    OutlinedTextField(
                        value = textEmail,
                        onValueChange = { textEmail = it },
                        label = { Text(stringResource(id = R.string.hint_email)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
                    ) {
                        OutlinedTextField(
                            value = textTglLahir,
                            onValueChange = { textTglLahir = it },
                            label = { Text(stringResource(id = R.string.hint_tgl_lahir)) },
                            trailingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
                        )
                        OutlinedTextField(
                            value = textExperience,
                            onValueChange = { textExperience = it },
                            label = { Text(stringResource(id = R.string.hint_experience)) },
                            trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = null) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
                        )
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

                    // Checkbox Skills
                    Text(
                        text = stringResource(id = R.string.label_skill),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = isAndroid, onCheckedChange = { isAndroid = it })
                            Text(stringResource(id = R.string.skill_android), fontSize = dimensionResource(id = R.dimen.text_body).value.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = isUiUx, onCheckedChange = { isUiUx = it })
                            Text(stringResource(id = R.string.skill_uiux), fontSize = dimensionResource(id = R.dimen.text_body).value.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = isWeb, onCheckedChange = { isWeb = it })
                            Text(stringResource(id = R.string.skill_web), fontSize = dimensionResource(id = R.dimen.text_body).value.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = { /* Biarkan kosong sesuai kebutuhan tampilan */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(id = R.dimen.btn_height)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.gray_btn_bg)
                        ),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_small))
                    ) {
                        Text(
                            text = stringResource(id = R.string.btn_proceed),
                            color = colorResource(id = R.color.white_text),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
