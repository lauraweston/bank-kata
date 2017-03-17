package BankKata;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.fail;

public class AccountTest {
    private Account account = new Account();

    @Test
    public void depositingIntoAnEmptyAccountUpdatesTheBalanceToTheAmountDeposited() throws Exception {
        givenAnEmptyAccount();

        whenTheCustomerDeposits(100.0);

        thenTheUpdatedAccountBalanceIs(100.0);
    }

    @Test
    public void depositingIntoAnAccountWithAPositiveBalanceUpdatesTheBalanceByTheAmountDeposited() throws Exception {
        givenAnAccountWithBalance(50.0);

        whenTheCustomerDeposits(100.0);

        thenTheUpdatedAccountBalanceIs(150.0);
    }

    //TODO: test for deposits of non-integer amounts

    @Ignore
    @Test
    public void depositingIntoAnAccountWithANegativeBalanceUpdatesTheBalanceByTheAmountDeposited() throws Exception {
        //Need to be able to withdraw money first.
        fail();
    }

    @Test
    public void withdrawingTheFullAmountFromAnAccountReducesTheBalanceToZero() throws Exception {
        givenAnAccountWithBalance(100.0);

        whenTheCustomerWithdraws(100.0);

        thenTheUpdatedAccountBalanceIs(0.0);
    }

    @Test
    public void withdrawingAnAmountFromAnAccountWithSufficientFundsReducesTheBalanceByTheAmount() throws Exception {
        givenAnAccountWithBalance(100.0);

        whenTheCustomerWithdraws(30.0);

        thenTheUpdatedAccountBalanceIs(70.0);
    }

    @Ignore
    @Test
    public void withdrawingAnAmountFromAnAccountWithInsufficientFundsThrowsInsufficientFundsException() throws Exception {
        fail();
    }

    // givens
    private void givenAnEmptyAccount() {
        account = new Account();
    }

    private void givenAnAccountWithBalance(double amount) {
        account.deposit(amount);
    }

    // whens
    private void whenTheCustomerDeposits(double amount) {
        account.deposit(amount);
    }

    private void whenTheCustomerWithdraws(double amount) {
        account.withdraw(amount);
    }

    // thens
    private void thenTheUpdatedAccountBalanceIs(double amount) {
        then(account.getBalance()).isEqualTo(amount);
    }
}
