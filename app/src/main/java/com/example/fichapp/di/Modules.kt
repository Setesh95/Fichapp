package com.example.fichapp.di

import com.example.fichapp.ui.main.MainActivityViewModel
import org.koin.dsl.module

@JvmField
val appModule = module {
    single { MainActivityViewModel() }
    factory { MainActivityViewModel() }
}