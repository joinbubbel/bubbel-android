package com.example.bubbel

import androidx.lifecycle.viewmodel.ViewModelInitializer
import kotlinx.serialization.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.net.HttpURLConnection
import java.net.URL

// -- Types --
@Serializable
class InCreateUser(
    @SerialName("email")
    var email: String,
    @SerialName("username")
    var username: String,
    @SerialName("password")
    var password: String,
) {
    companion object {
        fun fromJson(json: String): InCreateUser {
            return Json.decodeFromString(json)
        }
    }

    fun toJson(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
class CreateUserError(
	var type: String,
	var error: String?,
)

@Serializable
class ResCreateUser(
    @SerialName("error")
    val error: CreateUserError?,
    @SerialName("token")
    val token: String?,
    @SerialName("username")
    val username: String?,
    @SerialName("email")
    val email: String?
)

@Serializable
class InAuthUser(
    var username: String,
    var password: String,
)

@Serializable
class ResAuthUser(
    val error: AuthUserError?,
    val token: String?,
    val username: String?,
    val email: String?,
)

@Serializable
class AuthUserError(
	val type: String,
	val error: String?,
)

@Serializable
class InDeauthUser(
    var token: String,
)

var bubbelBathDev: String = "https://bubbel-bath.onrender.com/api";

class FetchErrorException(message: String) : Exception(message)

suspend fun signUp(email: String, username: String, password: String, isUsernameAvailable: Boolean = true) {
    if (!isValidEmail(email)) {
        println("Invalid email format")
        return
    }

    if (!isValidPassword(password)) {
        println("Invalid password format")
        return
    }

    val createUserRequest = InCreateUser(email, username, password)
    try {
        val response = createUserAPIRequest(createUserRequest)
        // Handle the response
        if (response.error != null) {
            // Handle CreateUserError
        } else {
            // User creation success
            val token = response.token
            val responseUsername = response.username
            val responseEmail = response.email
            // Continue with further processing
        }
    } catch (e: FetchErrorException) {
        // Handle the error
        println("Error: ${e.message}")
    }
}

suspend fun createUserAPIRequest(request: InCreateUser): ResCreateUser = withContext(Dispatchers.IO) {
    val encoder = Json { ignoreUnknownKeys = true }
    val json = encoder.encodeToString(request)
    println(json)
    val url = URL("$bubbelBathDev/create_user") // Update the endpoint based on your API
    val urlConnection = url.openConnection() as HttpURLConnection
    urlConnection.requestMethod = "POST"
    urlConnection.setRequestProperty("Content-Type", "application/json")
    urlConnection.doOutput = true
    urlConnection.outputStream.use { outputStream ->
        outputStream.write(json.toByteArray())
    }

    val responseCode = urlConnection.responseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
        val responseString = urlConnection.inputStream.bufferedReader().use { it.readText() }
        println(responseString)
        val decoder = Json { ignoreUnknownKeys = true }
        try {
            decoder.decodeFromString(responseString)
        } catch (ex: SerializationException) {
            throw FetchErrorException("Error decoding response: ${ex.message}")
        }
    } else {
        throw FetchErrorException("Error fetching data. Response code: $responseCode")
    }
}

private fun isValidEmail(email: String): Boolean {
    val emailRegex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
    return email.matches(emailRegex.toRegex())
}

private fun isValidPassword(password: String): Boolean {
    val passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$"
    return password.matches(passwordRegex.toRegex())
}


suspend fun bubbelApiAuthUser(bath: String, req: InAuthUser): ResAuthUser {
    val encoder = Json { ignoreUnknownKeys = true }
    val json = encoder.encodeToString(req)
    val url = URL("$bath/api/auth_user")
    val urlConnection = url.openConnection() as HttpURLConnection
    urlConnection.requestMethod = "POST"
    urlConnection.setRequestProperty("Content-Type", "application/json")
    urlConnection.doOutput = true
    urlConnection.outputStream.use { outputStream ->
        outputStream.write(json.toByteArray())
    }

    val responseCode = urlConnection.responseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
        val responseString = urlConnection.inputStream.bufferedReader().use { it.readText() }
        val decoder = Json { ignoreUnknownKeys = true }
        return try {
            decoder.decodeFromString(responseString)
        } catch (ex: SerializationException) {
            throw FetchErrorException("Error decoding response: ${ex.message}")
        }
    } else {
        throw FetchErrorException("Error fetching data. Response code: $responseCode")
    }
}


suspend fun bubbelApiDeauthUser(bath: String, req: InDeauthUser) {
    val encoder = Json { ignoreUnknownKeys = true }
    val json = encoder.encodeToString(req)
    val url = URL("$bath/api/deauth_user")
    val urlConnection = url.openConnection() as HttpURLConnection
    urlConnection.requestMethod = "POST"
    urlConnection.setRequestProperty("Content-Type", "application/json")
    urlConnection.doOutput = true
    urlConnection.outputStream.use { outputStream ->
        outputStream.write(json.toByteArray())
    }

    val responseCode = urlConnection.responseCode
    if (responseCode != HttpURLConnection.HTTP_OK) {
        FetchErrorException("Error decoding response:")
    }
}
