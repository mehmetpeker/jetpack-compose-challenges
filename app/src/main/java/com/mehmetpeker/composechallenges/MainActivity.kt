package com.mehmetpeker.composechallenges

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mehmetpeker.composechallenges.ui.screens.animation.SampleList
import com.mehmetpeker.composechallenges.ui.screens.animation.TurnOnTheLight
import com.mehmetpeker.composechallenges.ui.theme.ComposeChallengesTheme
import com.mehmetpeker.composechallenges.utils.Constants


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChallengesTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Constants.SCREEN_SAMPLE_LIST) {
                    composable(Constants.SCREEN_TURN_ON_THE_LIGHT) {
                        TurnOnTheLight(navController)
                    }
                    composable(Constants.SCREEN_SAMPLE_LIST) {
                        SampleList(navController)
                    }
                }
            }
        }
    }
}

