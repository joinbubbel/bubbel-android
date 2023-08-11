package com.example.bubbel.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bubbel.R
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import com.example.bubbel.model.Club
import com.example.bubbel.repository.ClubRepository

class HomeViewModel(private val repository: ClubRepository):ViewModel() {
    val clubs: LiveData<List<Club>> = liveData {
        emit(repository.getClubsFromXml())
    }
}


