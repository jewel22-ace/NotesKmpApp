package org.mosaif.ali.feature_note.presentation.AddEditNoteScreen

data class NoteTextFieldState (
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)