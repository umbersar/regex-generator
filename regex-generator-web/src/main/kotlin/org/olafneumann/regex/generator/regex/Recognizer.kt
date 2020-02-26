package org.olafneumann.regex.generator.regex

data class Recognizer(
    var name: String,
    var outputPattern: String,
    var description: String? = null,
    var searchPattern: String? = null,
    var active: Boolean = true
) {
    val searchRegex by lazy { Regex(searchPattern?.replace("%s", outputPattern) ?: "($outputPattern)") }
}