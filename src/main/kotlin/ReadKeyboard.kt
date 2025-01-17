package org.example

class ReadKeyboard: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        // Pause the program.
        computerFacade.pause()
        println("Waiting for keyboard input...")
        var input = readLine()

        if (input.isNullOrEmpty())
        {
            input = 0u.toString()
        }
        val hexString = input.take(2)
        val hexValue = hexString.toIntOrNull(16)
        if (hexValue != null && hexValue in 0..255) {
            input = hexValue.toUByte().toString()
            computerFacade.modifyRegister(firstByte.toInt() and 0xF, input.toInt().toUByte())
        }
        else {
            println("Invalid input. Please enter a valid hexadecimal digit.")
        }




        // Create new runnable instance
        computerFacade.startCPU()

    }


}