package com.own_world.firebase_collection_practice

class Student{
    var name:String? = null
    var rollNo:String? = null
    var marks:String? = null
    constructor()
    constructor(name:String?,rollNo:String?,marks:String?){
        this.name = name
        this.rollNo = rollNo
        this.marks = marks
    }
    constructor(name:String?,rollNo:String?){
        this.rollNo = rollNo
        this.marks = marks
    }

}