package com.softhk.gameofthronesclone.ui.characterdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.softhk.gameofthronesclone.R

class CharacterDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)


        val characterKey = intent.getStringExtra("CHARACTER_KEY")

        characterKey?.let{
           val characterDetailsFragment = CharacterDetailsFragment.newInstance(characterKey)
            supportFragmentManager.beginTransaction()
                .replace(R.id.characterDetailsFragment,characterDetailsFragment)
                .commit()
        }
    }
}
