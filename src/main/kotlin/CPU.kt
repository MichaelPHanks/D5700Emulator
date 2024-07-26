package org.example

class CPU {

    var p: Int = 0x0
    var t: UByte = 0u
    var a: Int = 0x0
    var m: Boolean = false



    private var registers: MutableList<UByte?> = MutableList(8) {null}


    fun changeRegister(register: Int, newVal: UByte)
    {
        println("Before modification: ${registers[register]}")
        registers[register] = newVal
        println("After modification: ${registers[register]}")

    }


}