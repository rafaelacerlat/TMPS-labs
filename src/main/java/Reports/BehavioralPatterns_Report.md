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

* 



