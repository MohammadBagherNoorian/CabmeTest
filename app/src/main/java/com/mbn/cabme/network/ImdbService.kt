package com.mbn.cabme.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImdbService {
    @Headers("content-type:application/x-www-form-urlencoded")
    @GET("ComingSoon/k_0s8i0geb")
    fun getComingSoonMovies(
    ): Single<ApiResponse>
}