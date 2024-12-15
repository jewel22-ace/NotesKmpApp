package org.mosaif.ali.feature_note.domain.util

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

fun getCurrentTimeAsLong(): Long {
    val currentInstant: Instant = Clock.System.now()
    return currentInstant.toEpochMilliseconds()
}