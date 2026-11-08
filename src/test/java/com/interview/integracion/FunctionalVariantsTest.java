package com.interview.integracion;

import com.interview.nivel02_intermedio.p07_greedy.BestTimeToBuyAndSellStock;
import com.interview.nivel01_basico.p04_mapas.FirstUniqueCharacter;
import com.interview.nivel02_intermedio.p06_agrupacion.GroupAnagrams;
import com.interview.nivel01_basico.p03_conjuntos.IntersectionOfTwoArrays;
import com.interview.nivel02_intermedio.p05_arboles.InvertBinaryTree;
import com.interview.nivel02_intermedio.p02_dospunteros.IsSubsequence;
import com.interview.nivel01_basico.p02_strings.LengthOfLastWord;
import com.interview.nivel01_basico.p02_strings.LongestCommonPrefix;
import com.interview.nivel02_intermedio.p08_ventanas.LongestSubstringWithoutRepeating;
import com.interview.nivel02_intermedio.p07_greedy.MajorityElement;
import com.interview.nivel02_intermedio.p02_dospunteros.MergeSortedArray;
import com.interview.nivel01_basico.p01_arrays.MissingNumber;
import com.interview.nivel02_intermedio.p02_dospunteros.MoveZeroes;
import com.interview.nivel02_intermedio.p02_dospunteros.RemoveDuplicatesFromSortedArray;
import com.interview.nivel02_intermedio.p04_listas.ReverseLinkedList;
import com.interview.nivel01_basico.p02_strings.ReverseString;
import com.interview.nivel02_intermedio.p02_dospunteros.ReverseWords;
import com.interview.nivel02_intermedio.p02_dospunteros.RotateArray;
import com.interview.nivel02_intermedio.p01_busqueda.StrStr;
import com.interview.nivel01_basico.p04_mapas.ValidAnagram;
import com.interview.nivel02_intermedio.p02_dospunteros.ValidPalindrome;
import com.interview.nivel02_intermedio.p02_dospunteros.ValidPalindromeII;
import com.interview.nivel02_intermedio.p03_pilas.ValidParentheses;
import com.interview.common.ListNode;
import com.interview.common.TreeNode;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FunctionalVariantsTest {
  @Test
  void findsIntersectionAndMajority() {
    int[] result = new IntersectionOfTwoArrays().intersectionFunctional(
        new int[] {1, 2, 2, 3}, new int[] {2, 2, 3, 4});
    Arrays.sort(result);
    assertArrayEquals(new int[] {2, 3}, result);
    assertEquals(2, new MajorityElement().majorityElementFunctional(new int[] {2, 1, 2}));
  }

  @Test
  void findsStockProfitIncludingDecliningPrices() {
    BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
    assertEquals(5, stock.maxProfitFunctional(new int[] {7, 1, 5, 3, 6, 4}));
    assertEquals(0, stock.maxProfitFunctional(new int[] {7, 6, 4, 3, 1}));
  }

  @Test
  void mergesSortedPrefixesAndFindsMissingNumber() {
    int[] nums = {1, 2, 3, 0, 0, 0};
    new MergeSortedArray().mergeFunctional(nums, 3, new int[] {2, 5, 6}, 3);
    assertArrayEquals(new int[] {1, 2, 2, 3, 5, 6}, nums);
    assertEquals(2, MissingNumber.missingNumberFunctional(new int[] {3, 0, 1}));
    assertEquals(3, MissingNumber.missingNumberFunctional(new int[] {0, 1, 2}));
  }

  @Test
  void movesZeroesAndCompactsSortedDuplicatesInPlace() {
    int[] nums = {0, 1, 0, 3, 12};
    new MoveZeroes().moveZeroesFunctional(nums);
    assertArrayEquals(new int[] {1, 3, 12, 0, 0}, nums);
    int[] sorted = {0, 0, 1, 1, 2};
    int length = new RemoveDuplicatesFromSortedArray().removeDuplicatesFunctional(sorted);
    assertEquals(3, length);
    assertArrayEquals(new int[] {0, 1, 2}, Arrays.copyOf(sorted, length));
  }

  @Test
  void rotatesRightWithLargeK() {
    int[] nums = {1, 2, 3, 4};
    new RotateArray().rotateFunctional(nums, 6);
    assertArrayEquals(new int[] {3, 4, 1, 2}, nums);
  }

  @Test
  void findsFirstUniqueCharacterAndCommonPrefix() {
    FirstUniqueCharacter unique = new FirstUniqueCharacter();
    assertEquals(2, unique.firstUniqCharFunctional("loveleetcode"));
    assertEquals(-1, unique.firstUniqCharFunctional("aabb"));
    LongestCommonPrefix prefix = new LongestCommonPrefix();
    assertEquals("fl", prefix.longestCommonPrefixFunctional(new String[] {"flower", "flow", "flight"}));
    assertEquals("", prefix.longestCommonPrefixFunctional(new String[] {"dog", "cat"}));
  }

  @Test
  void groupsAnagramsWithoutDependingOnGroupOrder() {
    Set<Set<String>> groups = new GroupAnagrams()
        .groupAnagramsFunctional(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})
        .stream().map(Set::copyOf).collect(Collectors.toSet());
    assertEquals(Set.of(Set.of("eat", "tea", "ate"), Set.of("tan", "nat"), Set.of("bat")), groups);
  }

  @Test
  void checksSubsequencesAndSubstringWindows() {
    IsSubsequence subsequence = new IsSubsequence();
    assertTrue(subsequence.isSubsequenceFunctional("abc", "ahbgdc"));
    assertFalse(subsequence.isSubsequenceFunctional("axc", "ahbgdc"));
    assertTrue(subsequence.isSubsequenceFunctional("", "abc"));
    LongestSubstringWithoutRepeating substring = new LongestSubstringWithoutRepeating();
    assertEquals(3, substring.lengthOfLongestSubstringFunctional("pwwkew"));
    assertEquals(0, substring.lengthOfLongestSubstringFunctional(""));
  }

  @Test
  void reversesCharactersAndWords() {
    char[] chars = "hello".toCharArray();
    new ReverseString().reverseStringFunctional(chars);
    assertArrayEquals("olleh".toCharArray(), chars);
    assertEquals("blue is sky the", new ReverseWords().reverseWordsFunctional("  the sky  is blue  "));
    assertEquals(4, new LengthOfLastWord().lengthOfLastWordFunctional(" fly me to the moon  "));
  }

  @Test
  void checksAnagramsAndPalindromes() {
    ValidAnagram anagram = new ValidAnagram();
    assertTrue(anagram.isAnagramFunctional("anagram", "nagaram"));
    assertFalse(anagram.isAnagramFunctional("rat", "car"));
    ValidPalindrome palindrome = new ValidPalindrome();
    assertTrue(palindrome.isPalindromeFunctional("A man, a plan, a canal: Panama"));
    assertFalse(palindrome.isPalindromeFunctional("race a car"));
    ValidPalindromeII removable = new ValidPalindromeII();
    assertTrue(removable.validPalindromeFunctional("abca"));
    assertFalse(removable.validPalindromeFunctional("abc"));
  }

  @Test
  void locatesFirstSubstringAndHandlesEmptyNeedle() {
    StrStr search = new StrStr();
    assertEquals(0, search.strStrFunctional("sadbutsad", "sad"));
    assertEquals(-1, search.strStrFunctional("abc", "abcd"));
    assertEquals(0, search.strStrFunctional("abc", ""));
  }

  @Test
  void validatesNestedParentheses() {
    ValidParentheses parentheses = new ValidParentheses();
    assertTrue(parentheses.isValidFunctional("({[]})"));
    assertFalse(parentheses.isValidFunctional("([)]"));
    assertFalse(parentheses.isValidFunctional("("));
    assertTrue(parentheses.isValidFunctional(""));
  }

  @Test
  void reversesLinkedListAndInvertsTree() {
    assertArrayEquals(new int[] {3, 2, 1}, ListNode.toArray(
        new ReverseLinkedList().reverseListFunctional(ListNode.of(1, 2, 3))));
    TreeNode original = TreeNode.of(4, 2, 7, 1, 3, 6, 9);
    TreeNode inverted = new InvertBinaryTree().invertTreeFunctional(original);
    assertEquals(7, inverted.left.val);
    assertEquals(2, inverted.right.val);
    assertEquals(9, inverted.left.left.val);
    assertEquals(1, inverted.right.right.val);
    assertEquals(2, original.left.val);
  }
}
