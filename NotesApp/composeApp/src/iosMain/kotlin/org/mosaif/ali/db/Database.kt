package org.mosaif.ali.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.mosaif.ali.feature_note.data.datasource.NoteDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): NoteDatabase {
    val dbFile = "${NSHomeDirectory()}/${NoteDatabase.DATABASE_NAME}"
    return Room.databaseBuilder<NoteDatabase>(
        name = dbFile,
        factory = { NoteDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}