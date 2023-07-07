package com.example.bubbel

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

// -- Types --
@Serializable
class InCreateUser(
    val email: String,
    val username: String,
    val password: String
)

@Serializable
class ResCreateUser(
    val error: String
)

@Serializable
class InAuthUser(
    val username: String,
    val password: String
)

@Serializable
class ResAuthUser(
    val error: String,
    val token: String,
    val username: String,
    val email: String
)

@Serializable
class InDeauthUser(
    val token: String
)

@Serializable
class ResDeauthUser(
    val error: String
)

// -- API Bridge --

const val BUBBEL_BATH_DEV = "https://bubbel-bath.onrender.com/api"

suspend fun bubbelApiCreateUser(bath: String, req: InCreateUser): ResCreateUser {
    val client = OkHttpClient()
    val json = Json.encodeToString(req)
    val requestBody = json.toRequestBody("application/json".toMediaType())
    val request = Request.Builder()
        .url("$bath/create_user")
        .post(requestBody)
        .build()

    return withContext(Dispatchers.IO) {
        val response = client.newCall(request).execute()
        val body = response.body?.string()
        response.close()

        Json.decodeFromString<ResCreateUser>(body ?: throw Exception("Empty response body"))
    }
}

suspend fun bubbelApiAuthUser(bath: String, req: InAuthUser): ResAuthUser {
    val client = OkHttpClient()
    val json = Json.encodeToString(req)
    val requestBody = json.toRequestBody("application/json".toMediaType())
    val request = Request.Builder()
        .url("$bath/auth_user")
        .post(requestBody)
        .build()

    return withContext(Dispatchers.IO) {
        val response = client.newCall(request).execute()
        val body = response.body?.string()
        response.close()

        Json.decodeFromString<ResAuthUser>(body ?: throw Exception("Empty response body"))
    }
}

suspend fun bubbelApiDeauthUser(bath: String, req: InDeauthUser): ResDeauthUser {
    val client = OkHttpClient()
    val json = Json.encodeToString(req)
    val requestBody = json.toRequestBody("application/json".toMediaType())
    val request = Request.Builder()
        .url("$bath/deauth_user")
        .post(requestBody)
        .build()

    return withContext(Dispatchers.IO) {
        val response = client.newCall(request).execute()
        val body = response.body?.string()
        response.close()

        Json.decodeFromString<ResDeauthUser>(body ?: throw Exception("Empty response body"))
    }
}
