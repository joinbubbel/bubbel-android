package com.example.bubbel.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkConnection {
    fun hasNetwork(context: Context): Boolean? {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> return true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            else -> return false
        }
    }
}