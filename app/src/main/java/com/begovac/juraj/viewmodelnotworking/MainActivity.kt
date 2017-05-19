package com.begovac.juraj.viewmodelnotworking

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle

/**
 * Created by juraj on 19/05/2017.
 */
class MainActivity : LifecycleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().replace(R.id.container, Fragment1()).commit()
    }
}
