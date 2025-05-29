package com.mahshad.newyorktimesbestsellers.di

import android.content.Context
import com.mahshad.newyorktimesbestsellers.MyApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationGraph {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationGraph
    }

    fun inject(application: MyApplication)
}