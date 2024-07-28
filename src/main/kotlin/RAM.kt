package org.example

@OptIn(ExperimentalUnsignedTypes::class)
class RAM {

    val memory = UByteArray(4 * 1024)
    fun load()
    {

    }
    fun write(index: Int, newVal: UByte)
    {
        memory[index] = newVal

    }

    fun read()
    {

    }

}