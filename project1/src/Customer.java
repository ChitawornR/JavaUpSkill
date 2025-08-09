public class Customer {
    private int id;
    private String name;
    private int discount;

    /*
     * Constructor for create Customer object
     * 
     * @param id ไม่เป็นค่าติดลบ
     * 
     * @param name ไม่เป็นค่าว่าง
     * 
     * @param discount ส่วนลด(%) ต้องอยู่ระหว่าง 0-100
     * throws IllegalArgumentException หาก @param ไม่ถูกต้อง
     */

    public Customer(int id, String name, int discount) {
        if (id < 0)
            throw new IllegalArgumentException("Customer ID must be non-negative.");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Customer Name must not be null or blank.");
        if (discount < 0 || discount > 100)
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");

        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount > 100)
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)(%d%%)", name,id,discount);
    }

    
}
