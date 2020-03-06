package com.softhk.gameofthronesclone.ui.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.softhk.gameofthronesclone.R
import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import com.softhk.gameofthronesclone.utils.CharacterBackground
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_character.view.*

class CharacterAdapter constructor(val itemClickLister:((CharacterRemoteModel)->Unit)) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var characterList = mutableListOf<CharacterRemoteModel>()
        set(value) {
            if (field.isNotEmpty())
                field.clear()

            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentCharacterModel = characterList[position]
        holder.bind(currentCharacterModel)
    }

    fun addCharactersList(charactersList: List<CharacterRemoteModel>) {
        this.characterList = charactersList.toMutableList()
    }

    inner class CharacterViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: CharacterRemoteModel) {
            with(this.itemView) {
                characterName.text = model.name
                characterTitle.text = model.title
                val xx = CharacterBackground.getOverlayColor(model.houseRemoteModel.name)
                characterMask.background = ContextCompat.getDrawable(context,xx)
                Picasso.get()
                    .load(model.img)
                    .placeholder(R.drawable.unnamed)
                    .into(characterImage)
            }

            itemView.setOnClickListener {
                itemClickLister.invoke(model)
            }
        }
    }
}