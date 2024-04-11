package com.example.newdiya_lab1

class Container (private var documents: Array<Any>) {

    fun getDocuments(): Array<Any> { return documents }
    fun setDocuments(documents: Array<Any>){this.documents = documents}
    fun changeOrder(){this.documents.shuffle()}
}