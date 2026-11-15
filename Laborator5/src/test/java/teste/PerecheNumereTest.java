package teste;

import exercitiul2.PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PerecheNumereTest
{
    // Teste pentru sirul Fibonacci

    @Test
    void test1_Fibonacci()
    {
        PerecheNumere p = new PerecheNumere(0, 1);
        assertTrue(p.suntConsecutiveFibonacci());
    }

    @Test
    void test2_Fibonacci()
    {
        PerecheNumere p = new PerecheNumere(5, 8);
        assertTrue(p.suntConsecutiveFibonacci());
    }

    @Test
    void test3_Fibonacci()
    {
        PerecheNumere p = new PerecheNumere(2, 5);
        assertFalse(p.suntConsecutiveFibonacci());
    }

    // Teste pentru CMMMC

    @Test
    void test1_CMMMC()
    {
        PerecheNumere p = new PerecheNumere(4, 6);
        assertEquals(12, p.cmmmc());
    }

    @Test
    void test2_CMMMC()
    {
        PerecheNumere p = new PerecheNumere(5, 10);
        assertEquals(10, p.cmmmc());
    }

    @Test
    void test3_CMMMC()
    {
        PerecheNumere p = new PerecheNumere(3, 7);
        assertEquals(21, p.cmmmc());
    }

    // Teste pentru suma cifrelor

    @Test
    void test1_SumaCifrelor()
    {
        PerecheNumere p = new PerecheNumere(123, 321);
        assertTrue(p.auAceeasiSumaCifrelor());
    }

    @Test
    void test2_SumaCifrelor()
    {
        PerecheNumere p = new PerecheNumere(45, 54);
        assertTrue(p.auAceeasiSumaCifrelor());
    }

    @Test
    void test3_SumaCifrelor()
    {
        PerecheNumere p = new PerecheNumere(123, 456);
        assertFalse(p.auAceeasiSumaCifrelor());
    }

    // Teste pentru numarul cifrelor pare

    @Test
    void test1_CifrePare()
    {
        PerecheNumere p = new PerecheNumere(1234, 5678);
        assertTrue(p.auAcelasiNumarCifrePare());
    }

    @Test
    void test2_CifrePare()
    {
        PerecheNumere p = new PerecheNumere(123, 456);
        assertFalse(p.auAcelasiNumarCifrePare());
    }

    @Test
    void test3_CifrePare()
    {
        PerecheNumere p = new PerecheNumere(2468, 1357);
        assertFalse(p.auAcelasiNumarCifrePare());
    }
}
