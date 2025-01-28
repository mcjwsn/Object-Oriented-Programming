package org.example

class BouncyMap (private val height: Int = 0, private val width: Int = 0): WorldMap {
    private var animals: HashMap<Vector2d, Animal> = HashMap()

    override fun canMoveTo(position: Vector2d): Boolean {
        return position < Vector2d(width, height) && position > Vector2d(0, 0)
    }

    override fun place(animal: Animal): Boolean {
        animals.entries.removeIf { it.value == animal }

        if (!canMoveTo(animal.position)) {
            return false
        }

        if (!isOccupied(animal.position)) {
            animals[animal.position] = animal
        } else {

            var randomFree: Vector2d? = randomFreePosition(Vector2d(width, height), animals) ?: randomPosition(animals)
            if (randomFree != null) {
                animal.position = randomFree
                animals[randomFree] = animal
            }
            else {
                randomFree = randomPosition(animals)
                if (randomFree == null) {return false;}
                animals.remove(randomFree)

                animal.position = randomFree
                animals[randomFree] = animal
            }
        }
        return true
    }

    override fun isOccupied(position: Vector2d): Boolean {
        return animals.containsKey(position)
    }

    override fun objectAt(position: Vector2d): Any? {
        return animals[position]
    }
}