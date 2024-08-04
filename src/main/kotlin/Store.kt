package org.example

class Store: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        // Split the bytes and perform operation:
        computerFacade.modifyRegister(firstByte.toInt(), secondByte)
    }
}