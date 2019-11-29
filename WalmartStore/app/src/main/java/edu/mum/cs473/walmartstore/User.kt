package edu.mum.cs473.walmartstore

import java.io.Serializable

class User(val firstName: String?,
           val lastName: String?,
           val email: String?,
           val password: String?) : Serializable {

    override fun toString(): String {
        return "User(firstName=$firstName, lastName = $lastName, email=$email,password=$password)"
    }
}