package at.cnoize.kotlin.playground.anagram

import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test
import java.io.File
import org.hamcrest.CoreMatchers.`is` as Is

val wordListFileLocation = "resources//wordlist.txt"
val wordList = getWordListFromFile(wordListFileLocation)
val tinyWordListFileLocation = "resources//wordlist.tiny.txt"
val tinyWordList = getWordListFromFile(tinyWordListFileLocation)
val tinyAnagramsFileLocation = "resources//wordlist.tiny.anagrams.txt"
val tinyAnagrams = File(tinyAnagramsFileLocation).readLines().map { it.split(' ').toSet() }

internal class AnagramTest {

    @Test
    fun getWordListFromFileTest() {
        assertThat(wordList, Is(not(emptyList())))
        assertThat(tinyWordList, Is(not(emptyList())))
    }

    @Test
    fun getAnagramsFromWordlistTest() {
        val anagrams = getAnagramsFromWordlist(wordList)
        assertThat(anagrams, Is(not(emptyList())))
    }

    @Test
    fun getAnagramsFromWordListWithTinyListTest() {
        val anagrams = getAnagramsFromWordlist(tinyWordList)
        assertThat(anagrams, Is(not(emptyList())))
        assertThat(anagrams, containsInAnyOrder(*tinyAnagrams.toTypedArray()))
    }
}