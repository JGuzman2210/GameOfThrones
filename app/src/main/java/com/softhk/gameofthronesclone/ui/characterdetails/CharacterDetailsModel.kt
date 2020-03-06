package com.softhk.gameofthronesclone.ui.characterdetails

import com.softhk.gameofthronesclone.data.CharacterRepository
import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import io.reactivex.rxjava3.core.Single

class CharacterDetailsModel : CharacterDetailsContract.Model {

    private val repository: CharacterRepository = CharacterRepository()

    override fun getCharacterById(characterId: String): Single<CharacterRemoteModel> {
            return repository.getCharacterById(characterId)
    }
}