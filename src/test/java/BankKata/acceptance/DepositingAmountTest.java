package BankKata.acceptance;

import BankKata.Account;
import com.googlecode.yatspec.junit.SpecRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpecRunner.class)
public class DepositingAmountTest {

    private Account account = new Account();

    @Test
    public void aCustomerCanDepositASumOfMoneyIntoAnAccount() throws Exception {
        givenACustomerAccountWithBalanceOf100();

        whenTheCustomerMakesADepositOf50();

        thenTheUpdatedAccountBalanceIs150();
    }

    private void givenACustomerAccountWithBalanceOf100() {
        account.deposit(100.0);
    }

    private void whenTheCustomerMakesADepositOf50() {
        account.deposit(50.0);
    }

    private void thenTheUpdatedAccountBalanceIs150() {
        assertThat(account.getBalance()).isEqualTo(150.0);
    }


}
