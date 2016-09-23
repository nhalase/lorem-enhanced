package lorem;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.StringEndsWith.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.nhalase.lorem.Lorem;
import com.github.nhalase.lorem.LoremIpsum;

/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2015 Miguel De Anda
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * @author mdeanda
 * @author nhalase
 *
 * Copyright for portions of project lorem-enhanced are held by mdeanda, 2015 as part of project lorem.
 * All other copyright for project lorem-enhanced are held by Nicholas J Halase, 2016.
 *
 */
public class LoremTest {

	private static final int LOOP_TIMES = 5000;
	private Lorem lorem;

	@Before
	public void init() {
		lorem = LoremIpsum.getInstance();
	}

	private void notBlank(String s) {
		assertNotNull(s);
		assertNotEquals("", s.trim());
	}

	@Test
	public void testCity() {
		String s = lorem.getCity();
		notBlank(s);
	}

	@Test
	public void testCountry() {
		String s = lorem.getCountry();
		notBlank(s);
	}

	@Test
	public void testEmail() {
		for (int i = 0; i < LOOP_TIMES; i++) {
			String s = lorem.getEmail();
			notBlank(s);
			assertFalse(s, s.contains(" "));
		}
	}

	@Test
	public void testEmailSuffix() {
		for (int i = 0; i < LOOP_TIMES; i++) {
			String s = lorem.getEmail("school.edu");
			notBlank(s);
			assertFalse(s, s.contains(" "));
			assertTrue(endsWith("@school.edu").matches(s));
		}
	}

	@Test
	public void testNameMale() {
		String s = lorem.getNameMale();
		notBlank(s);
	}

	@Test
	public void testNameFemale() {
		String s = lorem.getNameFemale();
		notBlank(s);
	}

	@Test
	public void testParagraphs() {
		String p1 = lorem.getParagraphs(3, 5);
		notBlank(p1);

		String p2 = lorem.getParagraphs(6, 8);
		notBlank(p2);

		assertNotEquals(p1, p2);
	}

	@Test
	public void testState() {
		String s = lorem.getStateAbbr();
		notBlank(s);

		s = lorem.getStateFull();
		notBlank(s);
	}

	@Test
	public void testWords() {
		String words0 = lorem.getWords(2);
		assertNotNull(words0);
		assertNotEquals("", words0.trim());

		String words1 = lorem.getWords(4, 5);
		assertNotNull(words1);
		assertNotEquals("", words1.trim());
		String[] wordsplit = words1.split(" ");
		assertNotNull(wordsplit);
		assertTrue(wordsplit.length >= 4);
		assertTrue(wordsplit.length <= 4);

		assertNotEquals(words0, words1);
	}

	@Test
	public void testZip() {
		String s = lorem.getZipCode();
		notBlank(s);
	}

	@Test
	public void testUniversityName() {
		String s = lorem.getUniversityName();
		notBlank(s);
	}

	@Test
	public void testSchoolName() {
		String s = lorem.getSchoolName();
		notBlank(s);
	}

	@Test
	public void testCollegeName() {
		String s = lorem.getCollegeName();
		notBlank(s);
	}

	@Test
	public void testDepartmentName() {
		String s = lorem.getDepartmentName();
		notBlank(s);
	}

	@Test
	public void testAdjective() {
		String s = lorem.getAdjective();
		notBlank(s);
	}

	@Test
	public void testNoun() {
		String s = lorem.getNoun();
		notBlank(s);
	}

	@Test
	public void testPossibleAdjectives() {
		Set<String> result = new HashSet<>(lorem.getPossibleAdjectives());
		assertEquals(139, result.size());
	}

	@Test
	public void testPossibleNouns() {
		Set<String> result = new HashSet<>(lorem.getPossibleNouns());
		assertEquals(483, result.size());
	}

	@Test
	public void testPossibleAdjectiveNouns() {
		Set<String> adjectives = new HashSet<>(lorem.getPossibleAdjectives());
		Set<String> nouns = new HashSet<>(lorem.getPossibleNouns());
		Set<String> result = new HashSet<>();
		result.addAll(adjectives);
		result.addAll(nouns);
		assertEquals(622, result.size());
		assertEquals(67137, adjectives.size() * nouns.size());
	}

	@Test
	public void testPossibleFemaleFirstNames() {
		Set<String> result = new HashSet<>(lorem.getPossibleFemaleFirstNames());
		assertEquals(1000, result.size());
	}

	@Test
	public void testPossibleMaleFirstNames() {
		Set<String> result = new HashSet<>(lorem.getPossibleMaleFirstNames());
		assertEquals(899, result.size());
	}

	@Test
	public void testPossibleLastNames() {
		Set<String> result = new HashSet<>(lorem.getPossibleLastNames());
		assertEquals(999, result.size());
	}

	@Test
	public void testPossibleNames() {
		Set<String> femaleFirstNames = new HashSet<>(lorem.getPossibleFemaleFirstNames());
		Set<String> maleFirstNames = new HashSet<>(lorem.getPossibleMaleFirstNames());
		Set<String> firstNames = new HashSet<>();
		firstNames.addAll(femaleFirstNames);
		firstNames.addAll(maleFirstNames);
		assertEquals(1899, firstNames.size());
		Set<String> lastNames = new HashSet<>(lorem.getPossibleLastNames());
		Set<String> result = new HashSet<>(firstNames);
		result.addAll(lastNames);
		assertEquals(1897101, firstNames.size() * lastNames.size());
	}

}
