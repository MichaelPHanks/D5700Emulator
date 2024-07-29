package org.example

class Sub: InstructionTemplate() {
    override fun performOperation(firstByte: UByte, secondByte: UByte, computerFacade: Computer) {
        val firstValue =  computerFacade.getRegisterValue(secondByte.toInt() shr 4)?.toInt()
        val secondValue =  computerFacade.getRegisterValue(secondByte.toInt() and 0xF)?.toInt()

        if (firstValue != null && secondValue != null)
        {
            println("Putting ${firstValue + secondValue} into register ${firstByte.toInt() and 0xF}")
            computerFacade.modifyRegister(firstByte.toInt() and 0xF, (firstValue - secondValue).toUByte())
        }
    }


}