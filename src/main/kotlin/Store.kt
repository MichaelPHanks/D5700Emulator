package org.example

class Store: InstructionTemplate() {
    @OptIn(ExperimentalStdlibApi::class)
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        // Split the bytes and perform operation:
        //println("Stores bytes ${secondByte.toHexString()} into register ${firstByte.toHexString()}")
        computerFacade.modifyRegister(firstByte.toInt(), secondByte)
    }
}