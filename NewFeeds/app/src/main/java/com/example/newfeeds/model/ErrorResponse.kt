package com.example.newfeeds.model

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("Data")
    val `data`: Data? = Data(),
    @SerializedName("Message")
    val message: String? = null
) {
    data class Data(
        @SerializedName("ErrorCode")
        val errorCode: String? = null,
        @SerializedName("Message")
        val message: String? = null
    )
}
