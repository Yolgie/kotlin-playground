package at.cnoize.kotlin.playground.anagram

import java.io.File

fun getAnagramsFromWordlist(wordList: List<String>): List<Set<String>> {
    val anagrams = mutableMapOf<String, MutableSet<String>>()

    for (word in wordList) {
        val key = word.toLowerCase().toCharArray().sorted().toString()
        anagrams.getOrPut(key) { mutableSetOf() } += word
    }

    return anagrams.values.map { it.toSet() }
}

fun getWordListFromFile(wordlistFileLocation: String): List<String> {
    return File(wordlistFileLocation).readLines()
}