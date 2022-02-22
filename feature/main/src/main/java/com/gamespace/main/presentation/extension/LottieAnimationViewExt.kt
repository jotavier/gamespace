package com.gamespace.main.presentation.extension

import android.animation.Animator
import com.airbnb.lottie.LottieAnimationView

private const val ANIMATION_END_DELAY = 500L

internal inline fun LottieAnimationView.onAnimationEnd(crossinline block: () -> Unit) =
    this.addAnimatorListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(p0: Animator?) = Unit
        override fun onAnimationCancel(p0: Animator?) = Unit
        override fun onAnimationRepeat(p0: Animator?) = Unit

        override fun onAnimationEnd(p0: Animator?) {
            postDelayed({ block() }, ANIMATION_END_DELAY)
        }
    })
