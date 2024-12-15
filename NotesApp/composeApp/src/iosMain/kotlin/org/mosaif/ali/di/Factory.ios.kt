package org.mosaif.ali.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import org.mosaif.ali.feature_note.data.datasource.NoteDatabase
import platform.Foundation.NSHomeDirectory

actual class Factory {
    fun createRoomDatabase(): NoteDatabase {
        val dbFile = NSHomeDirectory() + "/" + NoteDatabase.DATABASE_NAME
        return Room.databaseBuilder<NoteDatabase>(
            name = dbFile,
            factory = { NoteDatabase::class.instantiateImpl() } // This too will show error
        )
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setDriver(BundledSQLiteDriver()) // Very important
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    actual val noteDatabase: NoteDatabase
        get() = createRoomDatabase()
}

val iosModule = module {
    single { Factory() }
    single { get<Factory>().noteDatabase }
}
