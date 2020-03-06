package com.softhk.gameofthronesclone.ui.character

import com.softhk.gameofthronesclone.data.CharacterRepository
import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import io.reactivex.rxjava3.core.Observable

class CharacterModel : CharacterContract.Model {

    private val repository = CharacterRepository()

    override fun getCharacters(): Observable<List<CharacterRemoteModel>> {
        return repository.getCharacters()
    }
}