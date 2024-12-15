package org.mosaif.ali.feature_note.presentation.NotesHome

import org.mosaif.ali.feature_note.domain.model.Note
import org.mosaif.ali.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}