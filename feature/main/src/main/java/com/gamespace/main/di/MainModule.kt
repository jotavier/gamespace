package com.gamespace.main.di

import com.gamespace.core.di.FeatureModule
import com.gamespace.core.di.LayerModule
import com.gamespace.main.presentation.di.PresentationModule

class MainModule : FeatureModule() {
    override val presentationModule: LayerModule
        get() = PresentationModule()
}