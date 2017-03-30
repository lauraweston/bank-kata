package BankKata.acceptance;

import BankKata.Account;
import BankKata.InsufficientFundsException;
import com.googlecode.yatspec.junit.SpecRunner;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpecRunner.class)
public class WithdrawalsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Account account;

    @Test
    public void aCustomerCanWithdrawAnAmountFromAnAccountWithSufficientFunds() throws Exception {
        givenACustomerAccountWithABalanceOf(100.0);

        whenTheCustomerWithdraws(30.0);

        thenTheUpdatedAccountBalanceIs(70.0);
    }

    @Test
    public void aCustomerCannotWithdrawAnAmountFromAnAccountWithInsufficientFunds() throws Exception {
        expectedException.expect(InsufficientFundsException.class);

        givenACustomerAccountWithABalanceOf(50.0);

        whenTheCustomerWithdraws(100.0);

        thenTheBalanceDoesNotChange();
    }

    private void thenTheBalanceDoesNotChange() {
        //TODO replace with change by
        then(account.getBalance()).isEqualTo(50.0);
    }

    private void givenACustomerAccountWithABalanceOf(double amount) {
        account = new Account(amount);
    }

    private void whenTheCustomerWithdraws(double amount) throws InsufficientFundsException {
        account.withdraw(amount);
    }

    private void thenTheUpdatedAccountBalanceIs(double balance) {
        then(account.getBalance()).isEqualTo(balance);
    }
}
