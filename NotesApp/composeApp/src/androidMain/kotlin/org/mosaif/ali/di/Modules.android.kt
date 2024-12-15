package org.mosaif.ali.di

import org.koin.core.module.Module
import org.koin.dsl.module
import org.mosaif.ali.db.getDatabaseBuilder
import org.mosaif.ali.feature_note.data.datasource.NoteDao
import org.mosaif.ali.feature_note.data.datasource.NoteDatabase

actual fun platformModule()= module {
    single<NoteDatabase> { getDatabaseBuilder(get()) }
    single<NoteDao> { getDatabaseBuilder(get()).noteDao() }
}