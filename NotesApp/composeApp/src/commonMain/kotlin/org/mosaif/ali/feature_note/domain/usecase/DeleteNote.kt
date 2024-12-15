package org.mosaif.ali.feature_note.domain.usecase

import org.mosaif.ali.feature_note.domain.model.Note
import org.mosaif.ali.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}