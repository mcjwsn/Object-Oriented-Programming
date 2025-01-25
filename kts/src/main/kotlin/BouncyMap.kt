package org.example

class BouncyMap (private val height: Int = 0, private val width: Int = 0): WorldMap {
    var animals: HashMap<Vector2d, Animal> = HashMap()

    override fun canMoveTo(position: Vector2d): Boolean {
        return position < Vector2d(width, height) && position > Vector2d(0, 0)
    }

    override fun place(animal: Animal): Boolean {
        // Usunięcie zwierzęcia, jeśli już istnieje na mapie
        animals.entries.removeIf { it.value == animal }

        // Sprawdzenie czy pozycja jest zajęta
        if (!canMoveTo(animal.position)) {
            return false
        }

        if (!isOccupied(animal.position)) {
            // Jeśli pozycja jest wolna, umieść zwierzę
            animals[animal.position] = animal
        } else {
            // Jeśli pozycja zajęta, znajdź losową wolną pozycję
            val randomFree: Vector2d? = randomFreePosition(Vector2d(width, height), animals)
            if (randomFree != null) {
                animal.position = randomFree
                animals[randomFree] = animal
            } else {
                // Jeśli brak wolnych pozycji, zamień miejsce z losowym zwierzęciem
                val toSwap = randomPosition(animals)
                if (toSwap == null){
                    return false
                }
                animals.remove(toSwap)?.let { swappedAnimal ->
                    swappedAnimal.position = randomFreePosition(Vector2d(width, height), animals) ?: toSwap
                    animals[swappedAnimal.position] = swappedAnimal
                }
                animal.position = toSwap
                animals[toSwap] = animal
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