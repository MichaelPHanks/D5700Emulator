package org.example

class Store: InstructionTemplate() {
    @OptIn(ExperimentalStdlibApi::class)
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        println("WE GOT HERE!!!")
        // Split the bytes:
        println(firstByte)
        println(secondByte)

       println("Stores bytes ${secondByte.toHexString()} into register ${firstByte.toHexString()}")

        println(firstByte.toInt())
        computerFacade.modifyRegister(firstByte.toInt(), secondByte)
    }

    override fun incrementCounter() {
    }
}