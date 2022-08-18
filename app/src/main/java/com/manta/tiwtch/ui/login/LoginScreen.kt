package com.manta.tiwtch.ui.login

import android.content.Intent
import android.net.Uri
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.manta.tiwtch.BuildConfig
import java.util.*

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    Button(onClick = {
        val logInUrl = "https://id.twitch.tv/oauth2/authorize"
            .plus("?response_type=token")
            .plus("&client_id=${BuildConfig.TWITCH_CLIENT_ID}")
            .plus("&redirect_uri=https://tiwtch.page.link")
            .plus("&scope=user:read:follows")
            .plus("&state=${UUID.randomUUID()}")

        Intent(Intent.ACTION_VIEW, Uri.parse(logInUrl)).also {
            context.startActivity(it)
        }
    }) {
        Text("login!")
    }
}