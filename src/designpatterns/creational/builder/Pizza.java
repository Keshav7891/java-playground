package designpatterns.creational.builder;

import designpatterns.creational.builder.enums.Cheese;
import designpatterns.creational.builder.enums.Crust;
import designpatterns.creational.builder.enums.Sauce;
import designpatterns.creational.builder.enums.Size;

import java.util.List;

public final class Pizza {

    private final Size size;
    private final Crust crust;
    private final Sauce sauce;
    private final Cheese cheese;
    private List<String> toppings;
    private final boolean extraCheese;
    private final boolean glutenFree;
    private final String customerNote;


    public Pizza(Size size, Crust crust, Sauce sauce, Cheese cheese, boolean extraCheese, boolean glutenFree, String customerNote, List<String> toppings) {
        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.extraCheese = extraCheese;
        this.glutenFree = glutenFree;
        this.customerNote = customerNote;
        this.toppings = List.copyOf(toppings); // immutable
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public Size getSize() {
        return size;
    }

    public Crust getCrust() {
        return crust;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public double getPrice(){
        double basePrice = switch (size){
            case SMALL -> 8.0;
            case MEDIUM -> 11.0;
            case LARGE -> 14.0;
            case XL -> 17.0;
        };

        if(crust == Crust.STUFFED){
            basePrice = basePrice + 2.50;
        }

        if(crust == Crust.GLUTEN_FREE){
            basePrice = basePrice + 3.00;
        }

        if(extraCheese){
            basePrice = basePrice + 5.00;
        }

        basePrice += toppings.size() * 0.75;

        return basePrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", crust=" + crust +
                ", sauce=" + sauce +
                ", cheese=" + cheese +
                ", toppings=" + toppings +
                ", extraCheese=" + extraCheese +
                ", glutenFree=" + glutenFree +
                ", customerNote='" + customerNote + '\'' +
                '}';
    }
}
