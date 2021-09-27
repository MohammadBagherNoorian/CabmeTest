package com.mbn.cabme.network
import java.io.Serializable
import com.google.gson.annotations.SerializedName
import com.mbn.cabme.model.Movie

class ApiResponse : Serializable {

    @SerializedName("items")
    var items:ArrayList<Movie>?=null
    @SerializedName("errorMessage")
    var errorMessage :String?=null
}