package org.example

abstract class InstructionTemplate {
    fun executeInstruction(firstByte: UByte, secondByte: UByte)
    {
        performOperation(firstByte, secondByte)
        incrementCounter()

    }

    abstract fun performOperation(firstByte: UByte, secondByte: UByte)
    abstract fun incrementCounter()
}