package com.softhk.gameofthronesclone.ui.character

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.softhk.gameofthronesclone.R
import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import com.softhk.gameofthronesclone.ui.characterdetails.CharacterDetailsActivity
import com.softhk.gameofthronesclone.ui.characterdetails.CharacterDetailsFragment
import kotlinx.android.synthetic.main.activity_character_main.*

class CharacterMainActivity : AppCompatActivity(), CharacterFragment.OnItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_main)


    }

    override fun itemClicked(characterRemoteModel: CharacterRemoteModel) {

        if (isTable()) {
            launchCharacterDetailsTableFragment(characterId = characterRemoteModel.id)
        } else {
            launchCharacterDetailActivity(characterId = characterRemoteModel.id)
        }
    }


    private fun isTable() = characterDetailsFragment != null

    private fun launchCharacterDetailsTableFragment(characterId: String) {
        val tabletFragment = CharacterDetailsFragment.newInstance(characterId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.characterDetailsFragment, tabletFragment)
            .commit()
    }

    private fun launchCharacterDetailActivity(characterId: String) {
        val intent = Intent(this, CharacterDetailsActivity::class.java)
        intent.putExtra("CHARACTER_KEY", characterId)
        startActivity(intent)
    }


    override fun onDestroy() {
        super.onDestroy()

    }
}
