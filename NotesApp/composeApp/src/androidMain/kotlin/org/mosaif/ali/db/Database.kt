package org.mosaif.ali.db

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import org.mosaif.ali.feature_note.data.datasource.NoteDatabase

fun getDatabaseBuilder(ctx: Context): NoteDatabase {
    val dbFile = ctx.getDatabasePath(NoteDatabase.DATABASE_NAME)
    return Room.databaseBuilder<NoteDatabase>(ctx, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}