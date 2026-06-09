package designpatterns.creational.builder;

import designpatterns.creational.builder.enums.Cheese;
import designpatterns.creational.builder.enums.Crust;
import designpatterns.creational.builder.enums.Sauce;
import designpatterns.creational.builder.enums.Size;

public class Menu {

    public Pizza makeMargarita(Size size) {
        return new PizzaBuilder()
                .size(size)
                .crust(Crust.THIN)
                .sauce(Sauce.TOMATO)
                .cheese(Cheese.MOZZARELLA)
                .addTopping("fresh basil")
                .note("Classic Margarita")
                .build();
    }

    public Pizza makeBBQChicken(Size size) {
        return new PizzaBuilder()
                .size(size)
                .crust(Crust.THICK)
                .sauce(Sauce.BBQ)
                .cheese(Cheese.CHEDDAR)
                .addTopping("grilled chicken")
                .addTopping("red onion")
                .addTopping("sweetcorn")
                .extraCheese()
                .note("BBQ Chicken special")
                .build();
    }

    public Pizza makeVeganDelight(Size size) {
        return new PizzaBuilder()
                .size(size)
                .crust(Crust.THIN)
                .sauce(Sauce.PESTO)
                .cheese(Cheese.VEGAN)
                .addTopping("roasted peppers")
                .addTopping("sun-dried tomatoes")
                .addTopping("spinach")
                .addTopping("olives")
                .glutenFree()
                .note("Vegan Delight — GF base")
                .build();
    }

    public Pizza makePepperoni(Size size, boolean extraCheese) {
        PizzaBuilder builder = new PizzaBuilder()
                .size(size)
                .crust(Crust.THICK)
                .sauce(Sauce.TOMATO)
                .cheese(Cheese.MOZZARELLA)
                .addTopping("pepperoni")
                .addTopping("green pepper");

        if (extraCheese) builder.extraCheese();

        return builder.build();
    }
}