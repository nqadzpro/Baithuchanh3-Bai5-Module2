/**
 * HỆ THỐNG NGÂN HÀNG - BUGBANK (LEGACY CODE)
 * Vấn đề: Dùng sai Static/Instance dẫn đến sai lệch trạng thái và lãng phí bộ nhớ.
 */
class BankAccount {
    String ownerName;
    double balance; 
    static int count = 0;
    static double interestRate = 0.05; 
    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        count++;
    }
    public void deposit(double amount) {
        balance += amount; 
    }
    public static void updateInterestRate(double newRate) {
        interestRate = newRate;
    }
}
public class MainBank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice");
        BankAccount acc2 = new BankAccount("Bob");
        acc1.deposit(1000);
        System.out.println("Tài khoản Alice: " + acc1.ownerName + " | Số dư: " + acc1.balance);
        acc2.deposit(500);
        System.out.println("Tài khoản Alice sau khi Bob nạp tiền: " + acc1.balance);
        System.out.println("Tài khoản Bob: " + acc2.ownerName + " | Số dư: " + acc2.balance);
        BankAccount acc3 = new BankAccount("Charlie");
        BankAccount.updateInterestRate(0.06);
        System.out.println(acc1.interestRate);
        System.out.println(acc2.interestRate);
        System.out.println("Số tài khoản đã tạo: " + BankAccount.count);
    }
}