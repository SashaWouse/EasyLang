package com.alexaded.easylang.navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object ProgressScreen: Screen("progress_screen")
    object ScanScreen: Screen("scan_screen")
}