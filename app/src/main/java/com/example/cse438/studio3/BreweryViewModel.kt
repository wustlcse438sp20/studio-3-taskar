package com.example.cse438.studio3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.Network.BreweryRepository
import com.example.cse438_rest_studio.data.Brewery
import com.example.cse438_rest_studio.data.Payload


class BreweryViewModel(application: Application): AndroidViewModel(application) {

    //TODO #8: Create a livedata object for tracking breweries
    public var breweryList: MutableLiveData<List<Brewery>> = MutableLiveData()
    public var breweryRepo: BreweryRepository = BreweryRepository()

    //TODO #9: Write functions to access the two brewery API calls from the repository
    fun getBreweriesByCity(city: String){
        breweryRepo.getSearchByCity(breweryList, city)
    }

    fun getBreweriesBySearch(query: String){
        breweryRepo.getSearchBySearch(breweryList, query)
    }
}