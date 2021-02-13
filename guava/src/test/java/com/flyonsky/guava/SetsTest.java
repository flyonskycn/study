package com.flyonsky.guava;

import com.flyonsky.JsonBaseTest;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * @author luowengang
 * @date 2020/9/24 23:19
 */
public class SetsTest extends JsonBaseTest {

    @Test
    public void testSets(){
        Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
        Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");

        // contains "two", "three", "seven"
        Sets.SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength);
        printString(intersection);

        // contains "one","two","three","five","six","seven","eight"
        Sets.SetView<String> union = Sets.union(primes, wordsWithPrimeLength);
        printString(union);

        // contains "one","six","eight"
        Sets.SetView<String> difference = Sets.difference(wordsWithPrimeLength, primes);
        printString(difference);

        // "one","six","eight","five"
        Sets.SetView<String> symmetricDifference = Sets.symmetricDifference(wordsWithPrimeLength, primes);
        printString(symmetricDifference);

        Set<String> animals = ImmutableSet.of("gerbil", "hamster");
        Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");

        Set<List<String>> product = Sets.cartesianProduct(animals, fruits);
        // {{"gerbil", "apple"}, {"gerbil", "orange"}, {"gerbil", "banana"},
        //  {"hamster", "apple"}, {"hamster", "orange"}, {"hamster", "banana"}}

        printString(product);

        Set<Set<String>> animalSets = Sets.powerSet(animals);
        // {{}, {"gerbil"}, {"hamster"}, {"gerbil", "hamster"}}

        printString(animalSets);
    }
}
