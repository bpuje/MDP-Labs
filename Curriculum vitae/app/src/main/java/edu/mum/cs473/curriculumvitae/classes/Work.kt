package edu.mum.cs473.curriculumvitae.classes

import java.time.LocalDate

data class Work(var workId: Int,
                var person: Person,
                var companyName: String,
                var startDate: LocalDate,
                var endDate: LocalDate,
                var position: String,
                var desc: String)