package com.example.bubbel

import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.compose.material.icons.*
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextDecoration
import com.example.bubbel.*
import com.example.bubbel.Screens.*
import com.example.bubbel.ui.theme.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           SignUpView()
        }
    }
}



