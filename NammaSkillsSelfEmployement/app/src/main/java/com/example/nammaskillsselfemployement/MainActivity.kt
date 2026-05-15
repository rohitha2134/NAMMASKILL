package com.example.nammaskillsselfemployment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.nammaskillsselfemployment.screens.*
import com.example.nammaskillsselfemployment.ui.theme.NammaSkillsSelfEmploymentTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            NammaSkillsSelfEmploymentTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {

                    // SPLASH
                    composable("splash") {
                        SplashScreen(
                            navController = navController
                        )
                    }

                    // LOGIN
                    composable("login") {
                        LoginScreen(
                            onLoginClick = {
                                navController.navigate("home")
                            },

                            onSignUpClick = {
                                navController.navigate("signup")
                            }
                        )
                    }

                    // SIGNUP
                    composable("signup") {
                        SignUpScreen(
                            onSignUpSuccess = {
                                navController.navigate("home")
                            }
                        )
                    }

                    // HOME
                    composable("home") {

                        HomeScreen(

                            onApplyClick = {
                                navController.navigate("apply")
                            },

                            onProfileClick = {
                                navController.navigate("profile")
                            }
                        )
                    }

                    // APPLY
                    composable("apply") {
                        ApplyScreen()
                    }

                    // 👤 PROFILE
                    composable("profile") {

                        ProfileScreen(

                            onLogoutClick = {

                                navController.navigate("login")
                            }
                        )
                    }

                    //  SUCCESS
                    composable("success") {

                        SuccessScreen(

                            onBack = {

                                navController.navigate("home") {

                                    popUpTo("home") {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}