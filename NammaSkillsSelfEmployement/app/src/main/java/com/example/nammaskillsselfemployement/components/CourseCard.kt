package com.example.nammaskillsselfemployment.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nammaskillsselfemployment.model.Course

@Composable
fun CourseCard(
    course: Course,
    onApplyClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = course.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = course.description
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Duration: ${course.duration}"
            )

            Text(
                text = "Location: ${course.location}"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onApplyClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Apply Now")
            }
        }
    }
}