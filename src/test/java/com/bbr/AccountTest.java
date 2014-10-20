package com.bbr;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private static final Amount AMOUNT_TEN = new Amount(10.0);

    // 1) Deposit and withdrawal
    @Test
    public void given_account_when_deposit_10_then_account_should_10_amount() {
        Account account = new Account();

        account.deposit(AMOUNT_TEN);

        assertThat(account.consultLastDeposit()).isEqualTo(AMOUNT_TEN);
    }

    @Test
    public void given_account_when_withdrawal_10_then_account_should_10_amount() {
        Account account = new Account();

        account.withdrawal(AMOUNT_TEN);

        assertThat(account.consultLastWithdrawal()).isEqualTo(AMOUNT_TEN);
    }

    // 2) Transfer
    @Test
    public void given_accountA_with_10_account2_with0_when_A_transfer10_to_B_then_accountA_is_0_account_B_is_10() {
        Account accountA = new Account().deposit(AMOUNT_TEN);
        Account accountB = new Account();

        accountA.send(accountB, AMOUNT_TEN);

        assertThat(accountA.consultLastWithdrawal()).isEqualTo(AMOUNT_TEN);
        assertThat(accountB.consultLastDeposit()).isEqualTo(AMOUNT_TEN);
    }

    // 3) Account statement (date, amount, balance)
    @Test
    public void given_account_with_deposit_10_when_get_statement_then_return_date_amount_balance() {
        Account account = new Account();

        account.deposit(AMOUNT_TEN);

        // TODO
        account.consultLastStatement();     // Amount
        account.calculateBalance();         // balance
        account.consultLastOperationDate(); // Date


    }
}
