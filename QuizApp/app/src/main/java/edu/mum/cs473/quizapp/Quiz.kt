package edu.mum.cs473.quizapp

open class Quiz{
    var id: Int
    var name: String
    var quizType: Int //0-radio, 1-checkbox
    var order: Int
    var score: Int

    constructor(id: Int, name: String, quizType: Int, order: Int, score: Int){
        this.id = id
        this.name = name
        this.quizType = quizType
        this.order = order
        this.score = score
    }

    fun print(){
        println();
    }
}

class QuizItem{

    var itemId: Int
    var itemText: String
    var itemAnswer: Boolean
    var quiz: Quiz

    constructor(itemId: Int, itemText: String, itemAnswer: Boolean, quiz: Quiz){
        this.itemId = itemId
        this.itemAnswer = itemAnswer
        this.itemText = itemText
        this.quiz = quiz
    }
}