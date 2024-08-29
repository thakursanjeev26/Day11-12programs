package ObjectOrientedPrograms;
class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
        }
    }

    // Optional: You can also add a method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }
}



public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000.0); // Initial balance: $1000

        System.out.println("Initial balance: $" + account.getBalance());

        account.debit(500.0); // Debit $500
        System.out.println("Balance after debit: $" + account.getBalance());

        account.debit(600.0); // Attempt to debit $600 (exceeds balance)
        System.out.println("Balance after debit: $" + account.getBalance());

        account.deposit(200.0); // Deposit $200
        System.out.println("Balance after deposit: $" + account.getBalance());
    }
}
