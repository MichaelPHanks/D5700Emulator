package org.example

fun main() {
    // Talk to the computer from here!

    val computer: Computer = Computer()

    // Start computer!
    computer.loadInROM()
    computer.startCPU()
}