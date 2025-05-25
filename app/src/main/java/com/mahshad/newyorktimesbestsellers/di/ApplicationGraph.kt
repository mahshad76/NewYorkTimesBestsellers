package com.mahshad.newyorktimesbestsellers.di

import com.mahshad.newyorktimesbestsellers.MyApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationGraph {
    fun inject(application: MyApplication)
}