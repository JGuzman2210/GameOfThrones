package com.softhk.gameofthronesclone.ui.characterdetails

import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import io.reactivex.rxjava3.core.Single

interface CharacterDetailsContract {

    interface View{
        fun setCharacterDetails(model:CharacterRemoteModel)
    }
    interface Presenter{
        fun getCharacterById(characterId:String)
        fun detach():Unit
    }
    interface Model{
        fun getCharacterById(characterId:String):Single<CharacterRemoteModel>
    }
}