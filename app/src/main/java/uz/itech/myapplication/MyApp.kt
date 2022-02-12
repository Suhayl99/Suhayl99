package uz.itech.myapplication

import android.app.Application
import uz.itech.myapplication.di.component.AppComponent
import uz.itech.myapplication.di.component.DaggerAppComponent


class MyApp:Application() {
    companion object{
        lateinit var app:MyApp
    }
    lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        app=this
        appComponent=DaggerAppComponent.builder().build()
        appComponent.inject(this)
    }
}