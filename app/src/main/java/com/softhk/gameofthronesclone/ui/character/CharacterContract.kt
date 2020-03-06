package com.softhk.gameofthronesclone.ui.character

import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import io.reactivex.rxjava3.core.Observable

interface CharacterContract {
    interface View{
        fun setCharacterList(charactersList:MutableList<CharacterRemoteModel>)
        fun showProgressBar():Unit
        fun hideProgressBar():Unit
        fun showErrorRetry()
    }
    interface Presenter{
        fun getCharacters():Unit
        fun detach():Unit
    }
    interface Model{
        fun getCharacters():Observable<List<CharacterRemoteModel>>
    }

}