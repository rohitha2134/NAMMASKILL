package com.example.nammaskillsselfemployment.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nammaskillsselfemployment.R

@Composable
fun ProfileScreen(
    onLogoutClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        //  PROFILE IMAGE
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(20.dp))

        //  NAME
        Text(
            text = "Mohammed Suhail",
            fontSize = 24.sp,
            color = Color(0xFF2563EB)
        )

        Spacer(modifier = Modifier.height(10.dp))

        //  EMAIL
        Text(
            text = "mohammedsuhail786143@example.com",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        //  SKILL
        Text(
            text = "Interested Skill: Android App Development using GenAI",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        //  LOGOUT BUTTON
        Button(
            onClick = onLogoutClick,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Logout")
        }
    }
}