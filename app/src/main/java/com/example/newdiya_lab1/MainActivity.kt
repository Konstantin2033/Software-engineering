package com.example.newdiya_lab1

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val purchaseButtonsViewPager = findViewById<ViewPager2>(R.id.cards_VP_Main)
        val qrButton: ImageButton = findViewById(R.id.qrButton)


        val person = Person("Василь","Степаненко", "Петрович", LocalDateTime.now(),R.drawable.face_one)
        val documents: Array<Any> = arrayOf(
            Passport(person, "12461254", LocalDateTime.now()),
            DriverLicense(person, "B", LocalDateTime.now(), LocalDateTime.now()),
            PersonalNumber(person,"125928172", LocalDateTime.now())
        )
        val container = Container(documents)

        qrButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val dialog = Dialog(this@MainActivity)
                dialog.setContentView(R.layout.dialog_layout)
                val imageView: ImageView = dialog.findViewById(R.id.qrImage)
                val document = container.getDocuments().get(purchaseButtonsViewPager.currentItem)
                when (document) {
                    is Passport -> imageView.setImageBitmap(document.generateQR())
                    is DriverLicense -> imageView.setImageBitmap(document.generateQR())
                    is PersonalNumber -> imageView.setImageBitmap(document.generateQR())
                }
                dialog.show()
            }
        })

        purchaseButtonsViewPager.setAdapter(CardAdapter(container,this))
        purchaseButtonsViewPager.setClipToPadding(false)
        purchaseButtonsViewPager.setClipChildren(false)
        purchaseButtonsViewPager.getChildAt(0)
            .setOverScrollMode(View.OVER_SCROLL_NEVER)
    }
}