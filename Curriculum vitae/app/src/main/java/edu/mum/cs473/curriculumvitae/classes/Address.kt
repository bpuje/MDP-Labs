package edu.mum.cs473.curriculumvitae.classes

data class Address(var addId: Int,
                   var person: Person,
                   var city: String,
                   var state: String,
                   var country: String,
                   var zipCode: Int,
                   var address1: String,
                   var address2: String)