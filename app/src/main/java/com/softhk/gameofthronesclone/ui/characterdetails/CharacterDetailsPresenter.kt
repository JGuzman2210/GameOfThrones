package com.softhk.gameofthronesclone.ui.characterdetails

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterDetailsPresenter constructor(private var view: CharacterDetailsContract.View?) :
    CharacterDetailsContract.Presenter {

    private val model = CharacterDetailsModel()
    private val disposable: CompositeDisposable = CompositeDisposable()


    override fun getCharacterById(characterId: String) {
        disposable.add(model.getCharacterById(characterId = characterId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                run {
                    view?.let {
                        it.setCharacterDetails(result)
                    }
                }
            }, {
                Log.e("ERROR-OUTPUT", "ERROR: ${it.message}")
            })
        )
    }

    override fun detach() {
        disposable.dispose()
        view = null
    }
}