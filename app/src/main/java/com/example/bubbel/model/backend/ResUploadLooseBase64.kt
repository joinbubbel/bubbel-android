import com.google.gson.annotations.SerializedName
// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json                 = Json { allowStructuredMapKeys = true }
// val resUploadLooseBase64 = json.parse(ResUploadLooseBase64.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResUploadLooseBase64 (
    val error: UploadLooseBase64Error? = null,
    val res: UploadLooseBase64Out? = null
)

@Serializable
data class UploadLooseBase64Error (
    val type: ResUploadLooseBase64ErrorType,

    @SerializedName("data_constraint_error")
    val dataConstraintError: String? = null,

    val ierror: String? = null
)

@Serializable
enum class ResUploadLooseBase64ErrorType(val value: String) {
    @SerializedName("DataConstraint") DataConstraint("DataConstraint"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("InvalidBase64") InvalidBase64("InvalidBase64"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class UploadLooseBase64Out (
    @SerializedName("object_name")
    val objectName: String
)
