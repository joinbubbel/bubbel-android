package com.example.bubbel.viewmodel.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bubbel.model.Club
import com.example.bubbel.repository.ClubRepository

class ClubViewModel(private val repository: ClubRepository): ViewModel() {

    val clubs: LiveData<List<Club>> = liveData {
        emit(repository.getClubsFromXml())
    }
}
