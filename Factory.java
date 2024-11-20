public class Factory {
    public static Flavor createFlavor(String name) {
        switch (name.toLowerCase()) {
            case "mint chocolate chip": return new Flavor(name, 2.80);
            case "chocolate fudge": return new Flavor(name, 3.00);
            case "strawberry swirl": return new Flavor(name, 2.75);
            case "pistachio delight": return new Flavor(name, 3.25);
            default: throw new IllegalArgumentException("Unknown flavor: " + name);
        }
    }

    public static Topping createTopping(String name) {
        switch (name.toLowerCase()) {
            case "sprinkles": return new Topping(name, 0.30);
            case "marshmallow": return new Topping(name, 0.70);
            case "crushed oreo": return new Topping(name, 0.85);
            case "fresh strawberries": return new Topping(name, 1.00);
            case "chocolate chips": return new Topping(name, 0.50);
            default: throw new IllegalArgumentException("Unknown topping: " + name);
        }
    }
}