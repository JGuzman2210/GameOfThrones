package com.softhk.gameofthronesclone.data

import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import com.softhk.gameofthronesclone.data.remote.RemoteDataSource
import com.softhk.gameofthronesclone.data.remote.api.ApiService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class CharacterRepository : RemoteDataSource {


    override fun getCharacters(): Observable<List<CharacterRemoteModel>>{
        return ApiService.getApiCharacterService().GetCharacters()
    }

    override fun getCharacterById(characterId: String): Single<CharacterRemoteModel> {
        return ApiService.getApiCharacterService().GetCharacter(characterId = characterId)
    }

}