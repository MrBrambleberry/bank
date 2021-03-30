package com.Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class AccountTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void it_prints_expected_transactions_to_the_console() {

        Account account = new Account();
        TransactionDate td = mock(TransactionDate.class);
        when(td.getDate()).thenReturn("10/01/2012").thenReturn("13/01/2012").thenReturn("14/01/2012");
        account.setTransactionDate(td);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        account.printStatement();
        String[] consoleOutput = outputStreamCaptor.toString().split("\\r?\\n");
        assertEquals("Date || Amount || Balance", consoleOutput[0]);
        assertEquals("14/01/2012 || -500 || 2500", consoleOutput[1]);
        assertEquals("13/01/2012 || 2000 || 3000", consoleOutput[2]);
        assertEquals("10/01/2012 || 1000 || 1000", consoleOutput[3]);
    }
}
