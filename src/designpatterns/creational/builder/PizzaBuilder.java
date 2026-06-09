package designpatterns.creational.builder;

import designpatterns.creational.builder.enums.Cheese;
import designpatterns.creational.builder.enums.Crust;
import designpatterns.creational.builder.enums.Sauce;
import designpatterns.creational.builder.enums.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PizzaBuilder {

    private Size size;
    private Crust crust;

    private Sauce sauce = Sauce.TOMATO;
    private Cheese cheese = Cheese.MOZZARELLA;
    private List<String> toppings = new ArrayList<>();
    private boolean extraCheese = false;
    private boolean glutenFree = false;
    private String customerNote = "";

    public PizzaBuilder size(Size size){
        this.size = Objects.requireNonNull(size);
        return this;
    }

    public PizzaBuilder crust(Crust crust){
        this.crust = Objects.requireNonNull(crust);
        return this;
    }

    public PizzaBuilder sauce(Sauce sauce){
        this.sauce = Objects.requireNonNull(sauce);
        return this;
    }

    public PizzaBuilder cheese(Cheese cheese){
        this.cheese = Objects.requireNonNull(cheese);
        return this;
    }

    public PizzaBuilder addTopping(String topping) {
        if (topping == null || topping.isBlank())
            throw new IllegalArgumentException("Topping name cannot be blank");
        if (toppings.size() >= 6)
            throw new IllegalStateException("Maximum 6 toppings allowed");
        this.toppings.add(topping.trim().toLowerCase());
        return this;
    }

    public PizzaBuilder extraCheese() {
        this.extraCheese = true;
        return this;
    }

    public PizzaBuilder glutenFree() {
        this.glutenFree   = true;
        this.crust        = Crust.GLUTEN_FREE;   // auto-set correct crust
        return this;
    }

    public PizzaBuilder note(String note) {
        this.customerNote = note == null ? "" : note.trim();
        return this;
    }

    public Pizza build() {
        if (size  == null) throw new IllegalStateException("Size is required");
        if (crust == null) throw new IllegalStateException("Crust is required");

        // 2. Cross-field validation
        if ((extraCheese && cheese == Cheese.NONE))
            throw new IllegalStateException(
                    "Cannot add extra cheese when cheese is set to NONE");

        if (extraCheese && cheese == Cheese.VEGAN)
            throw new IllegalStateException(
                    "Extra cheese is not available with vegan cheese");

        if (glutenFree && crust != Crust.GLUTEN_FREE)
            throw new IllegalStateException(
                    "Gluten-free option requires GLUTEN_FREE crust");

        if (crust == Crust.STUFFED && size == Size.SMALL)
            throw new IllegalStateException(
                    "Stuffed crust is not available on small pizzas");

        return new Pizza(size, crust, sauce, cheese, extraCheese, glutenFree, customerNote, toppings);

    }

}
