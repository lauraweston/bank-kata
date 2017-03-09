package BankKata;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account = new Account();

    @Test
    public void depositsAGivenAmountToTwoDecimalPlacesIntoTheAccountAndUpdatesTheBalance() throws Exception {
        givenACustomerAccount();

        whenTheCustomerDeposits1000And25();

        thenTheAccountBalanceIs1000And25();
    }

    //givens

    private Account givenACustomerAccount() {
        return account;
    }

    //whens
    private void whenTheCustomerDeposits1000And25() {
        account.deposit(1000.25);
    }

    //thens

    private void thenTheAccountBalanceIs1000And25() {
        assertThat(account.printBalance(), equalTo("1000.25"));
    }

    //TODO test for 1000.00
}
