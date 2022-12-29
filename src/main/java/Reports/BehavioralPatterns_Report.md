# Topic: Behavioral Design Patterns

### Course: Software Design Techniques and Mechanisms
### Author: Rafaela Cerlat

----

## Implementation

This project is about an online shopping store, and some of its functionalities.

* [Observer](https://github.com/rafaelacerlat/TMPS-labs/tree/main/src/main/java/BehavioralPatterns/Observer) is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

  In this project, observer can be used for products price drop alerts. In the scenario of a single product price drop reminder, it will mainly contain two roles: the product and the user. Because there may be more than one user interested in the product, they will turn on the price drop reminder function, so the product should save the list of users who are concerned about it, and when the price of the product drops, the system will get the list of users who are concerned about the product and push messages to them one by one. The related process is shown in the following figure:
  
  ![image](https://user-images.githubusercontent.com/41265306/209966378-291d1692-dd28-4319-bb2a-019e34ed0bc5.png)


* 

