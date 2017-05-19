package com.begovac.juraj.viewmodelnotworking

import android.arch.lifecycle.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment.*

/**
 * Created by juraj on 19/05/2017.
 */

class Fragment1 : LifecycleFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title.text = "Fragment1"
        val viewModel = ViewModelProviders.of(this).get(ViewModel1::class.java)
        viewModel.state().observe(this, Observer<String> {
            tv.text = it
        })
        btn.setOnClickListener { viewModel.setState(et.text.toString()) }
        next.setOnClickListener { fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, Fragment2()).commit() }
    }

}

class ViewModel1 : ViewModel() {
    private val state = MutableLiveData<String>()

    fun state(): LiveData<String> = state
    fun setState(newState: String) {
        state.value = newState
    }
}
