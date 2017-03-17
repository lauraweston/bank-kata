package BankKata.acceptance;

import BankKata.Account;
import com.googlecode.yatspec.junit.SpecRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpecRunner.class)
public class WithdrawalsTest {
    private Account account = new Account();

    @Test
    public void aCustomerCanWithdrawAnAmountFromAnAccountWithSufficientFunds() throws Exception {
        givenAnCustomerAccountWithBalance(100.0);

        whenTheCustomerWithdraws(30.0);

        thenTheUpdatedAccountBalanceIs(70.0);
    }

    private void givenAnCustomerAccountWithBalance(double amount) {
        account.deposit(amount);
    }

    private void whenTheCustomerWithdraws(double amount) {
        account.withdraw(amount);
    }

    private void thenTheUpdatedAccountBalanceIs(double balance) {
        then(account.getBalance()).isEqualTo(balance);
    }
}
