class RomanNumeralsDecoder {

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

    fun decode(romanNumberString: String): Int {
        val romanStringDecomposed: List<RomanIndividualNumber> = decomposeRomanNumerals(romanNumberString);
        return romanStringDecomposed.sumOf { romanIndividualNumber -> romanIndividualNumber.intValue }
    }

    private fun decomposeRomanNumerals(romanNumberString: String): List<RomanIndividualNumber> {
        val romanNumberPart: RomanIndividualNumber? = findRomanIndividualNumber(romanNumberString)

        if (romanNumberPart == null) {
            return emptyList();
        }

        val romanNumberParts = mutableListOf(romanNumberPart)
        val remainingPartOfString: String = romanNumberString.removePrefix(romanNumberPart.stringValue)
        romanNumberParts.addAll(decomposeRomanNumerals(remainingPartOfString))
        return romanNumberParts;
    }

    private fun findRomanIndividualNumber(romanNumberString: String): RomanIndividualNumber? {
        val romanThousandsPart: RomanIndividualNumber? =
            findRomanIndividualNumberOfCategory(romanNumberString, ROMAN_THOUSANDS)
        if (romanThousandsPart != null) {
            return romanThousandsPart;
        }

        val romanHundredsPart: RomanIndividualNumber? =
            findRomanIndividualNumberOfCategory(romanNumberString, ROMAN_HUNDREDS)
        if (romanHundredsPart != null) {
            return romanHundredsPart;
        }

        val romanTensPart: RomanIndividualNumber? = findRomanIndividualNumberOfCategory(romanNumberString, ROMAN_TENS)
        if (romanTensPart != null) {
            return romanTensPart;
        }
        val romanUnitsPart: RomanIndividualNumber? = findRomanIndividualNumberOfCategory(romanNumberString, ROMAN_UNITS)
        if (romanUnitsPart != null) {
            return romanUnitsPart;
        }

        return null;
    }

    private fun findRomanIndividualNumberOfCategory(
        romanNumberString: String,
        romanAvailableParts: Map<String, Int>
    ): RomanIndividualNumber? =
        romanAvailableParts
            .toSortedMap(reverseOrder())
            .filter { stringIntEntry -> romanNumberString.startsWith(stringIntEntry.key) }
            .map { stringIntEntry -> RomanIndividualNumber(stringIntEntry.key, stringIntEntry.value) }
            .firstOrNull()

}