package org.example

class Jump: InstructionTemplate() {
    @OptIn(ExperimentalStdlibApi::class)
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        var yeah: Int = 1
        println("We got to the jump!")
        println("Setting the p value to ${((firstByte.toInt() and 0xF).toHexString() + secondByte.toHexString()).toUByte()}")
        // cpu.p =
        yeah = ((firstByte.toInt() and 0xF).toHexString() + secondByte.toHexString()).toUByte().toInt()
        println(yeah)
    }

    override fun incrementCounter() {
    }
}