// The builder pattern solves two problems: too many constructor arguments and incorrect object state.

class BankAccount {

    // we should only permit instantiation through the builder interface
    private BankAccount() {}

    static class Builder {

        private long accountNum;
        private String owner;
        private String branch;
        private double balance;
        private double interestRate;

        public Builder(long accountNum) {
            this.accountNum = accountNum;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this; // return the builder instance so we can 'chain' together calls
        }

        public Builder atBranch(String branch){
            this.branch = branch;
            return this;
        }

        public Builder openingBalance(double balance){
            this.balance = balance;
            return this;
        }

        public Builder atRate(double interestRate){
            this.interestRate = interestRate;
            return this;
        }

        public BankAccount build() {
            // Return the fully initialised bank account object
            BankAccount account = new BankAccount();
            account.accountNumber = this.accountNumber;
            account.owner = this.owner;
            account.branch = this.branch;
            account.balance = this.balance;
            account.interestRate = this.interestRate;
            return account;
        }
    }
}

public class BuilderDemo {

    public static void main(String[] args) {
        BankAccount b = new BankAccount.Builder(1234L)
            .withOwner("Owner")
            .atBranch("Branch")
            .openingBalance(999)
            .atRate(1)
            .build();
    }
}

// Example from https://dzone.com/articles/design-patterns-the-builder-pattern