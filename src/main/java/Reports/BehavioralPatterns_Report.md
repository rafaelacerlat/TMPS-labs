# Topic: Behavioral Design Patterns

### Course: Software Design Techniques and Mechanisms
### Author: Rafaela Cerlat

----

## Implementation

This project is about an online shopping store, and some of its functionalities.

* [**Observer**](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/BehavioralPatterns/Observer) is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.
  Observer pattern mainly consists of the following four roles:

  - **Subject** : An abstract class or interface that contains methods for adding observers, removing observers, and notifying observers;
  - **Concrete Subject** : Concrete subject classes which implement methods defined in abstract subject classes or interfaces.
  - **Observer** : An abstract class or interface that generally contains an abstract method that receives updates and is called when a specific subject changes;
  - **Concrete Observer** : Implement the abstract method defined in the abstract observer to handle the specific business logic after receiving the update.

  In this project, observer can be used for products price drop alerts. In the scenario of a single product price drop reminder, it will mainly contain two roles: the product and the user. Because there may be more than one user interested in the product, they will turn on the price drop reminder function, so the product should save the list of users who are concerned about it, and when the price of the product drops, the system will get the list of users who are concerned about the product and push messages to them one by one. The related process is shown in the following figure:
  
  ![image](https://user-images.githubusercontent.com/41265306/209966378-291d1692-dd28-4319-bb2a-019e34ed0bc5.png)

  Based on the process information, we define a [Product](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Product.java) class.
  Then, we define the [User](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/User.java) class (Concrete Observer), which contains a notify() method for receiving price drop notifications.
  
  After having the User class, then we define the [ProductSubject](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Observer/ProductSubject.java) class (Concrete Subject). This class contains three methods of adding observers, removing observers, and notifying observers.
  
  Next, let’s verify the function of the product price reduction reminder:
  ```
  public class ObserverTest {
    @Test
    public void testObserver() {
        Product laptop = new Product("A001", "Notebook", 999);
        ProductSubject productSubject = new ProductSubject(laptop.getPid());

        User user1 = new User("U001", "Emma");
        User user2 = new User("U002", "John");

        productSubject.addObserver(user1);
        productSubject.addObserver(user2);

        productSubject.notifyObservers(laptop, 899);
    }
  }
  ```
  When the above code runs successfully, the console will output the following results:
  ```
  Dear Emma,the product you are concerned about: Notebook,Price drop of 100.0 $.
  Dear John,the product you are concerned about: Notebook,Price drop of 100.0 $.
  ```


* [**Strategy**](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/BehavioralPatterns/Strategy) is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable. This pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used at runtime.
  
  For this project, we implement a simple Shopping Cart where we have two payment strategies - using Credit Card or using PayPal. First of all we will create the [PaymentStrategy](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Strategy/PaymentStrategy.java) interface for our strategy pattern example, in our case to pay the amount passed as argument.
  
  Now we will have to create concrete implementation of algorithms for payment using [Credit Card](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Strategy/CreditCard.java) or through [PayPal](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Strategy/Paypal.java).
  
  Then, we can implement [Shopping Cart](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Strategy/ShoppingCart.java) and payment method will require input as Payment strategy.
  
  Let’s test our strategy pattern example setup with a simple program:
  ```
  public class StrategyTest {
    @Test
    public void testStrategy() {
        ShoppingCart cart = new ShoppingCart(3); // this is the third order

        Product laptop = new Product("A001", "Notebook", 999);
        Product phone = new Product("B003","Samsung", 500);

        cart.addItem(laptop);
        cart.addItem(phone);

        cart.calculateSubTotal();

        cart.pay(new Paypal("testEmail@randommailservice.com", "password"));

        cart.pay(new CreditCard("Rafaela", "1234567890123456", "786", "12/22"));
    }
  }
  ```
  Output of above program is:
  ```
  1499.0 paid using Paypal.
  1499.0 paid with credit/debit card
  ```

* [**Chain of responsability**](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/BehavioralPatterns/ChainOfResponsability) is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

  In this example, like most online sellers, we propose discounts under conditions. As we want our clients to come back regularly to place other orders, we have decided to compute and apply the best discount for our clients.
  
    ![image](https://user-images.githubusercontent.com/41265306/209970296-07f61f43-73f6-4f04-bf40-b6d7da0dd0a7.png)

  The pattern is conceptually simple. It is a linked list of rules where each concrete rule shares a common interface in order to manipulate them independently of their implementation. The common interface provides a method to execute the rule logic.
  
  So, we create a functional interface [Chain Discount](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/ChainOfResponsability/ChainDiscount.java) to have the handleRequest() method. Add a [Discount](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/ChainOfResponsability/Discount.java) abstract  class to support some operations of concrete class. And then add the implementation class for each kind of discount, [First Purchase](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/ChainOfResponsability/FirstPurchase.java) and [Discount by Voucher](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/ChainOfResponsability/DiscountByVoucher.java).
  
  And finally a method to execute them:
  ```
  public class ChainOfResponsabilityTest {
    @Test
    public void testCOR(){
        Product laptop = new Product("A001", "Notebook", 999);
        Product phone = new Product("B003","Samsung", 500);

        Voucher voucher1 = new Voucher("VOUCHER_1", 0.9);
        Voucher voucher2 = new Voucher("NEWYEAR", 0.8);

        ShoppingCart cart = new ShoppingCart(1);

        cart.addItem(laptop);
        cart.addItem(phone);

        cart.addVoucher(voucher1);
        cart.addVoucher(voucher2);

        cart.calculateSubTotal();

        FirstPurchase firstPurchase = new FirstPurchase(null, cart);
        DiscountByVoucher discountByVoucher = new DiscountByVoucher(firstPurchase, cart);

        firstPurchase.handleRequest();

        cart.pay(new Paypal("testEmail@randommailservice.com", "password"));
    }
  }
  ```
   This is the output, and we can see that the discount was applied:
   ```
   1349.10 paid using Paypal.
   ```


* 



