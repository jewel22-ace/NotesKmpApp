package org.mosaif.ali

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.mosaif.ali.feature_note.presentation.AddEditNoteScreen.AddEditNoteScreen
import org.mosaif.ali.feature_note.presentation.NotesHome.NotesHomeScreen
import org.mosaif.ali.util.Screens

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screens.NotesHomeScreen.name
            ){
                composable(
                    route = Screens.NotesHomeScreen.name
                ){
                    NotesHomeScreen(navController)
                }
                composable(
                    route = Screens.AddEditNoteScreen.name +
                            "?noteId={noteId}&noteColor={noteColor}",
                    arguments = listOf(
                        navArgument(
                            name = "noteId"
                        ) {
                            type = NavType.IntType
                            defaultValue = -1
                        },
                        navArgument(
                            name = "noteColor"
                        ) {
                            type = NavType.IntType
                            defaultValue = -1
                        },
                    )
                ){
                    val color = it.arguments?.getInt("noteColor") ?: -1
                    AddEditNoteScreen(
                        navController = navController,
                        noteColor = color
                    )
                }
            }
        }
    }
}