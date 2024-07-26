package org.example

abstract class InstructionTemplate {
    fun executeInstruction()
    {
        performOperation()
        incrementCounter()

    }

    abstract fun performOperation()
    abstract fun incrementCounter()
}