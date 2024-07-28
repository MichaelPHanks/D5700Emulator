package org.example

class SetT: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        println("Setting t to: ${(firstByte.toInt() and 0xF) + secondByte.toInt()}")
        // println("BRUH: ${(firstByte.toInt() and 0xF) }; ${secondByte.toInt()}")

        computerFacade.setT((firstByte.toInt() and 0xF) + secondByte.toInt())
    }
}