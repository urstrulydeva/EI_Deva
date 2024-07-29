package ProjectI.StructuralPattern;
import java.util.*;
// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy for Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

// Concrete Strategy for PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using PayPal.");
    }
}

// Context
class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        int total = items.stream().mapToInt(Item::getPrice).sum();
        paymentStrategy.pay(total);
    }
}

// Item Class
class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

// Main
public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Book", 50));
        cart.addItem(new Item("Pen", 10));

        cart.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456"));
        cart.checkout();

        cart.setPaymentStrategy(new PayPalPayment("john@example.com"));
        cart.checkout();
    }
}

