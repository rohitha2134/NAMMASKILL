package com.example.nammaskillsselfemployment.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.nammaskillsselfemployment.components.DropdownMenuBox
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ApplyScreen() {

    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    //  COURSE LIST
    val skills = listOf(

        "Artificial Intelligence",
        "Machine Learning",
        "Data Science",

        "Web Development",
        "Android Development",
        "Python Programming",

        "Java Programming",
        "C Programming",
        "C++ Programming",

        "Cyber Security",
        "Cloud Computing",
        "DevOps",

        "Database Management",
        "Operating Systems",
        "Computer Networks"
    )

    //  LOCATIONS
    val locations = listOf(
        "Bangalore",
        "Mysore",
        "Chennai"
    )

    var selectedSkill by remember {
        mutableStateOf(skills[0])
    }

    var selectedLocation by remember {
        mutableStateOf(locations[0])
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        //  TITLE
        Text(
            text = "Apply Form",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        //  NAME
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        //  PHONE
        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            label = {
                Text("Phone")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        //  EMAIL
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        //  SKILLS DROPDOWN
        DropdownMenuBox(
            items = skills,
            selectedItem = selectedSkill,
            onItemSelected = {
                selectedSkill = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        //  LOCATION DROPDOWN
        DropdownMenuBox(
            items = locations,
            selectedItem = selectedLocation,
            onItemSelected = {
                selectedLocation = it
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        //  SUBMIT BUTTON
        Button(
            onClick = {

                val data = hashMapOf(

                    "name" to name,
                    "phone" to phone,
                    "email" to email,
                    "skill" to selectedSkill,
                    "location" to selectedLocation
                )

                db.collection("applications")
                    .add(data)

                    .addOnSuccessListener {

                        Toast.makeText(
                            context,
                            "Application Submitted Successfully ✅",
                            Toast.LENGTH_LONG
                        ).show()

                        //  CLEAR FORM
                        name = ""
                        phone = ""
                        email = ""

                        selectedSkill = skills[0]
                        selectedLocation = locations[0]
                    }

                    .addOnFailureListener {

                        Toast.makeText(
                            context,
                            "Submission Failed ❌",
                            Toast.LENGTH_LONG
                        ).show()
                    }
            },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("Submit Application")
        }
    }
}