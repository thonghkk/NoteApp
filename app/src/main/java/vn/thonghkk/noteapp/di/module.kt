package vn.thonghkk.noteapp.di

import org.koin.dsl.module
import vn.thonghkk.noteapp.local.db.AppDatabase
import vn.thonghkk.noteapp.local.repositories.TaskRepository
import vn.thonghkk.noteapp.local.repositories.TaskRepositoryImpl
import vn.thonghkk.noteapp.ui.home.HomeViewModel

val viewModelModule = module {
    single { HomeViewModel(get()) }
}

val localModule = module {
    single { AppDatabase(get()) }
    single { AppDatabase(get()).taskDao() }

    //repository
    single<TaskRepository> { TaskRepositoryImpl(get()) }
}

val remoteModule = module {

}