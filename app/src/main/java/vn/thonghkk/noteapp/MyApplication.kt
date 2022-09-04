package vn.thonghkk.noteapp

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import vn.thonghkk.noteapp.di.localModule
import vn.thonghkk.noteapp.di.remoteModule
import vn.thonghkk.noteapp.di.viewModelModule

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MyApplication)
            modules(viewModelModule)
            modules(localModule)
            modules(remoteModule)
        }
    }

}