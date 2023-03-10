package com.example.lovecalculator.app

import com.example.lovecalculator.model.CalculateModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CalculateApi {
     @GET("getPercentage")
    fun getPercentage(
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
        @Header("X-RapidAPI-Key") apiKey: String = "155cab5966mshcf55819c512f680p14f70bjsn0260aca6455e"
    ): retrofit2.Call<CalculateModel>
}