package com.example.bubbel.model

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.bubbel.R
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import com.example.bubbel.model.Club
import com.example.bubbel.repository.ClubRepository
import com.google.gson.Gson
import java.io.IOException


class HomeViewModel(private val repository: ClubRepository, private val application: Application): ViewModel() {

    val gson = Gson()

    fun loadData(): List<Club> {
        val jsonData = repository.loadJSONFromRaw(application, R.raw.data)
        val myData = gson.fromJson(jsonData, Array<Club>::class.java)

        return myData.toList()
    }
}


class HomeViewModelFactory(
    private val repository: ClubRepository,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


