package org.mosaif.ali.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.mosaif.ali.theme.BabyBlue
import org.mosaif.ali.theme.LightGreen
import org.mosaif.ali.theme.RedOrange
import org.mosaif.ali.theme.RedPink
import org.mosaif.ali.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)