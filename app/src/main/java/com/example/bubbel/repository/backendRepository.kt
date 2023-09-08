package com.example.bubbel.repository

import android.content.Context
import com.example.bubbel.model.backend.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BackendRepository (context: Context) {

    private val retrofitClient = RetrofitClient(context).api.create(BackendService::class.java)

    suspend fun createUser(request: InCreateUser, onSuccess: (ResCreateUser?) -> Unit, onError: (String) -> Unit){
        retrofitClient.createUser(request).enqueue(object : Callback<ResCreateUser> {
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
        retrofitClient.authUser(request).enqueue(object : Callback<ResAuthUser> {
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
        retrofitClient.deauthUser(request).enqueue(object : Callback<ResDeauthUser> {
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
        retrofitClient.verifyAccount(request).enqueue(object : Callback<ResVerifyAccount> {
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
        retrofitClient.sendVerify(request).enqueue(object : Callback<ResSendVerify> {
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
        retrofitClient.setUserProfile(request).enqueue(object : Callback<ResSetUserProfile> {
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
        retrofitClient.getUserProfile(request).enqueue(object : Callback<ResGetUserProfile> {
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
        retrofitClient.deleteUser(request).enqueue(object : Callback<ResDeleteUser> {
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
        retrofitClient.createClub(request).enqueue(object : Callback<ResCreateClub> {
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
        retrofitClient.getClubProfile(request).enqueue(object : Callback<ResGetClubProfile> {
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
        retrofitClient.setClubProfile(request).enqueue(object : Callback<ResSetClubProfile> {
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
        retrofitClient.deleteClub(request).enqueue(object : Callback<ResDeleteClub> {
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
        retrofitClient.getUserProfileWithUsername(request).enqueue(object : Callback<ResGetUserProfileWithUsername> {
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
        retrofitClient.addFriendConnection(request).enqueue(object : Callback<ResAddFriendConnection> {
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
        retrofitClient.getFriendConnections(request).enqueue(object : Callback<ResGetFriendConnections> {
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
        retrofitClient.removeFriend(request).enqueue(object : Callback<ResRemoveFriend> {
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
        retrofitClient.joinClub(request).enqueue(object : Callback<ResJoinClub> {
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
        retrofitClient.unjoinClub(request).enqueue(object : Callback<ResUnjoinClub> {
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
        retrofitClient.getClubMembers(request).enqueue(object : Callback<ResGetClubMembers> {
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
        retrofitClient.getUserClubs(request).enqueue(object : Callback<ResGetUserClubs> {
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
        retrofitClient.regexSearchClubs(request).enqueue(object : Callback<ResRegexSearchClubs> {
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
        retrofitClient.regexSearchUsers(request).enqueue(object : Callback<ResRegexSearchUsers> {
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
        retrofitClient.getRandomClubs(request).enqueue(object : Callback<ResGetRandomClubs> {
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
        retrofitClient.checkToken(request).enqueue(object : Callback<ResCheckToken> {
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
        retrofitClient.unsafeAddFile(request).enqueue(object : Callback<ResUnsafeAddFile> {
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
}