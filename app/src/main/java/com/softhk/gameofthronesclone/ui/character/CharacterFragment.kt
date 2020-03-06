package com.softhk.gameofthronesclone.ui.character

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softhk.gameofthronesclone.R
import com.softhk.gameofthronesclone.data.models.CharacterRemoteModel
import kotlinx.android.synthetic.main.fragment_character.*

class CharacterFragment : Fragment(), CharacterContract.View {

    private val presenter: CharacterContract.Presenter = CharacterPresenter(this)

    private lateinit var itemClickListener:OnItemClickListener

    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter{
            model -> itemClickListener.itemClicked(model)
        }
    }

    private val recyclerView: RecyclerView by lazy {
        var rv = rv
        rv.layoutManager = LinearLayoutManager(activity)
        rv
    }

    private val buttonErrorRetry:Button by lazy {
        btnErrorRetry
    }

    private val progress: ProgressBar by lazy { progressBar }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnItemClickListener)
            itemClickListener = context
        else
            throw IllegalArgumentException("Attached activity do not implement CharacterFragment.OnItemClickListener")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        presenter.getCharacters()
        buttonErrorRetry.setOnClickListener {
            presenter.getCharacters()
        }
    }

    override fun setCharacterList(charactersList: MutableList<CharacterRemoteModel>) {
        adapter.addCharactersList(charactersList)
    }

    override fun showProgressBar() {
        progress.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE
        errorRetry.visibility=View.INVISIBLE
    }

    override fun hideProgressBar() {
        progress.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
        errorRetry.visibility=View.INVISIBLE
    }

    override fun showErrorRetry() {
        progress.visibility = View.INVISIBLE
        recyclerView.visibility = View.INVISIBLE
        errorRetry.visibility = View.VISIBLE
    }

    interface OnItemClickListener{
        fun itemClicked(characterRemoteModel: CharacterRemoteModel)
    }

    override fun onDetach() {
        super.onDetach()
        presenter.detach()
    }
}