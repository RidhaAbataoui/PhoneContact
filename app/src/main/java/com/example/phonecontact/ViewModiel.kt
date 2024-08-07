package com.example.phonecontact

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Contact(val firstName: String, val lastName: String, val phoneNumber: String)
class ContactViewModel  : ViewModel() {
    private val _contacts = mutableStateListOf<Contact>()
    val contacts: List<Contact> get() = _contacts

    fun addContact(contact: Contact) {
        _contacts.add(contact)
    }

}