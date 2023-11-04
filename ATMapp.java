import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
}
    public double getBalance() {
        return balance;
}
    public void deposit(double amount) {
        balance += amount;
}
     public boolean withdraw(double amount) {
        if (amount <= balance) {
        balance -= amount;
            return true;
} 
else {
            return false; 
}
}
}

class ATM {
    private BankAccount userAccount;
    public ATM(BankAccount account) 
{
        this.userAccount = account;
}
    public void displayMenu() 
{
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
}
  public void withdraw(double amount) 
{
       if (userAccount.withdraw(amount)) 
{
       System.out.println("Withdrawal successful. Current balance: " + userAccount.getBalance());
} 
else {
            System.out.println("Insufficient balance. Withdrawal failed.");
}
}

    public void deposit(double amount) 
{
    userAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + userAccount.getBalance());
}

   public void checkBalance() 
{
        System.out.println("Current balance: " + userAccount.getBalance());
}
}

public class ATMapp{
public static void main(String[] args) 
{
    BankAccount userAccount = new BankAccount(2000); 
    ATM atm = new ATM(userAccount);
    Scanner scanner = new Scanner(System.in);
    while (true) 
{
    atm.displayMenu();
    System.out.print("Choose an option (1-4): ");
    int choice = scanner.nextInt();
    switch (choice) 
{
    case 1:
    atm.checkBalance();
    break;
    case 2:
    System.out.print("Enter the deposit amount: ");
    double depositAmount = scanner.nextDouble();
    atm.deposit(depositAmount);
    break;
    case 3:
    System.out.print("Enter the withdrawal amount: ");
    double withdrawalAmount = scanner.nextDouble();
    atm.withdraw(withdrawalAmount);
    break;
    case 4:
    System.out.println("Thank you for using the ATM!!");
    System.exit(0);
    default:
    System.out.println("Invalid choice. Please select a valid option.");
}
}
}
}
