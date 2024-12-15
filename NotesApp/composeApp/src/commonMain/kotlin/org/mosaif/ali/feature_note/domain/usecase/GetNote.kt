package org.mosaif.ali.feature_note.domain.usecase

import org.mosaif.ali.feature_note.domain.model.Note
import org.mosaif.ali.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}