package com.softhk.gameofthronesclone.data.remote

import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun getCharacters():Observable<List<CharacterRemoteModel>>
    fun getCharacterById(characterId:String):Single<CharacterRemoteModel>
}