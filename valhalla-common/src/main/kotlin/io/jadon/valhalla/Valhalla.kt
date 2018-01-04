package io.jadon.valhalla

object Valhalla {

    val games = mutableListOf<Game>()
    val arenas = mutableListOf<Arena>()

    fun getGame(name: String): Game? {
        return games.find { it.name == name }
    }

    fun getArena(id: Int): Arena? {
        return arenas.find { it.id == id }
    }

    fun addArena(arena: Arena) {
        if (arenas.map { it.id }.contains(arena.id)) {
            throw IllegalAccessException("Arena with id ${arena.id} exists.")
        }
        arenas.add(arena)
        arena.id = arenas.indexOf(arena)
    }

    fun onEnable() {
        println("Valhalla Enable")
    }

    fun onDisable() {
        println("Valhalla Disable")
    }

}
