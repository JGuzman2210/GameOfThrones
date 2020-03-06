package com.softhk.gameofthronesclone.ui.characterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.softhk.gameofthronesclone.R
import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import com.softhk.gameofthronesclone.utils.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_body_character_details.*
import kotlinx.android.synthetic.main.item_header_character_details.*

class CharacterDetailsFragment : Fragment(), CharacterDetailsContract.View {

    private val presenter = CharacterDetailsPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_character_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(CharacterKeys.CHARACTER_DETAILS_FRAGMENT)?.let {
            presenter.getCharacterById(it)
        }

    }

    companion object {
        fun newInstance(data: String): CharacterDetailsFragment {
            val characterDetailsFragment = CharacterDetailsFragment()
            var bundle = Bundle()
            bundle.putString(CharacterKeys.CHARACTER_DETAILS_FRAGMENT, data)
            characterDetailsFragment.arguments = bundle
            return characterDetailsFragment
        }
    }

    override fun setCharacterDetails(model: CharacterRemoteModel) {


        view?.let {
            model?.let {
                with(model) {
                    Picasso.get().load(img).placeholder(R.drawable.unnamed)
                        .into(characterDetailsImg)
                    characterDetailsName.text = name
                    characterDetailsTitle.text = title
                    characterDetailsBorn.text = born
                    characterDetailsActor.text = actor
                    characterDetailsParents.text = validateParents(father, mother)
                    characterDetailsQuote.text = quote
                    characterDetailsSpouse.text = spouse

                    with(houseRemoteModel){
                        val baseColor = CharacterBackground.getBaseColor(name)
                        floatingActionButton.setImageDrawable(ContextCompat.getDrawable(context!!,CharacterBackground.getIcon(houseId = name)))
                        floatingActionButton.backgroundTintList = ContextCompat.getColorStateList(context!!,baseColor)
                        floatingActionButton.setOnClickListener{
                            var snackBar = Snackbar.make(it,name,Snackbar.LENGTH_SHORT)
                            snackBar.addBackgroundColor(ContextCompat.getColor(context!!,baseColor))
                            snackBar.show()

                        }
                    }

                }
            }
        }
    }

    private fun validateParents(father: String, mother: String): String {
        return if (father.isNullOrEmpty()) {
            mother
        } else if (mother.isNullOrEmpty()) {
            father
        } else {
            "$father - $mother"
        }
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detach()
    }
}