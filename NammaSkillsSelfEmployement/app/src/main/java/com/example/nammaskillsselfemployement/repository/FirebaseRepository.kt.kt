package com.example.nammaskillsselfemployment.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.example.nammaskillsselfemployment.model.Course

class FirebaseRepository {

    private val db = FirebaseFirestore.getInstance()

    fun addCourse(course: Course, onResult: (Boolean) -> Unit = {}) {
        db.collection("courses")
            .add(course)
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }

    fun getCourses(onResult: (List<Course>) -> Unit) {
        db.collection("courses")
            .get()
            .addOnSuccessListener { result ->
                val list = result.documents.mapNotNull {
                    it.toObject(Course::class.java)
                }
                onResult(list)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }
}