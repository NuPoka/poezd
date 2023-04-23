import kotlin.random.Random

fun main() {
    val cities = listOf(
        "Бийск", "Барнаул", "Новосибирск", "Омск", "Томск",
        "Кемерово", "Красноярск", "Иркутск", "Новокузнецк",
        "Ангарск", "Братск", "Улан-Удэ", "Чита", "Краснодар", "Ростов-на-Дону"
    )
    var continueWork = true
    while (continueWork) {
        print("Хотите составить поезд? (Введите 'EXIT' для выхода): ")
        val userInput = readLine() ?: ""
        if (userInput == "EXIT") {
            continueWork = false
            continue
        }
        val startCity = cities.random()
        var endCity = cities.random()
        while (startCity == endCity) {
            endCity = cities.random()
        }
        println("Создано направление: $startCity - $endCity")
        val numPassengers = Random.nextInt(5, 201)
        println("Продано билетов: $numPassengers")
        var trainCapacity = 0
        var numCars = 0
        while (trainCapacity < numPassengers) {
            val carCapacity = Random.nextInt(5, 25)
            trainCapacity += carCapacity
            numCars++
        }
        println("Сформирован поезд: $numCars вагонов")
        val carCapacities = mutableListOf<Int>()
        val passengersPerCar = mutableListOf<Int>()
        repeat(numCars) {
            val carCapacity = Random.nextInt(5, 25)
            carCapacities.add(carCapacity)
            val passengersInCar = if (it == numCars - 1) {
                numPassengers - passengersPerCar.sum()
            } else {
                Random.nextInt(0, numPassengers - passengersPerCar.sum() - numCars + it + 1)
            }
            passengersPerCar.add(passengersInCar)
        }
        println("Отправлен поезд: $startCity - $endCity, состоящий из $numCars вагонов")
        println("Вместимость вагонов: $carCapacities")
        println("Количество пассажиров в вагонах: $passengersPerCar")
    }
}