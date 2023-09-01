import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                = Json { allowStructuredMapKeys = true }
// val resResolveAndUpload = json.parse(ResResolveAndUpload.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResResolveAndUpload (
    val error: ResolveAndUploadError? = null,
    val res: ResolveAndUploadOut? = null
)

@Serializable
data class ResolveAndUploadError (
    @SerializedName("fetch_error")
    val fetchError: String? = null,

    val type: ResResolveAndUploadErrorType,

    @SerializedName("fetch_bytes_error")
    val fetchBytesError: String? = null,

    val ierror: String? = null
)

@Serializable
enum class ResResolveAndUploadErrorType(val value: String) {
    @SerializedName("CannotGetUrlFileName") CannotGetURLFileName("CannotGetUrlFileName"),
    @SerializedName("ConvertToBase64Failed") ConvertToBase64Failed("ConvertToBase64Failed"),
    @SerializedName("DataConstraint") DataConstraint("DataConstraint"),
    @SerializedName("FetchBytesFailed") FetchBytesFailed("FetchBytesFailed"),
    @SerializedName("FetchFailed") FetchFailed("FetchFailed"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class ResolveAndUploadOut (
    @SerializedName("object_name")
    val objectName: String
)
