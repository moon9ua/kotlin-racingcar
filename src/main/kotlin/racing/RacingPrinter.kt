package racing

object RacingPrinter {
    fun printSimulationWithName(result: List<List<Int>>, cars: List<Car>) {
        printHeader()
        printResult(result, cars)
    }

    fun printSimulation(result: List<List<Int>>) {
        printHeader()
        printResult(result)
    }

    private fun printHeader() {
        println()
        println("실행 결과")
    }

    private fun printResult(result: List<List<Int>>, cars: List<Car>? = null) {
        result.forEach {
            printRound(it, cars)
            println()
        }
    }

    private fun printRound(roundResult: List<Int>, cars: List<Car>?) {
        if (cars != null) return printRoundWithName(roundResult, cars)
        return printRoundDefault(roundResult)
    }

    private fun printRoundDefault(roundResult: List<Int>) {
        return roundResult.forEach {
            println("-".repeat(it))
        }
    }

    private fun printRoundWithName(roundResult: List<Int>, cars: List<Car>) {
        return roundResult.forEachIndexed { index, result ->
            println("${cars[index].name} : ${"-".repeat(result)}")
        }
    }
}
