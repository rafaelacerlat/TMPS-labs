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

* [**Command**](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/BehavioralPatterns/Command) is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

  In command pattern, the request is send to the invoker and invoker pass it to the encapsulated command object. Command object passes the request to the appropriate method of Receiver to perform the specific action. The client program create the receiver object and then attach it to the Command. Then it creates the invoker object and attach the command object to perform an action. Now when client program executes the action, it’s processed based on the command and receiver object.

  For this project, we can separate the products into categories. Therefore, we have a [Category](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Command/Category.java) class that stores the corresponding products/items in a list. 
  
  Then we have an [ICommand](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Command/ICommand.java) interface which serves as a Command Object. Now we need to create implementations for all the different types of action performed by the receiver. Since we have two actions we will create two Command implementations, [Add Command](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Command/AddCommand.java) and [Delete Command](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Command/DeleteCommand.java). Each of them will forward the request to the appropriate method of receiver.
  Invoker [Product Manager](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Command/ProductManager.java) is a simple class that encapsulates the Command and passes the request to the command object to process it.
  
  Let’s move now to create our command pattern example client program:
  ```
  public class CommandTest {
    @Test
    public void testCommand(){

        //Add an item to the New Releases category
        Product laptop = new Product("A001", "Notebook", 999);
        Category category = new Category("New Releases");
        ICommand command = new AddCommand(laptop, category);
        ProductManager productManager = new ProductManager();
        productManager.setCommand(command);
        productManager.process();

        //Delete an item from the New Releases category
        command = new DeleteCommand(laptop, category);
        productManager.setCommand(command);
        productManager.process();

    }
  }
  ```
  And the output is as follows:
  ```
  Item 'Notebook' has been added to the 'New Releases' Category 
  Item 'Notebook' has been deleted from the 'New Releases' Category 
  ```
* [**Template**](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/BehavioralPatterns/Template) is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
 
  Template method design pattern has two components. An abstract parent class and one or more concrete child classes extending that parent class. The abstract parent class is the template class used to define the algorithmic steps and preserve it across implementations. Child class contains details of the abstract methods.


  ![image](https://user-images.githubusercontent.com/41265306/209974776-8ebdf83d-8d66-4b1b-8a8b-b805318331a7.png)
  
  The above UML diagram deals with order processing flow. The [OrderProcessTemplate](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Template/OrderProcessTemplate.java) class is an abstract class containing the algorithm skeleton. As shown, processOrder() is the method that contains the process steps. We have two subclasses [NetOrder](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Template/NetOrder.java) and [StoreOrder](https://github.com/rafaelacerlat/TMPS-labs/blob/main/src/main/java/BehavioralPatterns/Template/StoreOrder.java) which has the same order processing steps.

  So the overall algorithm used to process an order is defined in the base class and used by the subclasses. But the way individual operations are performed vary depending on the subclass.

  The test for this pattern looks in the following way:
  ```
  public class TemplateTest {
    @Test
    public void testTemplate(){
        System.out.println("--- NetOrder instance of the Template:");
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder();
        System.out.println("--- StoreOrder instance of the Template:");
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();
    }
  }
  ```
  
  And the output:
  ```
  --- NetOrder instance of the Template:
  Item added to online shopping cart,
  Get gift wrap preference,
  Get delivery address.
  Online Payment through Netbanking/Cards.
  Ship the item through post to delivery address
  --- StoreOrder instance of the Template:
  Customer chooses the item from shelf.
  Pays at counter through cash/POS
  Item deliverd to in delivery counter.
  ```
