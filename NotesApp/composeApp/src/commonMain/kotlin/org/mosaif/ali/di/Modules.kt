package org.mosaif.ali.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import org.mosaif.ali.feature_note.domain.repository.NoteRepository
import org.mosaif.ali.feature_note.data.repository.NoteRepositoryImpl
import org.mosaif.ali.feature_note.domain.usecase.AddNote
import org.mosaif.ali.feature_note.domain.usecase.DeleteNote
import org.mosaif.ali.feature_note.domain.usecase.GetNote
import org.mosaif.ali.feature_note.domain.usecase.GetNotes
import org.mosaif.ali.feature_note.domain.usecase.NoteUseCases
import org.koin.core.module.dsl.viewModelOf
import org.mosaif.ali.feature_note.presentation.AddEditNoteScreen.AddEditNoteViewModel
import org.mosaif.ali.feature_note.presentation.NotesHome.NotesViewModel

expect fun platformDatabaseModule(): Module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            platformDatabaseModule(),
            provideRepositoryModule,
            provideUseCaseModule,
            provideViewModelModule,
        )
    }

val provideRepositoryModule = module {
    singleOf(::NoteRepositoryImpl).bind(NoteRepository::class)
}

val provideUseCaseModule = module {
//    fun provideUseCaseModuleFun(repository: NoteRepository)
//    : NoteUseCases {
//        return NoteUseCases(
//            addNote = AddNote(repository),
//            deleteNote = DeleteNote(repository),
//            getNote = GetNote(repository),
//            getNotes = GetNotes(repository),
//        )
//    }
//    single {
//        provideUseCaseModuleFun(get())
//    }
    singleOf(::AddNote)
    singleOf(::DeleteNote)
    singleOf(::GetNote)
    singleOf(::GetNotes)
    singleOf(::NoteUseCases)
}

val provideViewModelModule = module {
    viewModelOf(::AddEditNoteViewModel)
    viewModelOf(::NotesViewModel)
}
