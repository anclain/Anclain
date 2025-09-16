package EntryTest.BankInteract;

import EntryTest.InsufficientBalanceException;

public class BankAccount {
    int accountNumber;
    int balance;

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        if(amount < 0){
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount);
    }
    public void withdraw(int amount) throws InsufficientBalanceException {
        if(amount < 0){
            System.out.println("Invalid amount");
            return;
        }
        else if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawn " + amount);
    }

    public int getBalance() {
        return balance;
    }
}
