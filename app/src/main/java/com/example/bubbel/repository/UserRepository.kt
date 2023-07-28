package com.example.bubbel.repository

import InCreateUser
import ResCreateUser
import com.example.bubbel.model.FetchErrorException
import com.example.bubbel.model.InAuthUser
import com.example.bubbel.model.ResAuthUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection
import java.net.URL

class UserRepository {
    private val BUBBEL_BATH_DEV = "https://bubbel-bath.onrender.com"
    private val loginService = RetrofitClient.api
    suspend fun createUser(request: InCreateUser): ResCreateUser = withContext(Dispatchers.IO) {
        val encoder = Json { ignoreUnknownKeys = true }
        val json = encoder.encodeToString(request)

        val url = URL("$BUBBEL_BATH_DEV/api/create_user")
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
            try {
                decoder.decodeFromString(responseString)
            } catch (ex: SerializationException) {
                throw FetchErrorException("Error decoding response: ${ex.message}")
            }
        } else {
            throw FetchErrorException("Error fetching data. Response code: $responseCode")
        }
    }

    suspend fun loginUser(request: InAuthUser,  onSuccess: (ResAuthUser?) -> Unit, onError: (String) -> Unit){
        loginService.loginUser(request).enqueue(object : Callback<ResAuthUser> {
            override fun onResponse(call: Call<ResAuthUser>, response: Response<ResAuthUser>) {
                if (response.isSuccessful) {
                    val reAuthUser: ResAuthUser? = response.body()
                    onSuccess(reAuthUser)
                }else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResAuthUser>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }

}


