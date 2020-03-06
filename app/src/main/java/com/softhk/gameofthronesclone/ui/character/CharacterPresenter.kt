package com.softhk.gameofthronesclone.ui.character

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterPresenter constructor(private var view: CharacterContract.View?) :
    CharacterContract.Presenter {

    private val model: CharacterContract.Model = CharacterModel()
    private val disposable: CompositeDisposable = CompositeDisposable()

    override fun getCharacters() {
        view?.showProgressBar()
        disposable.add(
            model.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        view?.setCharacterList(result.toMutableList())
                        view?.hideProgressBar()
                    },
                    {
                        Log.d("RESULTADO-RETROFIT", it.message)
                        view?.showErrorRetry()
                    }
                ))
    }

    override fun detach() {
        disposable.dispose()
        view = null
    }


}