package com.example.newdiya_lab1

import android.graphics.Bitmap
import java.time.LocalDateTime

class DriverLicense(
    private var person: Person,
    private var category: String,
    private var dateOfIssue: LocalDateTime,
    private var expirationDate: LocalDateTime)  : Document() {

    fun getPerson(): Person { return person}
    fun setPerson(person: Person) { this.person = person }

    fun getCategory(): String { return category }
    fun setCategory(category: String) { this.category = category }

    fun getDateOfIssue(): LocalDateTime { return dateOfIssue }
    fun setDateOfIssue(dateOfIssue: LocalDateTime) { this.dateOfIssue = dateOfIssue }

    fun getExpirationDate(): LocalDateTime { return expirationDate }
    fun setExpirationDate(expirationDate: LocalDateTime) { this.expirationDate = expirationDate }

    override fun generateQR(): Bitmap {
        return QRGen.generateQRCode(category)
    }
}