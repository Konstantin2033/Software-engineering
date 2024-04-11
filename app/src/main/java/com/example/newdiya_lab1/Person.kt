package com.example.newdiya_lab1

import java.time.LocalDateTime

open class Person (private var name: String, private var surname: String, private var fathersName: String,
                       private var birthDay: LocalDateTime, private var photo: Int){

    fun getName(): String { return name }
    fun setName(name: String) { this.name = name }

    fun getSurname(): String { return surname }
    fun setSurname(surname: String) { this.surname = surname }

    fun getFathersName(): String { return fathersName }
    fun setFathersName(fathersName: String) { this.fathersName = fathersName }

    fun getBirthDay(): LocalDateTime { return birthDay }
    fun setBirthDay(birthDay: LocalDateTime) { this.birthDay = birthDay }

    fun getPhoto(): Int { return photo }
    fun setPhoto(photo:Int) { this.photo = photo }
}