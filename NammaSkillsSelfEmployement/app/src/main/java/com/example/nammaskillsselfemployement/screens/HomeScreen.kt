package com.example.nammaskillsselfemployment.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nammaskillsselfemployment.R
import com.example.nammaskillsselfemployment.components.CourseCard
import com.example.nammaskillsselfemployment.model.Course
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(
    onApplyClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    var searchText by remember { mutableStateOf("") }

    //  BANNER INDEX
    var bannerIndex by remember { mutableStateOf(0) }

    //  BANNERS
    val banners = listOf(
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3
    )

    //  AUTO SLIDER
    LaunchedEffect(Unit) {

        while (true) {

            delay(2500)

            bannerIndex = (bannerIndex + 1) % banners.size
        }
    }

    // COURSES
    val sampleCourses = listOf(

        Course(
            "Artificial Intelligence",
            "AI fundamentals + ML basics",
            "6 Months",
            "Bangalore"
        ),

        Course(
            "Machine Learning",
            "Supervised + Unsupervised learning",
            "6 Months",
            "Mysore"
        ),

        Course(
            "Data Science",
            "Data analysis + visualization",
            "6 Months",
            "Chennai"
        ),

        Course(
            "Web Development",
            "Frontend + Backend development",
            "4 Months",
            "Bangalore"
        ),

        Course(
            "Android Development",
            "Kotlin + Jetpack Compose apps",
            "5 Months",
            "Mysore"
        ),

        Course(
            "Python Programming",
            "Core Python + projects",
            "3 Months",
            "Chennai"
        ),

        Course(
            "Java Programming",
            "OOP + backend development",
            "4 Months",
            "Bangalore"
        ),

        Course(
            "Cyber Security",
            "Ethical hacking + network security",
            "5 Months",
            "Mysore"
        )
    )

    //  SEARCH
    val filteredCourses = sampleCourses.filter {

        it.title.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        //  TITLE
        Text(
            text = "Namma Skills",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2563EB)
        )

        Spacer(modifier = Modifier.height(10.dp))

        //  PROFILE BUTTON
        Button(
            onClick = onProfileClick,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Open Profile")
        }

        Spacer(modifier = Modifier.height(12.dp))

        //  BANNER
        Image(
            painter = painterResource(id = banners[bannerIndex]),
            contentDescription = null,
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        //  SEARCH BAR
        OutlinedTextField(
            value = searchText,

            onValueChange = {
                searchText = it
            },

            label = {
                Text("Search Skills")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = MaterialTheme.shapes.large
        )

        Spacer(modifier = Modifier.height(12.dp))

        //  COURSE LIST
        LazyColumn {

            items(filteredCourses) { course ->

                CourseCard(
                    course = course,
                    onApplyClick = onApplyClick
                )
            }
        }
    }
}