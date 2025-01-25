package org.example

import java.util.*


interface WorldMap {
    fun canMoveTo(position: Vector2d): Boolean

    fun place(animal: Animal?)

    fun move(animal: Animal?, direction: MoveDirection?)

    fun isOccupied(position: Vector2d?): Boolean

    fun objectAt(position: Vector2d?): Any?

}