package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.interviews.InterviewQuestions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.interviews.DateRole;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
class InterviewQuestionsTests {

	private static final LocalDate DATE1 = LocalDate.of(2019, 12, 31);
	private static final LocalDate DATE2 = LocalDate.of(2021, 10, 30);
	private static final LocalDate DATE3 = LocalDate.of(2021, 12, 31);
	private static final LocalDate DATE4 = LocalDate.of(2024, 1, 1);
	private static final String ROLE1 = "Developer";
	private static final String ROLE2 = "Senior Developer";
	private static final String ROLE3 = "Manager";
	@Test
	void displayOccurrencesTest() {
		String[] strings = {"b", "a","bb", "aa", "lmn", "aa", "lmn", "lmn", "bb"};
		displayOccurrences(strings);
		//Should be displayed out the following:
		/*
		 * lmn => 3
		 * aa => 2
		 * a => 1
		 * b => 1
		 */
	}
	@Test
	void displayOccurrencesSteamTest() {
		String[] strings = {"b", "a","bb", "aa", "lmn", "aa", "lmn", "lmn", "bb"};
		displayOccurrencesStream(strings);
		//Should be displayed out the following:
		/*
		 * lmn => 3
		 * aa => 2
		 * a => 1
		 * b => 1
		 */
	}
	@Test
	void isSum2Test() {
		int [] array = {-10, 2, 40, -30};
		assertTrue(isSum2(array, 30));
		assertFalse(isSum2(array, 32));
	}
	@Test
	void maxPositiveWithNegativeTest() {
		int[] array1 = {200, 10, -10, 1, 2, 3, -3, -200};
		int [] array2 = {-200, -200, 100, 10, 10};
		int[] array3 = {-200, 10, -10, 1, 2, 3, -3, 200};
		assertEquals(200, getMaxWithNegativePresentation(array1));
		assertEquals(-1, getMaxWithNegativePresentation(array2));
		assertEquals(200, getMaxWithNegativePresentation(array3));
	}
	@Test
	@Disabled
	void evenOddGroup() {
		List<Integer> list = List.of(10, -3, 22, 41, 56, 7);
		Map<String, List<Integer>> groupingMap = 
		list.stream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
		System.out.println(groupingMap);
			
		
	}
	@Test
	@Disabled
	void evenOddCounts() {
		List<Integer> list = List.of(10, -3, 22, 41, 56, 7, 3);
		Map<String, Long> groupingMap = 
				list.stream().collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd",
						Collectors.counting()));
		System.out.println(groupingMap);
	}
	@Test
	void getSquaresMapTest() {
		Integer[]numbers = {20, 10, -2, 5, 7, -2};
		Map<Integer, Integer> actualMap = getMapSquares(List.of(numbers));
		Integer[] expectedValues = {400, 100, 4, 25, 49};
		Integer[] actualValues = actualMap.values().toArray(Integer[]::new);
		assertArrayEquals(expectedValues, actualValues);
	}
	@Test
	void isAnagramTest() {
		String word = "hello";
		assertTrue(isAnagram(word, "olleh"));
		assertTrue(isAnagram(word, "elloh"));
		assertTrue(isAnagram(word, "hleol"));
		assertFalse(isAnagram(word, word));
		assertFalse(isAnagram(word, "olle"));
		assertFalse(isAnagram(word, "ollhh"));
		assertFalse(isAnagram(word, "olehd"));
	}
	@Test
	void datesRolesAssignmentTest() {
		List<DateRole> history =
				List.of(new DateRole(LocalDate.of(2020, 1, 1), ROLE1),
						new DateRole(LocalDate.of(2021, 1, 1), ROLE2),
						new DateRole(LocalDate.of(2022, 1, 1), ROLE3));
		List<LocalDate> dates = List.of(DATE1,
				DATE2, DATE3,
				DATE4);
		List<DateRole> expected =
				List.of(
						new DateRole(DATE1, null), 
						new DateRole(DATE2,ROLE2),
						new DateRole(DATE3, ROLE2),
						new DateRole(DATE4, ROLE3));
		assertIterableEquals(expected, assignRoleDates(history, dates));
	}

	@Test
	void displayDigitsStatisticsTest() {
		displayDigitsStatistics();
	}

}
