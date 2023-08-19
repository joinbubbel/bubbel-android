// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json              = Json { allowStructuredMapKeys = true }
// val resSetClubProfile = json.parse(ResSetClubProfile.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResSetClubProfile (
    val error: SetClubProfileError? = null,
    val res: JsonObject? = null
)

/**
 * The user is not the owner and therefore is not authorized.
 */
@Serializable
data class SetClubProfileError (
    val type: ResSetClubProfileErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResSetClubProfileErrorType(val value: String) {
    @SerializedName("ClubNotFound") ClubNotFound("ClubNotFound"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth"),
    @SerializedName("NoAuthOwner") NoAuthOwner("NoAuthOwner"),
    @SerializedName("SettingDCNotSupportedYet") SettingDCNotSupportedYet("SettingDCNotSupportedYet"),
    @SerializedName("SettingNameNotSupportedYet") SettingNameNotSupportedYet("SettingNameNotSupportedYet"),
    @SerializedName("SettingOwnerNotSupportedYet") SettingOwnerNotSupportedYet("SettingOwnerNotSupportedYet");
}
