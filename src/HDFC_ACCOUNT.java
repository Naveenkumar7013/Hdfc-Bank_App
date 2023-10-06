import java.util.UUID;

public class HDFC_ACCOUNT  implements  Hdfc_Banking_Interface{

    private  String name;
    private  String accountNo;
    private  String password;
    private  double balance;
    final  double rateOfInterest = 7.0;
    final String IFSCCODE = "HDFC20185";

    public HDFC_ACCOUNT() {
    }

    public HDFC_ACCOUNT(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCODE() {
        return IFSCCODE;
    }

    @Override

    public String fetchBalance(String password) {
        if(password.equals(password)){
            return "Your balance is: " + balance;
        }
        return "Incorrect Password!!!";
    }

    @Override
    public String addMoney(double amount) {
        this.balance += amount;
        return "Amount added successfully. New balance is: " + this.balance;
    }

    @Override
    public String withDrawMoney(double amount, String password) {
        if(this.password.equals(password)){
            if(this.balance < amount){
                return "Insufficent balance";
            }
            this.balance -= amount;
            return "Amount deducted successfully. New balance: " + this.balance;
        }

        return "Incorrect Password!!!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {

        if(this.password.equals(oldPassword)){
            this.password = newPassword;
            return "Password changed successfully";
        }
        return "Incorrect original password";
    }

    @Override
    public double calculateInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0;
    }

    @Override
    public String toString() {
        return "HDFC_ACCOUNT{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCODE='" + IFSCCODE + '\'' +
                '}';
    }
}
