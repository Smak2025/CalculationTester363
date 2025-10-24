package ru.smak.calculationtester363.models

import kotlin.math.absoluteValue
import kotlin.random.Random

class CardModel {

    val op1: Int

    val op2: Int

    val operation: Operation = Operation.entries[Random.nextInt(4)]

    private val correctValue: Int
        get() = when(operation){
            Operation.PLUS -> op1 + op2
            Operation.MINUS -> op1 - op2
            Operation.TIMES -> op1 * op2
            Operation.DIV -> op1 / op2
        }

    init {
        when (operation){
            Operation.PLUS -> {
                op1 = Random.nextInt(-100, 101)
                op2 = Random.nextInt(
                    -100 + op1.absoluteValue,
                    100 - op1.absoluteValue
                )
            }
            Operation.MINUS -> {
                op1 = Random.nextInt(-100, 101)
                op2 = Random.nextInt(
                    -100 - op1.absoluteValue,
                    100 + op1.absoluteValue
                )
            }
            Operation.TIMES -> {
                op1 = Random.nextInt(-10, 11)
                op2 = Random.nextInt(-10, 11)
            }
            Operation.DIV -> {
                op2 = Random.nextInt(1, 11) * if (Random.nextBoolean()) 1 else -1
                val res = Random.nextInt(-10, 11)
                op1 = op2 * res
            }
        }
    }

    fun isCorrect(userValue: Int?) = userValue != null && userValue == correctValue
}