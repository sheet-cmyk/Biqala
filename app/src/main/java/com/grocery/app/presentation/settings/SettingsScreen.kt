package com.grocery.app.presentation.settings

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.grocery.app.R
import com.grocery.app.ui.theme.GreenPrimary
import com.grocery.app.utils.LocaleHelper

data class Language(val code: String, val nativeName: String, val flag: String)

val supportedLanguages = listOf(
    Language("ar", "العربية", "🇸🇦"),
    Language("en", "English", "🇬🇧"),
    Language("de", "Deutsch", "🇩🇪"),
    Language("fr", "Français", "🇫🇷"),
    Language("es", "Español", "🇪🇸"),
    Language("it", "Italiano", "🇮🇹"),
    Language("tr", "Türkçe", "🇹🇷"),
    Language("ru", "Русский", "🇷🇺"),
    Language("zh", "中文", "🇨🇳"),
    Language("ja", "日本語", "🇯🇵"),
)

@Composable
fun SettingsScreen(onNavigateToProfile: () -> Unit = {}) {
    val context = LocalContext.current
    var selectedLang by remember { mutableStateOf(LocaleHelper.getSelectedLanguage(context)) }
    var showLanguageDialog by remember { mutableStateOf(false) }

    val prefs = remember { context.getSharedPreferences("grocery_profile", 0) }
    val savedName = remember {
        val first = prefs.getString("first_name", "") ?: ""
        val last  = prefs.getString("last_name",  "") ?: ""
        if (first.isNotBlank() || last.isNotBlank()) "$first $last".trim()
        else null
    }
    val savedEmail  = remember { prefs.getString("address", null) }
    val savedPhoto  = remember { prefs.getString("photo_uri", null)?.let { Uri.parse(it) } }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.nav_settings),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }

        // ── Profile Section ──────────────────────────────────────────────────
        item {
            Card(
                onClick = onNavigateToProfile,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(GreenPrimary.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (savedPhoto != null) {
                            AsyncImage(
                                model = savedPhoto,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = GreenPrimary,
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = savedName ?: stringResource(R.string.settings_profile),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.profile_edit),
                            style = MaterialTheme.typography.bodySmall,
                            color = GreenPrimary
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        // ── Language Section ─────────────────────────────────────────────────
        item {
            SettingsSectionCard {
                SettingsRowItem(
                    icon = Icons.Default.Language,
                    label = stringResource(R.string.settings_language),
                    trailing = {
                        val currentLang = supportedLanguages.find { it.code == selectedLang }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = currentLang?.flag ?: "🌐",
                                fontSize = 18.sp
                            )
                            Text(
                                text = currentLang?.nativeName ?: selectedLang,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    },
                    onClick = { showLanguageDialog = true }
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        // ── Contact & About Section ──────────────────────────────────────────
        item {
            SettingsSectionCard {
                SettingsRowItem(
                    icon = Icons.Default.ContactSupport,
                    label = stringResource(R.string.settings_contact),
                    trailing = {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = MaterialTheme.colorScheme.outlineVariant
                )
                SettingsRowItem(
                    icon = Icons.Default.Info,
                    label = stringResource(R.string.settings_about),
                    trailing = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.settings_about_version),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                )
            }
        }
    }

    // ── Language Picker Dialog ───────────────────────────────────────────────
    if (showLanguageDialog) {
        AlertDialog(
            onDismissRequest = { showLanguageDialog = false },
            title = {
                Text(
                    text = stringResource(R.string.settings_language),
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    items(supportedLanguages) { lang ->
                        val isSelected = selectedLang == lang.code
                        Card(
                            onClick = {
                                selectedLang = lang.code
                                LocaleHelper.setLocale(context, lang.code)
                                showLanguageDialog = false
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = if (isSelected)
                                    MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.surface
                            ),
                            elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 2.dp else 0.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    Text(text = lang.flag, style = MaterialTheme.typography.titleLarge)
                                    Text(
                                        text = lang.nativeName,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                    )
                                }
                                if (isSelected) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = GreenPrimary
                                    )
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showLanguageDialog = false }) {
                    Text(text = "OK", color = GreenPrimary)
                }
            },
            containerColor = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
private fun SettingsSectionCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        content = content
    )
}

@Composable
private fun SettingsRowItem(
    icon: ImageVector,
    label: String,
    trailing: @Composable () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Surface(
        onClick = onClick,
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(GreenPrimary.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = GreenPrimary,
                        modifier = Modifier.size(22.dp)
                    )
                }
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
            }
            trailing()
        }
    }
}
