package BankKata.acceptance;

import BankKata.Account;
import com.googlecode.yatspec.junit.SpecRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpecRunner.class)
public class DepositsTest {

    private Account account = new Account();

    @Test
    public void aCustomerCanDepositAnAmountIntoAnAccount() throws Exception {
        givenACustomerAccountWithABalanceOf(100.0);

        whenTheCustomerMakesADepositOf(50.0);

        thenTheUpdatedAccountBalanceIs(150.0);
    }

    private void givenACustomerAccountWithABalanceOf(double balance) {
        account.deposit(balance);
    }

    private void whenTheCustomerMakesADepositOf(double amount) {
        account.deposit(amount);
    }

    private void thenTheUpdatedAccountBalanceIs(double amount) {
        assertThat(account.getBalance()).isEqualTo(amount);
    }


}
