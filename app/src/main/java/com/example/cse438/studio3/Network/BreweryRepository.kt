package com.example.cse438_rest_studio.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.data.Brewery
import com.example.cse438_rest_studio.data.Payload
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class BreweryRepository {

    val service = ApiClient.makeRetrofitService()

    //TODO #6: Create a function that launches a coroutine for searching by city
    fun getSearchByCity(resBody: MutableLiveData<List<Brewery>>, city: String){
//        This will occur in the background
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getBreweriesByCity(city)

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        resBody.value = response.body()
                    }
                } catch (e: HttpException){
                    println(e.message())
                }
            }
        }
    }

    //TODO #7: Create a function that launches a coroutine for searching by a generic term
    fun getSearchBySearch(resBody: MutableLiveData<List<Brewery>>, query: String){
//        This will occur in the background
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getBreweriesBySearch(query)

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        resBody.value = response.body()
                    }
                } catch (e: HttpException){
                    println(e.message())
                }
            }
        }
    }
}