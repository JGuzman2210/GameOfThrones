package com.softhk.gameofthronesclone.data.models


import com.google.gson.annotations.SerializedName

data class CharacterRemoteModel(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("born")
    var born: String,
    @SerializedName("actor")
    var actor: String,
    @SerializedName("mother")
    var mother: String,
    @SerializedName("father")
    var father: String,
    @SerializedName("quote")
    var quote: String,
    @SerializedName("spouse")
    var spouse: String,
    @SerializedName("img")
    var img: String,
    @SerializedName("house")
    var houseRemoteModel: HouseRemoteModel
)