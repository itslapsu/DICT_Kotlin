fun main() {
    val classCoffee = coffeeMachine()
    print("Write action (buy, fill, take, remaining, exit):\n> ")
    when (readln()) {
        "buy" -> classCoffee.buy()
        "fill" -> classCoffee.fill()
        "take" -> classCoffee.take()
        "remaining" -> classCoffee.remaining()
        "exit" -> return
        else -> main()
    }
}

class coffeeMachine {
    private var water: Int = 400
    private var milk: Int = 540
    private var beans: Int = 120
    private var money: Int = 550
    private var cups: Int = 9
    private val coffeeEspresso = mapOf <String, Short> ("water" to 250, "beans" to 16, "money" to 4)
    private val coffeeLatte = mapOf <String, Short> ("water" to 350, "milk" to 75, "beans" to 20, "money" to 7)
    private val coffeeCappuccino = mapOf <String, Short> ("water" to 200, "milk" to 100, "beans" to 12, "money" to 6)

    fun remaining() {
        println("The coffee machine has:\n$water ml of water\n$milk ml of milk\n$beans of coffee beans\n" +
                "$cups of disposable cups\n$money of money")
    }

    fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ")
        when(readln()) {
            "1" -> makeEspresso()
            "2" -> makeLatte()
            "3" -> makeCappuccino()
            "back" -> main()
            else -> {
                println("Please enter 1-3 or 'back'!")
                buy()
            }
        }
    }

    fun fill() {
        print("Write how many ml of water you want to add:\n> ")
        water += readln().toInt()
        print("Write how many ml of milk you want to add:\n> ")
        milk += readln().toInt()
        print("Write how many grams of coffee beans you want to add:\n> ")
        beans += readln().toInt()
        print("Write how many disposable coffee cups you want to add:\n> ")
        cups += readln().toInt()
    }

    fun take() {
        if (money <= 0) {
            println("There is no money in the coffee machine")
        }
        else {
            print("How much money do you take?\n> ")
            val takeMoney = readln().toInt()
            if (money < takeMoney) {
                println("Dup money is forbidden")
            }
            else {
                if (takeMoney < 0) {
                    println("Dup money is forbidden")
                }
                else {
                    println("I gave you $takeMoney")
                    money -= takeMoney
                }
            }

        }
    }

    private fun makeEspresso() {
        if (water < coffeeEspresso["water"]!!) {
            println("Sorry, not enough water!")
        }
        if (beans < coffeeEspresso["beans"]!!) {
            println("Sorry, not enough beans!")
        }
        if (cups < 1) {
            println("Sorry, not enough cups!")
        }
        if (water >= coffeeEspresso["water"]!!
            && beans >= coffeeEspresso["beans"]!!
            && cups >= 1)
        {
            println("I have enough resources, making you a coffee!")
            money += coffeeEspresso["money"]!!
            water -= coffeeEspresso["water"]!!
            beans -= coffeeEspresso["beans"]!!
            cups -= 1
        }
    }

    private fun makeLatte() {
        if (water < coffeeLatte["water"]!!) {
            println("Sorry, not enough water!")
        }
        if (milk < coffeeLatte["milk"]!!) {
            println("Sorry, not enough milk!")
        }
        if (beans < coffeeLatte["beans"]!!) {
            println("Sorry, not enough beans!")
        }
        if (cups < 1) {
            println("Sorry, not enough cups!")
        }
        if (water >= coffeeLatte["water"]!!
            && milk >= coffeeLatte["milk"]!!
            && beans >= coffeeLatte["beans"]!!
            && cups >= 1)
        {
            println("I have enough resources, making you a coffee!")
            money += coffeeLatte["money"]!!
            water -= coffeeLatte["water"]!!
            milk -= coffeeLatte["milk"]!!
            beans -= coffeeLatte["beans"]!!
            cups -= 1
        }
    }

    private fun makeCappuccino() {
        if (water < coffeeCappuccino["water"]!!) {
            println("Sorry, not enough water!")
        }
        if (milk < coffeeCappuccino["milk"]!!) {
            println("Sorry, not enough milk!")
        }
        if (beans < coffeeCappuccino["beans"]!!) {
            println("Sorry, not enough beans!")
        }
        if (cups < 1) {
            println("Sorry, not enough cups!")
        }
        if (water >= coffeeCappuccino["water"]!!
            && milk >= coffeeCappuccino["milk"]!!
            && beans >= coffeeCappuccino["beans"]!!
            && cups >= 1)
        {
            println("I have enough resources, making you a coffee!")
            money += coffeeCappuccino["money"]!!
            water -= coffeeCappuccino["water"]!!
            milk -= coffeeCappuccino["milk"]!!
            beans -= coffeeCappuccino["beans"]!!
            cups -= 1
        }
    }
}