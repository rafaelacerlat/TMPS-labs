package BehavioralPatterns;

public class User {
     private String uid;
     private String name;

    public User(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public void notify(Product product, double price) {
        System.out.printf( "Dear %s,the product you are concerned about: " +
                "%s,Price drop of %s $.\n", name, product.getName(), (product.getPrice() - price));
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }
}
