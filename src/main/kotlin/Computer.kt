package org.example

import java.io.File
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit


class Computer {
    val executor = Executors.newSingleThreadScheduledExecutor()
    var cpuFuture : ScheduledFuture<*>? = null

    private var rom = ROM()
    val cpu = CPU()
    private var ram = RAM()
    private var screen = Screen()

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


    @OptIn(ExperimentalUnsignedTypes::class, ExperimentalStdlibApi::class)
    fun loadInROM()
    {
        println("Type in the path to the rom file:")
        val inputString: String = readln()
        //rom.load()
        val file = File(inputString).readBytes().map {it.toUByte()}.toUByteArray()
        rom.load(file)

//        file.forEachLine {
//
//            println(it.toByteArray())
//            rom.load(it.toByteArray())
//        }

        var yeah = 0
//        for (item in rom.memory)
//        {
//            println("Actual ${item}")
//            println(item.toInt() shr 4)
//            println(item.toInt() and 0xF)
//            yeah ++
//            if (yeah == 10)
//            {
//                break
//            }
//        }

        // Perform first operation!

//        for (thing in rom.memory ) {
//            val byte1 = rom.read(cpu.p)
//            val byte2 = rom.read(cpu.p + 1)
//            println((byte1.toInt() and 0xF))
//            println(byte2.toString())
//            cpu.p += 2
//
//            instructions[byte1.toInt() shr 4]?.executeInstruction(byte1, byte2)
//        }



    }

    fun stop()
    {
        cpuFuture?.cancel(true)
        // to wait for all futures to finish
        try {
            cpuFuture?.get() // waits for future to finish or be cancelled - blocks current thread execution (repeating futures will still run)
        } catch (_: Exception) {
            executor.shutdown() // turns off the executor allowing the program to terminate when the end is reached
        }

    }

    fun startCPU()
    {
        val cpu = Runnable {
            try {
                val byte1 = rom.read(cpu.p)
                val byte2 = rom.read(cpu.p + 1)
//                println((byte1.toInt() and 0xF))
//                println(byte2.toString())
                cpu.p += 2
                if (byte1.toInt() == 0 && byte2.toInt() == 0)
                {
                    stop()
                }

                instructions[byte1.toInt() shr 4]?.executeInstruction(byte1, byte2)
            }
            catch (e: Exception)
            {
                println("There was an exception! : $e")
            }
        }
        cpuFuture = executor.scheduleAtFixedRate(cpu,
            0,
            1000L / 500L, // repeat frequency - every 2 ms
            TimeUnit.MILLISECONDS )
    }


}