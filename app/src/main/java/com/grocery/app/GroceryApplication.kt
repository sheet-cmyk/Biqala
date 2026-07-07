package com.grocery.app

import android.app.Application
import android.content.Context
import com.grocery.app.utils.LocaleHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GroceryApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.onAttach(base))
    }
}
