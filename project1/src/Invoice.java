/* 
 * Composition Concept
 * Relationship 'has-a' (มี class Customer)
 */
public class Invoice {
    private int id;
    private Customer customer; // Composition Concept
    private double amount;

    public Invoice(int id, Customer customer, double amount){
        if (id < 0)
            throw new IllegalArgumentException("Customer ID must be non-negative.");
        if (customer == null)
            throw new IllegalArgumentException("Customer connot be null.");
        if (amount < 0) 
            throw new IllegalArgumentException("Amount must be non-negative");

        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer connot be null.");
        this.customer = customer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public int getCustomerId(){
        return customer.getId();
    }

    public String getCustomerName(){
        return customer.getName();
    }

    public int getCustomerDiscount(){
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount(){
        return this.amount * (1-getCustomerDiscount()/100.0);
    }

    @Override
    public String toString() {
        return String.format("Invoice[id=%d, customer=%s, amount=%.2f]", this.id,customer,this.amount);
    }

}
