package racing

class Car(initialPosition: Int = 0, name: String = "자동차") {
    private var positionWrapper = CarPosition(initialPosition)
    private val nameWrapper = CarName(name)

    val position: Int
        get() = positionWrapper.position

    val name: String
        get() = nameWrapper.name

    fun attemptMove() {
        moveByDecision(CarMoveJudge.decideMove())
    }

    fun moveByDecision(willMove: Boolean) {
        if (willMove) move()
    }

    private fun move() {
        positionWrapper = CarPosition(position + 1)
    }
}

@JvmInline
value class CarPosition(val position: Int = 0)

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }
}
