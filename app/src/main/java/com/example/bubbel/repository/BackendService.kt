package com.example.bubbel.repository

import com.example.bubbel.model.backend.InAddFriendConnection
import com.example.bubbel.model.backend.InAuthUser
import com.example.bubbel.model.backend.InCheckToken
import com.example.bubbel.model.backend.InCreateClub
import com.example.bubbel.model.backend.InCreateUser
import com.example.bubbel.model.backend.InDeauthUser
import com.example.bubbel.model.backend.InDeleteClub
import com.example.bubbel.model.backend.InDeleteUser
import com.example.bubbel.model.backend.InGetClubMembers
import com.example.bubbel.model.backend.InGetClubProfile
import com.example.bubbel.model.backend.InGetFriendConnections
import com.example.bubbel.model.backend.InGetRandomClubs
import com.example.bubbel.model.backend.InGetUserClubs
import com.example.bubbel.model.backend.InGetUserProfile
import com.example.bubbel.model.backend.InGetUserProfileWithUsername
import com.example.bubbel.model.backend.InJoinClub
import com.example.bubbel.model.backend.InRegexSearchClubs
import com.example.bubbel.model.backend.InRegexSearchUsers
import com.example.bubbel.model.backend.InRemoveFriend
import com.example.bubbel.model.backend.InSendVerify
import com.example.bubbel.model.backend.InSetClubProfile
import com.example.bubbel.model.backend.InSetUserProfile
import com.example.bubbel.model.backend.InUnjoinClub
import com.example.bubbel.model.backend.InUnsafeAddFile
import com.example.bubbel.model.backend.InVerifyAccount
import com.example.bubbel.model.backend.ResAddFriendConnection
import com.example.bubbel.model.backend.ResAuthUser
import com.example.bubbel.model.backend.ResCheckToken
import com.example.bubbel.model.backend.ResCreateClub
import com.example.bubbel.model.backend.ResCreateUser
import com.example.bubbel.model.backend.ResDeauthUser
import com.example.bubbel.model.backend.ResDeleteClub
import com.example.bubbel.model.backend.ResDeleteUser
import com.example.bubbel.model.backend.ResGetClubMembers
import com.example.bubbel.model.backend.ResGetClubProfile
import com.example.bubbel.model.backend.ResGetFriendConnections
import com.example.bubbel.model.backend.ResGetRandomClubs
import com.example.bubbel.model.backend.ResGetUserClubs
import com.example.bubbel.model.backend.ResGetUserProfile
import com.example.bubbel.model.backend.ResGetUserProfileWithUsername
import com.example.bubbel.model.backend.ResJoinClub
import com.example.bubbel.model.backend.ResRegexSearchClubs
import com.example.bubbel.model.backend.ResRegexSearchUsers
import com.example.bubbel.model.backend.ResRemoveFriend
import com.example.bubbel.model.backend.ResSendVerify
import com.example.bubbel.model.backend.ResSetClubProfile
import com.example.bubbel.model.backend.ResSetUserProfile
import com.example.bubbel.model.backend.ResUnjoinClub
import com.example.bubbel.model.backend.ResUnsafeAddFile
import com.example.bubbel.model.backend.ResVerifyAccount
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BackendService {

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
}