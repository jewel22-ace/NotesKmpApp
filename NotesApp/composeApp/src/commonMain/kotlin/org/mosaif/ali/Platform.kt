package org.mosaif.ali

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform