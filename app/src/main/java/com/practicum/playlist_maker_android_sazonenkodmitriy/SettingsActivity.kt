package com.practicum.playlist_maker_android_sazonenkodmitriy

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
    val context = LocalContext.current
    var darkTheme by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.main_screen_background))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp)
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = colorResource(R.color.white)
                )
            }
            Text(
                text = stringResource(R.string.settings_screen_name),
                color = colorResource(R.color.white),
                fontSize = 22.sp,
                fontFamily = mainFont,
                fontWeight = FontWeight.Medium
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = colorResource(R.color.background),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.settings_dark_theme),
                    color = colorResource(R.color.main_text),
                    fontSize = 16.sp,
                    fontFamily = mainFont,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = darkTheme,
                    onCheckedChange = { darkTheme = it }
                )
            }

            SettingsItem(
                text = stringResource(R.string.settings_share),
                icon = Icons.Default.Share,
                onClick = {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(
                            Intent.EXTRA_TEXT,
                            context.getString(R.string.settings_share_url)
                        )
                    }
                    context.startActivity(Intent.createChooser(intent, null))
                }
            )

            SettingsItem(
                text = stringResource(R.string.settings_support),
                icon = Icons.Default.SupportAgent,
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:")
                        putExtra(
                            Intent.EXTRA_EMAIL,
                            arrayOf(context.getString(R.string.settings_email))
                        )
                        putExtra(
                            Intent.EXTRA_SUBJECT,
                            context.getString(R.string.settings_email_header)
                        )
                        putExtra(
                            Intent.EXTRA_TEXT,
                            context.getString(R.string.settings_email_body)
                        )
                    }
                    context.startActivity(intent)
                }
            )

            SettingsItem(
                text = stringResource(R.string.settings_terms),
                icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(context.getString(R.string.settings_terms_url))
                    )
                    context.startActivity(intent)
                }
            )
        }
    }
}

@Composable
fun SettingsItem(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = colorResource(R.color.main_text),
            fontSize = 16.sp,
            fontFamily = mainFont,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = colorResource(R.color.fg_secondary),
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen {  }
}