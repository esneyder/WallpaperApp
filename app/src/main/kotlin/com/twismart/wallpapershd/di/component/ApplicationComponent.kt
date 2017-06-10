package com.twismart.wallpapershd.di.component

import android.app.Application
import android.content.Context

import com.twismart.wallpapershd.WallpaperApplication
import com.twismart.wallpapershd.data.DataManager
import com.twismart.wallpapershd.data.remote.WallpaperService
import com.twismart.wallpapershd.di.module.ApplicationModule
import javax.inject.Singleton
import dagger.Component
import retrofit2.Retrofit

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(app: WallpaperApplication)

    fun context(): Context

    fun application(): Application

    fun retrofit(): Retrofit

    fun wallpaperService(): WallpaperService

    fun dataManager(): DataManager
}