package org.mosaif.ali.feature_note.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import org.mosaif.ali.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "notes.db"
    }
}

