// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json             = Json { allowStructuredMapKeys = true }
// val resUnsafeAddFile = json.parse(ResUnsafeAddFile.serializer(), jsonString)

package com.example.bubbel.model.backend

import com.google.gson.annotations.SerializedName
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
    val ierror: String,
    val type: ResUnsafeAddFileErrorType
)

@Serializable
enum class ResUnsafeAddFileErrorType(val value: String) {
    @SerializedName("Internal") Internal("Internal");
}

@Serializable
data class UnsafeAddFileOut (
    @SerializedName("file_link")
    val fileLink: String
)
