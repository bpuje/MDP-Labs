package edu.mum.cs473.curriculumvitae.classes

import java.time.LocalDate

data class Project(var pId: Int,
                   var person: Person,
                   var projectName: String,
                   var startDate: LocalDate,
                   var endDate: LocalDate,
                   var used: String,
                   var desc: String)