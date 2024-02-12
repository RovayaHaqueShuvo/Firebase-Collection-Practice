package com.own_world.firebase_collection_practice

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.own_world.firebase_collection_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
 private lateinit var binding: ActivityMainBinding
    lateinit var student: Student
    var db: FirebaseFirestore? = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        student = Student()
        binding.save.setOnClickListener {
            student.name =binding.name.editText?.text?.toString()
            student.rollNo =binding.Roll.editText?.text?.toString()
            student.marks =binding.Point.editText?.text?.toString()
            db?.collection("Student")?.document(binding.Roll.editText?.text.toString())?.set(student)
                ?.addOnSuccessListener {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                }
                ?.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
        }
    }
}