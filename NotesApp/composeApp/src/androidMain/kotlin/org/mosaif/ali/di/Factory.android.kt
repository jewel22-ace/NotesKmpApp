package org.mosaif.ali.di

import android.app.Application
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import org.mosaif.ali.feature_note.data.datasource.NoteDatabase

actual class Factory(private val app: Application) {
    fun createRoomDatabase(): NoteDatabase {
        val dbFile = app.getDatabasePath(NoteDatabase.DATABASE_NAME)
        return Room.databaseBuilder<NoteDatabase>(
            context = app,
            name = dbFile.absolutePath,
        )
            .setDriver(BundledSQLiteDriver())
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    actual val noteDatabase: NoteDatabase
        get() = createRoomDatabase()
}

fun androidModule(app: Application) = module {
    single { Factory(app) }
    single { get<Factory>().noteDatabase }
}