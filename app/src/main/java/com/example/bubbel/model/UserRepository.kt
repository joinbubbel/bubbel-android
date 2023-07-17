import com.example.bubbel.model.FetchErrorException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class UserRepository {
    private val BUBBEL_BATH_DEV = "https://bubbel-bath.onrender.com"

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
}


