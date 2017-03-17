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

    @Test
    public void depositingAnAmountOfPoundsAndPenceIntoAnAccountUpdatesTheBalanceByTheCorrectAmount() throws Exception {
        givenAnAccountWithBalance(59.73);

        whenTheCustomerDeposits(32.14);

        thenTheUpdatedAccountBalanceIs(91.87);
    }

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

    @Test
    public void withdrawingAnAmountOfPoundsAndPenceFromAnAccountReducesTheBalanceByTheCorrectAmount() throws Exception {
        givenAnAccountWithBalance(123.45);

        whenTheCustomerWithdraws(67.89);

        thenTheUpdatedAccountBalanceIs(55.56);
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
