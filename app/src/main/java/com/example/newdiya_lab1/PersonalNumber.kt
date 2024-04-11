package com.example.newdiya_lab1

import android.graphics.Bitmap
import java.time.LocalDateTime

class PersonalNumber (
    private var person: Person,
    private var personalNumber: String,
    private var dateOfIssue: LocalDateTime) : Document() {

    fun getPerson(): Person { return person}
    fun setPerson(person: Person) { this.person = person }

    fun getPersonalNumber(): String { return personalNumber }
    fun setPersonalNumber(personalNumber: String) { this.personalNumber = personalNumber }

    fun getDateOfIssue(): LocalDateTime { return dateOfIssue }
    fun setDateOfIssue(dateOfIssue: LocalDateTime) { this.dateOfIssue = dateOfIssue }

    override fun generateQR(): Bitmap {
        return QRGen.generateQRCode(personalNumber)
    }
}