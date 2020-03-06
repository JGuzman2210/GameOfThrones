package com.softhk.gameofthronesclone.data.remote

import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiCharacterService {

    @GET("Characters")
    fun GetCharacters():Observable<List<CharacterRemoteModel>>

    @GET("Characters/{id}")
    fun GetCharacter(@Path("id") characterId:String):Single<CharacterRemoteModel>
}