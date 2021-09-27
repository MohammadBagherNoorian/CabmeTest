package com.mbn.cabme.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbn.cabme.R
import com.mbn.cabme.adapter.MoviesAdapter
import com.mbn.cabme.base.ViewModelFactory
import com.mbn.cabme.viewmodel.ListViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_feedback_list.*
import javax.inject.Inject



class ComingSoonActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: ListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_list)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ListViewModel::class.java)
        viewModel?.getApiResponses()?.observe(this, Observer {
            moviesRv.adapter = it.items?.let { it1 -> MoviesAdapter(it1,this) }
            moviesRv.layoutManager = LinearLayoutManager(this)
        })
        viewModel?.getLoading()?.observe(this, Observer {
            when(it){
                true -> progress.visibility= View.VISIBLE
                false -> progress.visibility=View.INVISIBLE
            }
        })

    }
}