package com.example.newdiya_lab1

import android.graphics.Bitmap
import java.time.LocalDateTime

class Passport(
    private var person: Person,
    private var number: String,
    private var expirationDay: LocalDateTime
) : Document() {
    fun getPerson(): Person { return person}
    fun setPerson(person: Person) { this.person = person }

    fun getNumber(): String { return number }
    fun setNumber(number: String) { this.number = number }

    fun getExpirationDay(): LocalDateTime { return expirationDay }
    fun setExpirationDay(expirationDay: LocalDateTime) { this.expirationDay = expirationDay }

    override fun generateQR(): Bitmap {
        return QRGen.generateQRCode(number)
    }
}