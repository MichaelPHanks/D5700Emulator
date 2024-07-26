package org.example
@OptIn(ExperimentalUnsignedTypes::class)

class ROM {


    val memory = UByteArray(4 * 1024)
    // This method is when we first load memory into ROM for execution
    fun load(memory: UByteArray)
    {
        var position = 0
        for (byte in memory) {
            this.memory[position] = byte
            position += 1
        }

    }

    fun read(index: Int): UByte
    {
        return this.memory[index]

    }
}