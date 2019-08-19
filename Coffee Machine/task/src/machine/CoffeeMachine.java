package machine;

import java.util.*;

class MachineActions {

    int water;
    int milk;
    int coffeeBeans;
    int cups;
    int money;


    public void remaining(int water, int milk, int coffeeBeans, int cups, int money) {

        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    public int collect (int money) {

        System.out.println("\nI gave you $" + money);
        this.money = 0;
        return this.money;
    }

    public int changeWaterQty (int water, int waterAdd) {

        this.water += waterAdd;
        return this.water;
    }

    public int changeMilkQty (int milk, int milkAdd) {

        this.milk += milkAdd;
        return this.milk;
    }

    public int changeCoffeeBeansQty (int coffeeBeans, int coffeeBeansAdd) {

        this.coffeeBeans += coffeeBeansAdd;
        return this.coffeeBeans;
    }

    public int changeCupsQty (int cups, int cupsAdd) {

        this.cups += cupsAdd;
        return this.cups;
    }

    public int changeMoneyQty (int money, int moneyAdd) {

        this.money += moneyAdd;
        return this.money;
    }

    public boolean resourcesCheck (int water, int milk, int coffeeBeans, int cups, int waterNeed,
                                  int milkNeed, int coffeeBeansNeed, int cupsNeed) {

        if (water < waterNeed) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        if (milk < milkNeed) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        if (coffeeBeans < coffeeBeansNeed) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        if (cups < cupsNeed) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }

        System.out.println("I have enough resources, making you a coffee!");

        return true;
    }
}


public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MachineActions machineAction = new MachineActions();
// coffee machine initial resources:
        machineAction.water = 400;
        machineAction.milk = 540;
        machineAction.coffeeBeans = 120;
        machineAction.cups = 9;
        machineAction.money = 550;

// expenditure of cups:
        int cupsForCoffee = 1;
// espresso portions resources & cost:
        int waterForEspresso = 250;
        int milkForEspresso = 0;
        int coffeeBeansForEspresso = 16;
        int espressoPrise = 4;
// latte portions resources & cost:
        int waterForLatte = 350;
        int milkForLatte = 75;
        int coffeeBeansForLatte = 20;
        int lattePrise = 7;
// cappuccino portions resources & cost:
        int waterForCappuccino = 200;
        int milkForCappuccino = 100;
        int coffeeBeansForCappuccino = 12;
        int cappuccinoPrise = 6;

        boolean exit = false; // trigger for main loop

        do {

            System.out.print("\nWrite action (buy, fill, take, remaining, exit): ");
            String userChoice = scan.next();

            switch (userChoice) {
                case "buy":

                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, " +
                            "3 - cappuccino, back - to main menu: ");
                    String userCoffeeTypeChoice = scan.next();
    //I don't know, if it's right to use a switch nested in a switch?
                    switch (userCoffeeTypeChoice) {
                        case "1": // espresso

                            if (machineAction.resourcesCheck(machineAction.water, machineAction.milk, machineAction.coffeeBeans,
                                    machineAction.cups, waterForEspresso, milkForEspresso, coffeeBeansForEspresso,
                                    cupsForCoffee) == true) {

                                machineAction.changeWaterQty(machineAction.water, -waterForEspresso);
                                machineAction.changeCoffeeBeansQty(machineAction.coffeeBeans, -coffeeBeansForEspresso);
                                machineAction.changeCupsQty(machineAction.cups, -cupsForCoffee);
                                machineAction.changeMoneyQty(machineAction.money, espressoPrise);
                            }

                            break;

                        case "2": // latte

                            if (machineAction.resourcesCheck(machineAction.water, machineAction.milk, machineAction.coffeeBeans,
                                    machineAction.cups, waterForLatte, milkForLatte, coffeeBeansForLatte,
                                    cupsForCoffee) == true) {

                            machineAction.changeWaterQty(machineAction.water, -waterForLatte);
                            machineAction.changeMilkQty(machineAction.milk, -milkForLatte);
                            machineAction.changeCoffeeBeansQty(machineAction.coffeeBeans, -coffeeBeansForLatte);
                            machineAction.changeCupsQty(machineAction.cups, -cupsForCoffee);
                            machineAction.changeMoneyQty(machineAction.money, lattePrise);
                            }

                            break;

                        case "3": // cappuccino

                            if (machineAction.resourcesCheck(machineAction.water, machineAction.milk, machineAction.coffeeBeans,
                                    machineAction.cups, waterForLatte, milkForLatte, coffeeBeansForLatte,
                                    cupsForCoffee) == true) {

                            machineAction.changeWaterQty(machineAction.water, -waterForCappuccino);
                            machineAction.changeMilkQty(machineAction.milk, -milkForCappuccino);
                            machineAction.changeCoffeeBeansQty(machineAction.coffeeBeans, -coffeeBeansForCappuccino);
                            machineAction.changeCupsQty(machineAction.cups, -cupsForCoffee);
                            machineAction.changeMoneyQty(machineAction.money, cappuccinoPrise);
                            }
                            break;

                        case "back":
                            break;

                        default:
                            System.out.println("\nWrong choice! Please, make your choice again.");
                            break;
                    }

                    break;

                case "fill":

                    System.out.print("\nWrite how many ml of water do you want to add: ");
                    int waterAdd = scan.nextInt();
                    machineAction.changeWaterQty(machineAction.water, waterAdd);

                    System.out.print("Write how many ml of milk do you want to add: ");
                    int milkAdd = scan.nextInt();
                    machineAction.changeMilkQty(machineAction.milk, milkAdd);

                    System.out.print("Write how many grams of coffee beans do you want to add: ");
                    int coffeeBeansAdd = scan.nextInt();
                    machineAction.changeCoffeeBeansQty(machineAction.coffeeBeans, coffeeBeansAdd);

                    System.out.print("Write how many disposable cups of coffee do you want to add: ");
                    int cupsAdd = scan.nextInt();
                    machineAction.changeCupsQty(machineAction.cups, cupsAdd);
                    break;

                case "take":
                    machineAction.collect(machineAction.money);

                    machineAction.remaining(machineAction.water, machineAction.milk, machineAction.coffeeBeans,
                            machineAction.cups, machineAction.money);
                    break;

                case "remaining":
                    machineAction.remaining(machineAction.water, machineAction.milk, machineAction.coffeeBeans,
                            machineAction.cups, machineAction.money);
                    break;

                case "exit":
                    exit = true;
                    break;

                default:
                    System.out.println("\nWrong choice! Please, make your choice again.");
                    break;
            }

        } while (exit == false);
    }
}