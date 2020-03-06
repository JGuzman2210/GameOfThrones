package com.softhk.gameofthronesclone.utils

import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.softhk.gameofthronesclone.R

object CharacterBackground {
    private val DEFAULT_COLOR = arrayOf(R.color.starkOverlay, R.color.starkBase)

    private val resources = mapOf(
        Pair("stark", arrayOf(R.color.starkOverlay, R.color.starkBase,R.drawable.ic_stark)),
        Pair("lannister", arrayOf(R.color.lannisterOverlay, R.color.lannisterBase,R.drawable.ic_lannister)),
        Pair("tyrell", arrayOf(R.color.tyrellOverlay, R.color.tyrellBase,R.drawable.ic_tyrell)),
        Pair("arryn", arrayOf(R.color.arrynOverlay, R.color.arrynBase,R.drawable.ic_arryn)),
        Pair("targaryen", arrayOf(R.color.targaryenOverlay, R.color.targaryenBase,R.drawable.ic_targaryen)),
        Pair("martell", arrayOf(R.color.martellOverlay, R.color.martellBase,R.drawable.ic_martell)),
        Pair("baratheon", arrayOf(R.color.baratheonOverlay, R.color.baratheonBase,R.drawable.ic_baratheon)),
        Pair("greyjoy", arrayOf(R.color.greyjoyOverlay, R.color.greyjoyBase,R.drawable.ic_greyjoy)),
        Pair("frey", arrayOf(R.color.freyOverlay, R.color.freyBase,R.drawable.ic_frey)),
        Pair("tully", arrayOf(R.color.tullyOverlay, R.color.tullyBase,R.drawable.ic_tully))
    )


    fun getOverlayColor(houseId: String): Int {
        val pallete: Array<Int> = resources.get(houseId)!!
        return pallete[0]
    }

    fun getBaseColor(houseId: String): Int {
        val pallete: Array<Int> = resources.get(houseId)!!
        return pallete[1]
    }

    fun getIcon(houseId: String):Int{
        val pallete: Array<Int> = resources.get(houseId)!!
        return pallete[2]
    }
}

fun Snackbar.addBackgroundColor(@ColorInt colorInt:Int):Snackbar{
    this.view.setBackgroundColor(colorInt)
    return this
}
