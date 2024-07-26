package org.example

import java.io.File


class Computer {
    val rom = ROM()
    val cpu = CPU()

    val instructions: Map<Int, InstructionTemplate> = mapOf(
        0 to Store(),
        1 to Add(),
        2 to Sub(),
        3 to Read(),
        4 to Write(),
        5 to Jump(),
        6 to ReadKeyboard(),
        7 to SwitchMemory(),
        8 to SkipEqual(),
        9 to SkipNotEqual(),
        10 to SetA(),
        11 to SetT(),
        12 to ReadT(),
        13 to ConvertToBase10(),
        14 to ConvertByteToAscii(),
        15 to Draw(),

    )


    @OptIn(ExperimentalUnsignedTypes::class)
    fun start()
    {
        println("Type in the path to the rom file:")
        val inputString: String = readln()
        //rom.load()
        val file = File(inputString)

        file.forEachLine {

            println(it.toByteArray().get(1))
            rom.load(it.toByteArray())
        }

        var yeah = 0
        for (item in rom.memory)
        {
            println(item.toInt() shr 4)
            println(item.toInt() and 0xF)
            yeah ++
            if (yeah == 10)
            {
                break
            }
        }

        startCPU()



    }

    fun startCPU()
    {
        val cpu = Runnable {
            try {

            }
            catch (e: Exception)
            {
                println("There was an exception! : $e")
            }
        }
    }


}