package com.mbn.cabme.repository

import com.mbn.cabme.network.ApiResponse
import com.mbn.cabme.network.ImdbService
import io.reactivex.Single
import javax.inject.Inject

class ComingSoonRepository @Inject constructor(val imdbService: ImdbService) {
    fun executeCheckUSer(): Single<ApiResponse> {
        return imdbService.getComingSoonMovies()
    }
}