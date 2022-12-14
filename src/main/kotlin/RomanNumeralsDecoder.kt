class RomanNumeralsDecoder {

    fun decode(romanNumberString: String): Int {
        val decomposedRomanNumerals: List<RomanNumeral> = decomposeRomanNumerals(romanNumberString);
        return decomposedRomanNumerals.sumOf { romanNumeral -> romanNumeral.intValue }
    }

    private fun decomposeRomanNumerals(romanStringNumerals: String): List<RomanNumeral> {
        val romanNumeral: RomanNumeral? = findRomanIndividualNumber(romanStringNumerals)

        if (romanNumeral == null) {
            return emptyList();
        }

        val romanNumerals = mutableListOf(romanNumeral)
        val remainingPartOfString: String = romanStringNumerals.removePrefix(romanNumeral.stringValue)
        romanNumerals.addAll(decomposeRomanNumerals(remainingPartOfString))
        return romanNumerals;
    }

    private fun findRomanIndividualNumber(
        romanStringNumerals: String
    ): RomanNumeral? =
        RomanNumerals.ROMAN_NUMERALS_ORDERED_BY_INT_VALUE_DESC.firstOrNull { romanNumeral ->
            romanStringNumerals.startsWith(romanNumeral.stringValue)
        }

}