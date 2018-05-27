package at.cnoize.kotlin.playground.anagram

import java.io.File

fun getAnagramsFromWordlist(wordList: List<String>): List<Set<String>> {
    val anagrams = mutableMapOf<String, MutableSet<String>>()

    for (word in wordList) {
        anagrams.getOrPut(getNormalizedWord(word)) { mutableSetOf() } += word
    }

    val result = anagrams.values
            .map { it.distinctBy { it.toLowerCase().filter { it.isLetter() } } }
            .filter { it.size > 1 }
            .map { it.toSet() }
    return result
}

fun getWordListFromFile(wordlistFileLocation: String): List<String> {
    return File(wordlistFileLocation).readLines()
}

fun getNormalizedWord(word: String): String {
    return word
            .toLowerCase()
            .toCharArray()
            .filter { it.isLetter() }
            .sorted()
            .joinToString("")
}