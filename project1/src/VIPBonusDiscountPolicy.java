/* 
 * 4. VIPBonusDiscountPolicy Class
 * This class applies a base percentage and
 * an additional bonus if the amount exceeds a threshold.
 */
public class VIPBonusDiscountPolicy implements DiscountPolicy {
    private int basePercent; //ส่วนลดพื้นฐานที่ลูกค้า VIP ได้รับเสมอ
    private int bonusPercent; //ส่วนลดพิเศษที่จะได้รับเพิ่มจาก basePercent
    private double bonusThreshold; //เงื่อนไขโดยยอดเงิน(amount)ที่จ่ายมากกว่า bonusthreshold จะให้ส่วนลดพิเศษ

    public VIPBonusDiscountPolicy(int basePercent, int bonusPercent, double bonusThreshold){
        if(basePercent < 0 || basePercent > 100)
            throw new IllegalArgumentException("Base percent must be between 0 and 100.");
        if(bonusPercent < 0 || bonusPercent > 100)
            throw new IllegalArgumentException("Bonus percent must be between 0 and 100.");
        if(bonusThreshold < 0)
            throw new IllegalArgumentException("Bonus Threshold must be between 0 and 100.");

        this.basePercent = basePercent;
        this.bonusPercent = bonusPercent;
        this.bonusThreshold = bonusThreshold;
    }

    @Override
    public double applyDiscount(double amount) {
        if(amount < 0)
            throw new IllegalArgumentException("Amount cannot be negative");

        int totalPercent = basePercent;
        if(amount > bonusThreshold){
            totalPercent += bonusPercent;
        }

        // Cap the total discount at 100% to prevent negative prices
        if (totalPercent > 100) {
            totalPercent = 100;
        }
        return amount * (1 - totalPercent / 100.0);
    }

    @Override
    public String toString() {
        return String.format("%d base + %d bonus over %.2f", basePercent,bonusPercent,bonusThreshold);
    }
}
