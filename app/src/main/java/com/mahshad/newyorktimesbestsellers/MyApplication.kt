package com.mahshad.newyorktimesbestsellers

import android.app.Application
import com.mahshad.newyorktimesbestsellers.di.ApplicationGraph
import com.mahshad.newyorktimesbestsellers.di.DaggerApplicationGraph


class MyApplication : Application() {
    lateinit var appComponent: ApplicationGraph

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationGraph.factory().create(applicationContext)
    }
}
