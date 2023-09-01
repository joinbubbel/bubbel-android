package com.example.bubbel.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.bubbel.model.backend.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface backendService {
    @POST("/api/create_user")
    fun createUser(@Body userData: InCreateUser): Call<ResCreateUser>
    @POST("/api/auth_user")
    fun authUser(@Body userData: InAuthUser): Call<ResAuthUser>
    @POST("/api/deauth_user")
    fun deauthUser(@Body userData: InDeauthUser): Call<ResDeauthUser>
    @POST("/api/verify_account")
    fun verifyAccount(@Body userData: InVerifyAccount): Call<ResVerifyAccount>
    @POST("/api/send_verify")
    fun sendVerify(@Body userData: InSendVerify): Call<ResSendVerify>
    @POST("/api/set_user_profile")
    fun setUserProfile(@Body userData: InSetUserProfile): Call<ResSetUserProfile>
    @POST("/api/get_user_profile")
    fun getUserProfile(@Body userData: InGetUserProfile): Call<ResGetUserProfile>
    @POST("/api/delete_user")
    fun deleteUser(@Body userData: InDeleteUser): Call<ResDeleteUser>
    @POST("/api/create_club")
    fun createClub(@Body userData: InCreateClub): Call<ResCreateClub>
    @POST("/api/get_club_profile")
    fun getClubProfile(@Body userData: InGetClubProfile): Call<ResGetClubProfile>
    @POST("/api/set_club_profile")
    fun setClubProfile(@Body userData: InSetClubProfile): Call<ResSetClubProfile>
    @POST("/api/delete_club")
    fun deleteClub(@Body userData: InDeleteClub): Call<ResDeleteClub>
    @POST("/api/get_user_profile_with_username")
    fun getUserProfileWithUsername(@Body userData: InGetUserProfileWithUsername): Call<ResGetUserProfileWithUsername>
    @POST("/api/add_friend_connection")
    fun addFriendConnection(@Body userData: InAddFriendConnection): Call<ResAddFriendConnection>
    @POST("/api/get_friend_connections")
    fun getFriendConnections(@Body userData: InGetFriendConnections): Call<ResGetFriendConnections>
    @POST("/api/remove_friend")
    fun removeFriend(@Body userData: InRemoveFriend): Call<ResRemoveFriend>
    @POST("/api/join_club")
    fun joinClub(@Body userData: InJoinClub): Call<ResJoinClub>
    @POST("/api/unjoin_club")
    fun unjoinClub(@Body userData: InUnjoinClub): Call<ResUnjoinClub>
    @POST("/api/get_club_members")
    fun getClubMembers(@Body userData: InGetClubMembers): Call<ResGetClubMembers>
    @POST("/api/get_user_clubs")
    fun getUserClubs(@Body userData: InGetUserClubs): Call<ResGetUserClubs>
    @POST("/api/regex_search_clubs")
    fun regexSearchClubs(@Body userData: InRegexSearchClubs): Call<ResRegexSearchClubs>
    @POST("/api/regex_search_users")
    fun regexSearchUsers(@Body userData: InRegexSearchUsers): Call<ResRegexSearchUsers>
    @POST("/api/get_random_clubs")
    fun getRandomClubs(@Body userData: InGetRandomClubs): Call<ResGetRandomClubs>
    @POST("/api/check_token")
    fun checkToken(@Body userData: InCheckToken): Call<ResCheckToken>
    @POST("/api/unsafe_add_file")
    fun unsafeAddFile(@Body userData: InUnsafeAddFile): Call<ResUnsafeAddFile>
    @POST("/api/get_data_channel_chunk")
    fun getDataChannelChunk(@Body userData: InGetDataChannelChunk): Call<ResGetDataChannelChunk>
    @POST("/api/get_club_profile_with_name")
    fun getClubProfileWithName(@Body userData: InGetClubProfileWithName): Call<ResGetClubProfileWithName>
    @POST("/api/get_random_users")
    fun getRandomUsers(@Body userData: InGetRandomUsers): Call<ResGetRandomUsers>
    @POST("/api/username_to_id")
    fun usernameToId(@Body userData: InUsernameToId): Call<ResUsernameToId>
    @POST("/api/create_message_room")
    fun createMessageRoom(@Body userData: InCreateMessageRoom): Call<ResCreateMessageRoom>
    @POST("/api/get_message_room")
    fun getMessageRoom(@Body userData: InGetMessageRoom): Call<ResGetMessageRoom>
    @POST("/api/join_message_room")
    fun joinMessageRoom(@Body userData: InJoinMessageRoom): Call<ResJoinMessageRoom>
    @POST("/api/get_club_message_rooms")
    fun getClubMessageRooms(@Body userData: InGetClubMessageRooms): Call<ResGetClubMessageRooms>
    @POST("/api/get_message_room_members")
    fun getMessageRoomMembers(@Body userData: InGetMessageRoomMembers): Call<ResGetMessageRoomMembers>
    @POST("/api/upload_base64")
    fun uploadBase64(@Body userData: InUploadBase64): Call<ResUploadBase64>
    @POST("/api/upload_loose_base64")
    fun uploadLooseBase64(@Body userData: InUploadLooseBase64): Call<ResUploadLooseBase64>
    @POST("/api/resolve_and_upload")
    fun resolveAndUpload(@Body userData: InResolveAndUpload): Call<ResResolveAndUpload>
}

//  This was originally went in "RetrofitClient.kt"
object RetrofitClient {
    val api: backendService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.joinbubbel.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(backendService::class.java)
    }
}

//  This was originally went in "XXXRepository.kt"
class BackendRepository {
    private val backendService = RetrofitClient.api

    suspend fun createUser(request: InCreateUser,  onSuccess: (ResCreateUser?) -> Unit, onError: (String) -> Unit){
        backendService.createUser(request).enqueue(object : Callback<ResCreateUser> {
            override fun onResponse(call: Call<ResCreateUser>, response: Response<ResCreateUser>) {
                if (response.isSuccessful) {
                    val out: ResCreateUser? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResCreateUser>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun authUser(request: InAuthUser,  onSuccess: (ResAuthUser?) -> Unit, onError: (String) -> Unit){
        backendService.authUser(request).enqueue(object : Callback<ResAuthUser> {
            override fun onResponse(call: Call<ResAuthUser>, response: Response<ResAuthUser>) {
                if (response.isSuccessful) {
                    val out: ResAuthUser? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResAuthUser>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun deauthUser(request: InDeauthUser,  onSuccess: (ResDeauthUser?) -> Unit, onError: (String) -> Unit){
        backendService.deauthUser(request).enqueue(object : Callback<ResDeauthUser> {
            override fun onResponse(call: Call<ResDeauthUser>, response: Response<ResDeauthUser>) {
                if (response.isSuccessful) {
                    val out: ResDeauthUser? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResDeauthUser>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun verifyAccount(request: InVerifyAccount,  onSuccess: (ResVerifyAccount?) -> Unit, onError: (String) -> Unit){
        backendService.verifyAccount(request).enqueue(object : Callback<ResVerifyAccount> {
            override fun onResponse(call: Call<ResVerifyAccount>, response: Response<ResVerifyAccount>) {
                if (response.isSuccessful) {
                    val out: ResVerifyAccount? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResVerifyAccount>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun sendVerify(request: InSendVerify,  onSuccess: (ResSendVerify?) -> Unit, onError: (String) -> Unit){
        backendService.sendVerify(request).enqueue(object : Callback<ResSendVerify> {
            override fun onResponse(call: Call<ResSendVerify>, response: Response<ResSendVerify>) {
                if (response.isSuccessful) {
                    val out: ResSendVerify? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResSendVerify>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun setUserProfile(request: InSetUserProfile,  onSuccess: (ResSetUserProfile?) -> Unit, onError: (String) -> Unit){
        backendService.setUserProfile(request).enqueue(object : Callback<ResSetUserProfile> {
            override fun onResponse(call: Call<ResSetUserProfile>, response: Response<ResSetUserProfile>) {
                if (response.isSuccessful) {
                    val out: ResSetUserProfile? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResSetUserProfile>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getUserProfile(request: InGetUserProfile,  onSuccess: (ResGetUserProfile?) -> Unit, onError: (String) -> Unit){
        backendService.getUserProfile(request).enqueue(object : Callback<ResGetUserProfile> {
            override fun onResponse(call: Call<ResGetUserProfile>, response: Response<ResGetUserProfile>) {
                if (response.isSuccessful) {
                    val out: ResGetUserProfile? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetUserProfile>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun deleteUser(request: InDeleteUser,  onSuccess: (ResDeleteUser?) -> Unit, onError: (String) -> Unit){
        backendService.deleteUser(request).enqueue(object : Callback<ResDeleteUser> {
            override fun onResponse(call: Call<ResDeleteUser>, response: Response<ResDeleteUser>) {
                if (response.isSuccessful) {
                    val out: ResDeleteUser? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResDeleteUser>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun createClub(request: InCreateClub,  onSuccess: (ResCreateClub?) -> Unit, onError: (String) -> Unit){
        backendService.createClub(request).enqueue(object : Callback<ResCreateClub> {
            override fun onResponse(call: Call<ResCreateClub>, response: Response<ResCreateClub>) {
                if (response.isSuccessful) {
                    val out: ResCreateClub? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResCreateClub>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getClubProfile(request: InGetClubProfile,  onSuccess: (ResGetClubProfile?) -> Unit, onError: (String) -> Unit){
        backendService.getClubProfile(request).enqueue(object : Callback<ResGetClubProfile> {
            override fun onResponse(call: Call<ResGetClubProfile>, response: Response<ResGetClubProfile>) {
                if (response.isSuccessful) {
                    val out: ResGetClubProfile? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetClubProfile>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun setClubProfile(request: InSetClubProfile,  onSuccess: (ResSetClubProfile?) -> Unit, onError: (String) -> Unit){
        backendService.setClubProfile(request).enqueue(object : Callback<ResSetClubProfile> {
            override fun onResponse(call: Call<ResSetClubProfile>, response: Response<ResSetClubProfile>) {
                if (response.isSuccessful) {
                    val out: ResSetClubProfile? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResSetClubProfile>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun deleteClub(request: InDeleteClub,  onSuccess: (ResDeleteClub?) -> Unit, onError: (String) -> Unit){
        backendService.deleteClub(request).enqueue(object : Callback<ResDeleteClub> {
            override fun onResponse(call: Call<ResDeleteClub>, response: Response<ResDeleteClub>) {
                if (response.isSuccessful) {
                    val out: ResDeleteClub? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResDeleteClub>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getUserProfileWithUsername(request: InGetUserProfileWithUsername,  onSuccess: (ResGetUserProfileWithUsername?) -> Unit, onError: (String) -> Unit){
        backendService.getUserProfileWithUsername(request).enqueue(object : Callback<ResGetUserProfileWithUsername> {
            override fun onResponse(call: Call<ResGetUserProfileWithUsername>, response: Response<ResGetUserProfileWithUsername>) {
                if (response.isSuccessful) {
                    val out: ResGetUserProfileWithUsername? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetUserProfileWithUsername>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun addFriendConnection(request: InAddFriendConnection,  onSuccess: (ResAddFriendConnection?) -> Unit, onError: (String) -> Unit){
        backendService.addFriendConnection(request).enqueue(object : Callback<ResAddFriendConnection> {
            override fun onResponse(call: Call<ResAddFriendConnection>, response: Response<ResAddFriendConnection>) {
                if (response.isSuccessful) {
                    val out: ResAddFriendConnection? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResAddFriendConnection>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getFriendConnections(request: InGetFriendConnections,  onSuccess: (ResGetFriendConnections?) -> Unit, onError: (String) -> Unit){
        backendService.getFriendConnections(request).enqueue(object : Callback<ResGetFriendConnections> {
            override fun onResponse(call: Call<ResGetFriendConnections>, response: Response<ResGetFriendConnections>) {
                if (response.isSuccessful) {
                    val out: ResGetFriendConnections? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetFriendConnections>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun removeFriend(request: InRemoveFriend,  onSuccess: (ResRemoveFriend?) -> Unit, onError: (String) -> Unit){
        backendService.removeFriend(request).enqueue(object : Callback<ResRemoveFriend> {
            override fun onResponse(call: Call<ResRemoveFriend>, response: Response<ResRemoveFriend>) {
                if (response.isSuccessful) {
                    val out: ResRemoveFriend? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResRemoveFriend>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun joinClub(request: InJoinClub,  onSuccess: (ResJoinClub?) -> Unit, onError: (String) -> Unit){
        backendService.joinClub(request).enqueue(object : Callback<ResJoinClub> {
            override fun onResponse(call: Call<ResJoinClub>, response: Response<ResJoinClub>) {
                if (response.isSuccessful) {
                    val out: ResJoinClub? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResJoinClub>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun unjoinClub(request: InUnjoinClub,  onSuccess: (ResUnjoinClub?) -> Unit, onError: (String) -> Unit){
        backendService.unjoinClub(request).enqueue(object : Callback<ResUnjoinClub> {
            override fun onResponse(call: Call<ResUnjoinClub>, response: Response<ResUnjoinClub>) {
                if (response.isSuccessful) {
                    val out: ResUnjoinClub? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResUnjoinClub>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getClubMembers(request: InGetClubMembers,  onSuccess: (ResGetClubMembers?) -> Unit, onError: (String) -> Unit){
        backendService.getClubMembers(request).enqueue(object : Callback<ResGetClubMembers> {
            override fun onResponse(call: Call<ResGetClubMembers>, response: Response<ResGetClubMembers>) {
                if (response.isSuccessful) {
                    val out: ResGetClubMembers? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetClubMembers>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getUserClubs(request: InGetUserClubs,  onSuccess: (ResGetUserClubs?) -> Unit, onError: (String) -> Unit){
        backendService.getUserClubs(request).enqueue(object : Callback<ResGetUserClubs> {
            override fun onResponse(call: Call<ResGetUserClubs>, response: Response<ResGetUserClubs>) {
                if (response.isSuccessful) {
                    val out: ResGetUserClubs? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetUserClubs>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun regexSearchClubs(request: InRegexSearchClubs,  onSuccess: (ResRegexSearchClubs?) -> Unit, onError: (String) -> Unit){
        backendService.regexSearchClubs(request).enqueue(object : Callback<ResRegexSearchClubs> {
            override fun onResponse(call: Call<ResRegexSearchClubs>, response: Response<ResRegexSearchClubs>) {
                if (response.isSuccessful) {
                    val out: ResRegexSearchClubs? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResRegexSearchClubs>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun regexSearchUsers(request: InRegexSearchUsers,  onSuccess: (ResRegexSearchUsers?) -> Unit, onError: (String) -> Unit){
        backendService.regexSearchUsers(request).enqueue(object : Callback<ResRegexSearchUsers> {
            override fun onResponse(call: Call<ResRegexSearchUsers>, response: Response<ResRegexSearchUsers>) {
                if (response.isSuccessful) {
                    val out: ResRegexSearchUsers? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResRegexSearchUsers>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getRandomClubs(request: InGetRandomClubs,  onSuccess: (ResGetRandomClubs?) -> Unit, onError: (String) -> Unit){
        backendService.getRandomClubs(request).enqueue(object : Callback<ResGetRandomClubs> {
            override fun onResponse(call: Call<ResGetRandomClubs>, response: Response<ResGetRandomClubs>) {
                if (response.isSuccessful) {
                    val out: ResGetRandomClubs? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetRandomClubs>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun checkToken(request: InCheckToken,  onSuccess: (ResCheckToken?) -> Unit, onError: (String) -> Unit){
        backendService.checkToken(request).enqueue(object : Callback<ResCheckToken> {
            override fun onResponse(call: Call<ResCheckToken>, response: Response<ResCheckToken>) {
                if (response.isSuccessful) {
                    val out: ResCheckToken? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResCheckToken>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun unsafeAddFile(request: InUnsafeAddFile,  onSuccess: (ResUnsafeAddFile?) -> Unit, onError: (String) -> Unit){
        backendService.unsafeAddFile(request).enqueue(object : Callback<ResUnsafeAddFile> {
            override fun onResponse(call: Call<ResUnsafeAddFile>, response: Response<ResUnsafeAddFile>) {
                if (response.isSuccessful) {
                    val out: ResUnsafeAddFile? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResUnsafeAddFile>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getDataChannelChunk(request: InGetDataChannelChunk,  onSuccess: (ResGetDataChannelChunk?) -> Unit, onError: (String) -> Unit){
        backendService.getDataChannelChunk(request).enqueue(object : Callback<ResGetDataChannelChunk> {
            override fun onResponse(call: Call<ResGetDataChannelChunk>, response: Response<ResGetDataChannelChunk>) {
                if (response.isSuccessful) {
                    val out: ResGetDataChannelChunk? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetDataChannelChunk>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getClubProfileWithName(request: InGetClubProfileWithName,  onSuccess: (ResGetClubProfileWithName?) -> Unit, onError: (String) -> Unit){
        backendService.getClubProfileWithName(request).enqueue(object : Callback<ResGetClubProfileWithName> {
            override fun onResponse(call: Call<ResGetClubProfileWithName>, response: Response<ResGetClubProfileWithName>) {
                if (response.isSuccessful) {
                    val out: ResGetClubProfileWithName? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetClubProfileWithName>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getRandomUsers(request: InGetRandomUsers,  onSuccess: (ResGetRandomUsers?) -> Unit, onError: (String) -> Unit){
        backendService.getRandomUsers(request).enqueue(object : Callback<ResGetRandomUsers> {
            override fun onResponse(call: Call<ResGetRandomUsers>, response: Response<ResGetRandomUsers>) {
                if (response.isSuccessful) {
                    val out: ResGetRandomUsers? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetRandomUsers>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun usernameToId(request: InUsernameToId,  onSuccess: (ResUsernameToId?) -> Unit, onError: (String) -> Unit){
        backendService.usernameToId(request).enqueue(object : Callback<ResUsernameToId> {
            override fun onResponse(call: Call<ResUsernameToId>, response: Response<ResUsernameToId>) {
                if (response.isSuccessful) {
                    val out: ResUsernameToId? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResUsernameToId>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun createMessageRoom(request: InCreateMessageRoom,  onSuccess: (ResCreateMessageRoom?) -> Unit, onError: (String) -> Unit){
        backendService.createMessageRoom(request).enqueue(object : Callback<ResCreateMessageRoom> {
            override fun onResponse(call: Call<ResCreateMessageRoom>, response: Response<ResCreateMessageRoom>) {
                if (response.isSuccessful) {
                    val out: ResCreateMessageRoom? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResCreateMessageRoom>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getMessageRoom(request: InGetMessageRoom,  onSuccess: (ResGetMessageRoom?) -> Unit, onError: (String) -> Unit){
        backendService.getMessageRoom(request).enqueue(object : Callback<ResGetMessageRoom> {
            override fun onResponse(call: Call<ResGetMessageRoom>, response: Response<ResGetMessageRoom>) {
                if (response.isSuccessful) {
                    val out: ResGetMessageRoom? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetMessageRoom>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun joinMessageRoom(request: InJoinMessageRoom,  onSuccess: (ResJoinMessageRoom?) -> Unit, onError: (String) -> Unit){
        backendService.joinMessageRoom(request).enqueue(object : Callback<ResJoinMessageRoom> {
            override fun onResponse(call: Call<ResJoinMessageRoom>, response: Response<ResJoinMessageRoom>) {
                if (response.isSuccessful) {
                    val out: ResJoinMessageRoom? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResJoinMessageRoom>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getClubMessageRooms(request: InGetClubMessageRooms,  onSuccess: (ResGetClubMessageRooms?) -> Unit, onError: (String) -> Unit){
        backendService.getClubMessageRooms(request).enqueue(object : Callback<ResGetClubMessageRooms> {
            override fun onResponse(call: Call<ResGetClubMessageRooms>, response: Response<ResGetClubMessageRooms>) {
                if (response.isSuccessful) {
                    val out: ResGetClubMessageRooms? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetClubMessageRooms>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun getMessageRoomMembers(request: InGetMessageRoomMembers,  onSuccess: (ResGetMessageRoomMembers?) -> Unit, onError: (String) -> Unit){
        backendService.getMessageRoomMembers(request).enqueue(object : Callback<ResGetMessageRoomMembers> {
            override fun onResponse(call: Call<ResGetMessageRoomMembers>, response: Response<ResGetMessageRoomMembers>) {
                if (response.isSuccessful) {
                    val out: ResGetMessageRoomMembers? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResGetMessageRoomMembers>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun uploadBase64(request: InUploadBase64,  onSuccess: (ResUploadBase64?) -> Unit, onError: (String) -> Unit){
        backendService.uploadBase64(request).enqueue(object : Callback<ResUploadBase64> {
            override fun onResponse(call: Call<ResUploadBase64>, response: Response<ResUploadBase64>) {
                if (response.isSuccessful) {
                    val out: ResUploadBase64? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResUploadBase64>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun uploadLooseBase64(request: InUploadLooseBase64,  onSuccess: (ResUploadLooseBase64?) -> Unit, onError: (String) -> Unit){
        backendService.uploadLooseBase64(request).enqueue(object : Callback<ResUploadLooseBase64> {
            override fun onResponse(call: Call<ResUploadLooseBase64>, response: Response<ResUploadLooseBase64>) {
                if (response.isSuccessful) {
                    val out: ResUploadLooseBase64? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResUploadLooseBase64>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
    suspend fun resolveAndUpload(request: InResolveAndUpload,  onSuccess: (ResResolveAndUpload?) -> Unit, onError: (String) -> Unit){
        backendService.resolveAndUpload(request).enqueue(object : Callback<ResResolveAndUpload> {
            override fun onResponse(call: Call<ResResolveAndUpload>, response: Response<ResResolveAndUpload>) {
                if (response.isSuccessful) {
                    val out: ResResolveAndUpload? = response.body()
                    onSuccess(out)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error occurred")
                }
            }

            override fun onFailure(call: Call<ResResolveAndUpload>, t: Throwable) {
                onError(t.message ?: "Network request failed")
            }
        })
    }
}