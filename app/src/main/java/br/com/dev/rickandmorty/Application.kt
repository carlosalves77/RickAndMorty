package br.com.dev.rickandmorty

import android.app.Application
import br.com.dev.rickandmorty.di.LocalModule
import br.com.dev.rickandmorty.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            modules(NetworkModule)
        }

    }
}