package racing

class Car(initialPosition: Int = 0, name: String = "자동차") {
    private val positionWrapper = CarPosition(initialPosition)
    private val nameWrapper = CarName(name)

    val position: Int
        get() = positionWrapper.position

    val name: String
        get() = nameWrapper.name

    fun attemptMove() {
        val randomNumber = (MOVE_LOWER_BOUND..MOVE_UPPER_BOUND).random()

        if (randomNumber >= MOVE_THRESHOLD) {
            positionWrapper.go()
        }
    }

    companion object {
        private const val MOVE_LOWER_BOUND = 0
        private const val MOVE_UPPER_BOUND = 10
        private const val MOVE_THRESHOLD = 4
    }
}

data class CarPosition(var position: Int = 0) {
    fun go() {
        position += 1
    }
}

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }
}
