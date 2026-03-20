package org.example

object FlutterKeyParser {
    private val flutterKeyRegex = Regex("""ValueKey\s*\(\s*["'](.*?)["']\s*\)""")

    fun parseKeys(text: String): List<String> {
      val keys = mutableListOf<String>()

        flutterKeyRegex.findAll(text).forEach {
            keys.add(it.groupValues[1])
        }

        return keys
    }
}