package org.mosaif.ali.di

import org.koin.dsl.module
import org.mosaif.ali.feature_note.data.datasource.NoteDatabase

expect class Factory {
//    fun createRoomDatabase(): NoteDatabase
    val noteDatabase : NoteDatabase
}
