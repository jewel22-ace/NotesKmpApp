package org.mosaif.ali.feature_note.presentation.NotesHome

import org.mosaif.ali.feature_note.domain.model.Note
import org.mosaif.ali.feature_note.domain.util.NoteOrder
import org.mosaif.ali.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)