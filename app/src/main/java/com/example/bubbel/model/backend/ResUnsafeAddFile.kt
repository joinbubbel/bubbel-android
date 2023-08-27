import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json             = Json { allowStructuredMapKeys = true }
// val resUnsafeAddFile = json.parse(ResUnsafeAddFile.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResUnsafeAddFile (
    val error: UnsafeAddFileError? = null,
    val res: UnsafeAddFileOut? = null
)

@Serializable
data class UnsafeAddFileError (
    @SerializedName("base64_error")
    val base64Error: String? = null,

    val type: ResUnsafeAddFileErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResUnsafeAddFileErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("InvalidBase64") InvalidBase64("InvalidBase64");
}

@Serializable
data class UnsafeAddFileOut (
    @SerializedName("file_link")
    val fileLink: String
)
