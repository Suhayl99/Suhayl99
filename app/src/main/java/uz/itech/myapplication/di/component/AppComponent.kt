package uz.itech.myapplication.di.component

import dagger.Component
import uz.itech.myapplication.GalleryActivity
import uz.itech.myapplication.MainActivity
import uz.itech.myapplication.MyApp
import uz.itech.myapplication.di.model.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject (app:MyApp)
    fun inject (activity: MainActivity)
    fun inject (activity: GalleryActivity)
}