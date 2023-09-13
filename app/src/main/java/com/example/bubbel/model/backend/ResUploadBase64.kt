import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json            = Json { allowStructuredMapKeys = true }
// val resUploadBase64 = json.parse(ResUploadBase64.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResUploadBase64 (
    val error: UploadBase64Error? = null,
    val res: UploadBase64Out? = null
)

@Serializable
data class UploadBase64Error (
    val type: ResUploadBase64ErrorType,

    @SerializedName("data_corrupt_error")
    val dataCorruptError: String? = null,

    @SerializedName("data_constraint_error")
    val dataConstraintError: String? = null,

    val ierror: String? = null
)

@Serializable
enum class ResUploadBase64ErrorType(val value: String) {
    @SerializedName("DataConstraint") DataConstraint("DataConstraint"),
    @SerializedName("DataCorrupt") DataCorrupt("DataCorrupt"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("InvalidBase64") InvalidBase64("InvalidBase64"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class UploadBase64Out (
    @SerializedName("object_name")
    val objectName: String
)
