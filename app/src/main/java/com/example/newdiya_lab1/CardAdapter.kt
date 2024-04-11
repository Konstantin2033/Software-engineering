package com.example.newdiya_lab1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class CardAdapter(
    private val container: Container,
    private val context: Context,
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layoutRes = R.layout.card
        val view = inflater.inflate(layoutRes,parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardAdapter.CardViewHolder,
                                  @SuppressLint("RecyclerView") position: Int) {
        val document = container.getDocuments()[position]
        when (document) {
            is Passport -> bindPassport(holder, document)
            is DriverLicense -> bindDriverLicense(holder, document)
            is PersonalNumber -> bindPersonalNumber(holder, document)
        }
    }

    private fun bindPassport(holder: CardViewHolder, passport: Passport) {
        holder.cardBase.removeView(holder.cardDriver)
        holder.cardBase.removeView(holder.cardPersonalNumber)

        holder.passportName.text = "${passport.getPerson().getSurname()} ${passport.getPerson().getName()} ${passport.getPerson().getFathersName()}"
        holder.passportNumber.text = passport.getNumber()
        holder.passportExpirationDate.text = passport.getExpirationDay().format(DateTimeFormatter.ofPattern("dd.MM.yy"))
        holder.passportBirthday.text = passport.getPerson().getBirthDay().format(DateTimeFormatter.ofPattern("dd.MM.yy"))
        holder.passportPhoto.setImageResource(passport.getPerson().getPhoto())
    }

    private fun bindDriverLicense(holder: CardViewHolder, driverLicense: DriverLicense) {
        holder.cardBase.removeView(holder.cardPassport)
        holder.cardBase.removeView(holder.cardPersonalNumber)

        holder.driverName.text = "${driverLicense.getPerson().getSurname()} ${driverLicense.getPerson().getName()} ${driverLicense.getPerson().getFathersName()}"
        holder.driverPhoto.setImageResource(driverLicense.getPerson().getPhoto())
        holder.driverBirthday.text = driverLicense.getPerson().getBirthDay().format(DateTimeFormatter.ofPattern("dd.MM.yy"))
        holder.driverCategory.text = driverLicense.getCategory()
        holder.driveIssueDate.text = driverLicense.getDateOfIssue().format(DateTimeFormatter.ofPattern("dd.MM.yy"))
    }

    private fun bindPersonalNumber(holder: CardViewHolder, personalNumber: PersonalNumber) {
        holder.cardBase.removeView(holder.cardPassport)
        holder.cardBase.removeView(holder.cardDriver)

        holder.personalNumber.text = personalNumber.getPersonalNumber()
        holder.personalNumberName.text = "${personalNumber.getPerson().getSurname()} ${personalNumber.getPerson().getName()} ${personalNumber.getPerson().getFathersName()}"
        holder.personalNumberBirthday.text = personalNumber.getPerson().getBirthDay().format(DateTimeFormatter.ofPattern("dd.MM.yy"))
    }

    override fun getItemCount(): Int {
        return container.getDocuments().size
    }

    class CardViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {
        val passportName: TextView
        val passportBirthday: TextView
        val passportPhoto: ImageView
        val passportExpirationDate: TextView
        val passportNumber: TextView

        val driverName: TextView
        val driverBirthday: TextView
        val driverPhoto: ImageView
        val driveIssueDate: TextView
        val driverCategory: TextView

        val personalNumberName: TextView
        val personalNumberBirthday: TextView
        val personalNumber: TextView

        val cardPassport: ConstraintLayout
        val cardDriver: ConstraintLayout
        val cardPersonalNumber: ConstraintLayout
        val cardBase: ConstraintLayout
        init {
            cardBase = cardView.findViewById(R.id.base_Card)
            cardPassport = cardView.findViewById(R.id.passportBase_Card)
            cardDriver = cardView.findViewById(R.id.driverBase_Card)
            cardPersonalNumber = cardView.findViewById(R.id.personalNumberBase_Card)

            passportName = cardView.findViewById(R.id.namePassport_Card)
            passportBirthday = cardView.findViewById(R.id.birthdayPassport_Card)
            passportPhoto= cardView.findViewById(R.id.personalPhotoPassport_Card)
            passportExpirationDate = cardView.findViewById(R.id.expirationDatePassport_Card)
            passportNumber = cardView.findViewById(R.id.numberPassport_Card)

            driverName = cardView.findViewById(R.id.nameDriver_Card)
            driverBirthday = cardView.findViewById(R.id.birthdayDriver_Card)
            driverPhoto= cardView.findViewById(R.id.personalPhotoDriver_Card)
            driveIssueDate = cardView.findViewById(R.id.issueDateDriver_Card)
            driverCategory = cardView.findViewById(R.id.categoryDriver_Card)

            personalNumberName = cardView.findViewById(R.id.namePersonalNumber_Card)
            personalNumberBirthday = cardView.findViewById(R.id.birthdayPersonalNumber_Card)
            personalNumber = cardView.findViewById(R.id.personalNumber_Card)
        }
    }
}