package org.example

abstract class InstructionTemplate {
    fun executeInstruction(firstByte: UByte, secondByte: UByte, computerFacade: Computer)
    {
        performOperation(firstByte, secondByte, computerFacade)
        incrementCounter()

    }

    abstract fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer)
    abstract fun incrementCounter()
}