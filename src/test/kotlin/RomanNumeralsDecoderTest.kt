import RomanNumerals.Companion.ROMAN_NUMERALS_ORDERED_BY_VALUE_DESC
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RomanNumeralsDecoderTest {

    @Test
    fun basic() {
        assertEquals(0, decode(""))
        assertEquals(1, decode("I"))
        assertEquals(21, decode("XXI"))
        assertEquals(2008, decode("MMVIII"))
        assertEquals(1666, decode("MDCLXVI"))
    }

    @Test
    fun `should compute units`() {
        assertEquals(1, decode("I"))
        assertEquals(2, decode("II"))
        assertEquals(3, decode("III"))
        assertEquals(4, decode("IV"))
        assertEquals(5, decode("V"))
        assertEquals(6, decode("VI"))
        assertEquals(7, decode("VII"))
        assertEquals(8, decode("VIII"))
        assertEquals(9, decode("IX"))
    }

    @Test
    fun `should compute tens`() {
        assertEquals(10, decode("X"))
        assertEquals(20, decode("XX"))
        assertEquals(30, decode("XXX"))
        assertEquals(40, decode("XL"))
        assertEquals(50, decode("L"))
        assertEquals(60, decode("LX"))
        assertEquals(70, decode("LXX"))
        assertEquals(80, decode("LXXX"))
        assertEquals(90, decode("XC"))
    }

    @Test
    fun `should compute tens with units addition`() {
        assertEquals(15, decode("XV"))
        assertEquals(51, decode("LI"))
        assertEquals(28, decode("XXVIII"))
    }

    @Test
    fun `should compute tens with units substraction`() {
        assertEquals(19, decode("XIX"))
        assertEquals(99, decode("XCIX"))
    }

    @Test
    fun `should compute largest number possible`() {
        assertEquals(3999, decode("MMMCMXCIX"))
    }

    @Test
    fun `should compute hundreds`() {
        assertEquals(100, decode("C"))
        assertEquals(200, decode("CC"))
        assertEquals(300, decode("CCC"))
        assertEquals(400, decode("CD"))
        assertEquals(500, decode("D"))
        assertEquals(600, decode("DC"))
        assertEquals(700, decode("DCC"))
        assertEquals(800, decode("DCCC"))
        assertEquals(900, decode("CM"))
    }

    @Test
    fun `should compute thousands`() {
        assertEquals(1000, decode("M"))
        assertEquals(2000, decode("MM"))
        assertEquals(3000, decode("MMM"))
    }

    private fun decode(str: String): Int {
        return RomanNumeralsDecoder().decode(str);
    }

}