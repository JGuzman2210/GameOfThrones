package com.softhk.gameofthronesclone.data.models


import com.google.gson.annotations.SerializedName

data class HouseRemoteModel(
    @SerializedName("img")
    var img: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("region")
    var region: String,
    @SerializedName("words")
    var words: String
)