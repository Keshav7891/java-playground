package designpatterns.creational.builder;

import designpatterns.creational.builder.enums.Cheese;
import designpatterns.creational.builder.enums.Crust;
import designpatterns.creational.builder.enums.Sauce;
import designpatterns.creational.builder.enums.Size;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        Pizza margarita = menu.makeMargarita(Size.MEDIUM);
        System.out.println("Order 1: " + margarita);
        System.out.println();

        Pizza custom = new PizzaBuilder()
                .size(Size.XL)
                .crust(Crust.STUFFED)
                .sauce(Sauce.ALFREDO)
                .cheese(Cheese.MOZZARELLA)
                .addTopping("chicken")
                .addTopping("mushrooms")
                .addTopping("caramelised onion")
                .addTopping("truffle oil")
                .extraCheese()
                .note("Cut into squares, not triangles")
                .build();
        System.out.println("Order 2: " + custom);
        System.out.println();

        try {
            Pizza invalid = new PizzaBuilder()
                    .size(Size.SMALL)
                    .crust(Crust.THIN)
                    .cheese(Cheese.NONE)
                    .extraCheese()
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation caught: " + e.getMessage());
        }
    }
}
