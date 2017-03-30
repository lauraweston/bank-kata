package BankKata.acceptance;

import BankKata.Account;
import BankKata.NoCoinsAllowedException;
import com.googlecode.yatspec.junit.SpecRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpecRunner.class)
public class DepositsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Account account;

    @Test
    public void aCustomerCanDepositAnAmountIntoAnAccount() throws Exception {
        givenACustomerAccountWithABalanceOf(100.0);

        whenTheCustomerMakesADepositOf(50.0);

        thenTheUpdatedAccountBalanceIs(150.0);
    }

    @Test
    public void aCustomerCanOnlyDepositNotesIntoAnAccount() throws Exception {
        expectedException.expect(NoCoinsAllowedException.class);

        givenACustomerAccountWithABalanceOf(0.0);

        whenTheCustomerMakesADepositOf(11.11);
    }

    private void givenACustomerAccountWithABalanceOf(double balance) {
        account = new Account(balance);
    }

    private void whenTheCustomerMakesADepositOf(double amount) {
        account.deposit(amount);
    }

    private void thenTheUpdatedAccountBalanceIs(double amount) {
        assertThat(account.getBalance()).isEqualTo(amount);
    }


}
