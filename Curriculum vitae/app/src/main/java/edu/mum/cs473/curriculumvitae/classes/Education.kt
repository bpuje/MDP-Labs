package edu.mum.cs473.curriculumvitae.classes

import java.time.LocalDate

data class Education(var eduId: Int,
                     var person: Person,
                     var startDate: LocalDate,
                     var endDate: LocalDate,
                     var where: String,
                     var gpa: Double,
                     var degree: String,
                     var note: String)