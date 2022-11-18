class RomanNumerals {

    companion object {
        private val ROMAN_UNITS: List<RomanNumeral> = listOf(
            RomanNumeral("I", 1),
            RomanNumeral("II", 2),
            RomanNumeral("III", 3),
            RomanNumeral("IV", 4),
            RomanNumeral("V", 5),
            RomanNumeral("VI", 6),
            RomanNumeral("VII", 7),
            RomanNumeral("VIII", 8),
            RomanNumeral("IX", 9)
        )

        private val ROMAN_TENS: List<RomanNumeral> = listOf(
            RomanNumeral("X", 10),
            RomanNumeral("XX", 20),
            RomanNumeral("XXX", 30),
            RomanNumeral("XL", 40),
            RomanNumeral("L", 50),
            RomanNumeral("LX", 60),
            RomanNumeral("LXX", 70),
            RomanNumeral("LXXX", 80),
            RomanNumeral("XC", 90)
        )

        private val ROMAN_HUNDREDS: List<RomanNumeral> = listOf(
            RomanNumeral("C", 100),
            RomanNumeral("CC", 200),
            RomanNumeral("CCC", 300),
            RomanNumeral("CD", 400),
            RomanNumeral("D", 500),
            RomanNumeral("DC", 600),
            RomanNumeral("DCC", 700),
            RomanNumeral("DCCC", 800),
            RomanNumeral("CM", 900)
        )

        private val ROMAN_THOUSANDS: List<RomanNumeral> = listOf(
            RomanNumeral("M", 1000),
            RomanNumeral("MM", 2000),
            RomanNumeral("MMM", 3000)
        )

        val ROMAN_NUMERALS_ORDERED_BY_INT_VALUE_DESC: List<RomanNumeral> = (ROMAN_THOUSANDS + ROMAN_HUNDREDS + ROMAN_TENS + ROMAN_UNITS)
            .sortedByDescending { romanNumeral -> romanNumeral.intValue }
    }

}
