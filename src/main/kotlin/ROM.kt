package org.example

@OptIn(ExperimentalUnsignedTypes::class)
class ROM {
    private val memory = UByteArray(4 * 1024)
    // This method is when we first load memory into ROM for execution
    fun load(memory: UByteArray)
    {
        var position = 0
        for (byte in memory) {
            this.memory[position] = byte
            position += 1
        }

    }

    fun write(index: Int, newVal: UByte)
    {
        if (index >= memory.size)
        {
            throw IllegalArgumentException("Out of bounds memory write")
        }
        memory[index] = newVal

    }

    fun read(index: Int): UByte
    {
        if (index >= memory.size)
        {
            throw IllegalArgumentException("Out of bounds memory write")
        }
        return this.memory[index]

    }
}