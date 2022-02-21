package com.gamespace.core.extensions

import com.facebook.shimmer.ShimmerFrameLayout

fun ShimmerFrameLayout.disable() {
    hideShimmer()
    hide()
}

fun ShimmerFrameLayout.enable() {
    startShimmer()
    show()
}