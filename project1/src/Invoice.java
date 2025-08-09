/* 
 * 6. Invoice Class
 * This class represents an invoice, linking a customer to a total amount.
 * Relataionship 'has-a' (มี Class Customer)
 */
public class Invoice {
    private int id;
    private Customer customer; // Composition Concept
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
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

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    // This method as per UML diagram
    // public int getCustomerDiscount(){
    // return customer.getDiscountPolicy();
    // }

    // Core business logic: apply the customer's discount policy
    public double getAmountAfterDiscount() {
        return this.customer.getDiscountPolicy().applyDiscount(this.amount);
    }

    @Override
    public String toString() {
        return "Invoice{id= " + id + 
                ", customerId= " + getCustomerId() + 
                ", customerName= " + getCustomerName() +
                ", orginalAmount= " + String.format("%.2f", amount) + 
                ", dicountAmount= "+ String.format("%.2f", getAmountAfterDiscount()) + "}";
    }

}
