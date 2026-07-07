package com.grocery.app.presentation.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.grocery.app.R
import com.grocery.app.ui.theme.GreenPrimary
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("grocery_profile", 0) }

    var firstName    by remember { mutableStateOf(prefs.getString("first_name",     "") ?: "") }
    var lastName     by remember { mutableStateOf(prefs.getString("last_name",      "") ?: "") }
    var dob          by remember { mutableStateOf(prefs.getString("dob",            "") ?: "") }
    var streetName   by remember { mutableStateOf(prefs.getString("street_name",    "") ?: "") }
    var streetNumber by remember { mutableStateOf(prefs.getString("street_number",  "") ?: "") }
    var postalCode   by remember { mutableStateOf(prefs.getString("postal_code",    "") ?: "") }
    var city         by remember { mutableStateOf(prefs.getString("city",           "") ?: "") }
    var country      by remember { mutableStateOf(prefs.getString("country",        "") ?: "") }
    var phone        by remember { mutableStateOf(prefs.getString("phone",          "") ?: "") }
    var photoUri     by remember {
        mutableStateOf(prefs.getString("photo_uri", null)?.let { Uri.parse(it) })
    }

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val snackbarHostState = remember { SnackbarHostState() }
    var saveCount by remember { mutableIntStateOf(0) }
    val savedMsg = stringResource(R.string.profile_saved)

    LaunchedEffect(saveCount) {
        if (saveCount > 0) snackbarHostState.showSnackbar(savedMsg)
    }

    val imagePicker = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            try {
                context.contentResolver.takePersistableUriPermission(
                    uri, android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            } catch (_: Exception) {}
            photoUri = uri
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.profile_title), fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            // ── Profile Photo ────────────────────────────────────────────────
            Box(contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(3.dp, GreenPrimary, CircleShape)
                        .clickable { imagePicker.launch("image/*") },
                    contentAlignment = Alignment.Center
                ) {
                    if (photoUri != null) {
                        AsyncImage(
                            model = photoUri,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(GreenPrimary.copy(alpha = 0.1f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = GreenPrimary,
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(GreenPrimary)
                        .border(2.dp, Color.White, CircleShape)
                        .clickable { imagePicker.launch("image/*") },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
            Text(
                text = stringResource(R.string.profile_photo),
                style = MaterialTheme.typography.bodySmall,
                color = GreenPrimary,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(2.dp))

            // ── Name ─────────────────────────────────────────────────────────
            ProfileField(firstName, { firstName = it }, R.string.profile_first_name, Icons.Default.Person)
            ProfileField(lastName,  { lastName  = it }, R.string.profile_last_name,  Icons.Default.Badge)

            // ── Date of Birth ────────────────────────────────────────────────
            OutlinedTextField(
                value = dob,
                onValueChange = {},
                label = { Text(stringResource(R.string.profile_dob)) },
                leadingIcon  = { Icon(Icons.Default.CalendarToday, null, tint = GreenPrimary) },
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
                        Icon(Icons.Default.DateRange, null, tint = GreenPrimary)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = profileFieldColors(),
                readOnly = true,
                singleLine = true
            )

            // ── Address Section Label ────────────────────────────────────────
            SectionDivider(stringResource(R.string.profile_address))

            // Street name + number on the same row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = streetName,
                    onValueChange = { streetName = it },
                    label = { Text(stringResource(R.string.profile_street_name)) },
                    leadingIcon = { Icon(Icons.Default.EditRoad, null, tint = GreenPrimary) },
                    modifier = Modifier.weight(2f),
                    shape = RoundedCornerShape(14.dp),
                    colors = profileFieldColors(),
                    singleLine = true
                )
                OutlinedTextField(
                    value = streetNumber,
                    onValueChange = { streetNumber = it },
                    label = { Text(stringResource(R.string.profile_street_number)) },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp),
                    colors = profileFieldColors(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            // Postal code + city on the same row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = postalCode,
                    onValueChange = { postalCode = it },
                    label = { Text(stringResource(R.string.profile_postal_code)) },
                    leadingIcon = { Icon(Icons.Default.MarkunreadMailbox, null, tint = GreenPrimary) },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(14.dp),
                    colors = profileFieldColors(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = city,
                    onValueChange = { city = it },
                    label = { Text(stringResource(R.string.profile_city)) },
                    leadingIcon = { Icon(Icons.Default.LocationCity, null, tint = GreenPrimary) },
                    modifier = Modifier.weight(1.4f),
                    shape = RoundedCornerShape(14.dp),
                    colors = profileFieldColors(),
                    singleLine = true
                )
            }

            ProfileField(country, { country = it }, R.string.profile_country, Icons.Default.Public)

            // ── Phone ────────────────────────────────────────────────────────
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text(stringResource(R.string.profile_phone)) },
                leadingIcon = { Icon(Icons.Default.Phone, null, tint = GreenPrimary) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = profileFieldColors(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // ── Save Button ──────────────────────────────────────────────────
            Button(
                onClick = {
                    prefs.edit()
                        .putString("first_name",    firstName)
                        .putString("last_name",     lastName)
                        .putString("dob",           dob)
                        .putString("street_name",   streetName)
                        .putString("street_number", streetNumber)
                        .putString("postal_code",   postalCode)
                        .putString("city",          city)
                        .putString("country",       country)
                        .putString("phone",         phone)
                        .putString("photo_uri",     photoUri?.toString())
                        .apply()
                    saveCount++
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary)
            ) {
                Icon(Icons.Default.Save, null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.profile_save),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }

    // ── Date Picker Dialog ───────────────────────────────────────────────────
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let { millis ->
                        dob = SimpleDateFormat("dd / MM / yyyy", Locale.getDefault()).format(Date(millis))
                    }
                    showDatePicker = false
                }) {
                    Text("OK", color = GreenPrimary, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text(stringResource(android.R.string.cancel), color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults.colors(
                    selectedDayContainerColor = GreenPrimary,
                    todayDateBorderColor = GreenPrimary,
                    selectedDayContentColor = Color.White
                )
            )
        }
    }
}

@Composable
private fun SectionDivider(label: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HorizontalDivider(modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.outlineVariant)
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Medium
        )
        HorizontalDivider(modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.outlineVariant)
    }
}

@Composable
private fun ProfileField(
    value: String,
    onValueChange: (String) -> Unit,
    labelRes: Int,
    icon: ImageVector
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(labelRes)) },
        leadingIcon = { Icon(icon, null, tint = GreenPrimary) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = profileFieldColors(),
        singleLine = true
    )
}

@Composable
private fun profileFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = GreenPrimary,
    focusedLabelColor = GreenPrimary,
    cursorColor = GreenPrimary,
    unfocusedBorderColor = MaterialTheme.colorScheme.outline
)
