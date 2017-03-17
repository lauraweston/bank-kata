package BankKata;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.fail;

public class AccountTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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

    @Test
    public void depositingIntoAnAccountWithANegativeBalanceUpdatesTheBalanceByTheAmountDeposited() throws Exception {
       givenAnAccountWithBalance(-5.0);

       whenTheCustomerDeposits(11.0);

       thenTheUpdatedAccountBalanceIs(6.0);
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

    @Test
    public void withdrawingAnAmountFromAnAccountWithInsufficientFundsThrowsInsufficientFundsException() throws Exception {
        expectedException.expect(InsufficientFundsException.class);

        givenAnEmptyAccount();

        whenTheCustomerWithdraws(10.0);

    }

    // givens
    private void givenAnEmptyAccount() {
        account = new Account();
    }

    private void givenAnAccountWithBalance(double amount) {
        account = new Account(amount);
    }

    // whens
    private void whenTheCustomerDeposits(double amount) {
        account.deposit(amount);
    }

    private void whenTheCustomerWithdraws(double amount) throws InsufficientFundsException {
        account.withdraw(amount);
    }

    // thens
    private void thenTheUpdatedAccountBalanceIs(double amount) {
        then(account.getBalance()).isEqualTo(amount);
    }
}
