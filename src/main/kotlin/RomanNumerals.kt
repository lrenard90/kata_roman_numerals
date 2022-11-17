class RomanNumerals {

    companion object {
        private val ROMAN_UNITS: Map<String, Int> = mapOf(
            Pair("I", 1),
            Pair("II", 2),
            Pair("III", 3),
            Pair("IV", 4),
            Pair("V", 5),
            Pair("VI", 6),
            Pair("VII", 7),
            Pair("VIII", 8),
            Pair("IX", 9)
        )

        private val ROMAN_TENS: Map<String, Int> = mapOf(
            Pair("X", 10),
            Pair("XX", 20),
            Pair("XXX", 30),
            Pair("XL", 40),
            Pair("L", 50),
            Pair("LX", 60),
            Pair("LXX", 70),
            Pair("LXXX", 80),
            Pair("XC", 90)
        )

        private val ROMAN_HUNDREDS: Map<String, Int> = mapOf(
            Pair("C", 100),
            Pair("CC", 200),
            Pair("CCC", 300),
            Pair("CD", 400),
            Pair("D", 500),
            Pair("DC", 600),
            Pair("DCC", 700),
            Pair("DCCC", 800),
            Pair("CM", 900)
        )

        private val ROMAN_THOUSANDS: Map<String, Int> = mapOf(
            Pair("M", 1000),
            Pair("MM", 2000),
            Pair("MMM", 3000)
        )

        val ROMAN_NUMERALS_ORDERED_BY_VALUE_DESC: Map<String, Int> = (ROMAN_THOUSANDS + ROMAN_HUNDREDS + ROMAN_TENS + ROMAN_UNITS)
            .toSortedMap(reverseOrder());
    }

}
