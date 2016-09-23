package com.github.nhalase.lorem;

import java.util.List;

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
public interface Lorem {

	/**
	 * Generates a random city out of a pool of 145 unique combinations.
	 *
	 * @return a random city
	 */
	String getCity();

	/**
	 * Generates a random country out of a pool of 205 unique combinations.
	 *
	 * @return a random city
	 */
	String getCountry();

	/**
	 * Generates a random email out of a pool of {@link #getFirstName()}.{@link #getLastName()}@example.com combinations.
	 *
	 * @return a random email address
	 */
	String getEmail();

	/**
	 * Generates a random email out of a pool of {@link #getFirstName()}.{@link #getLastName()}@<i>suffix</i> combinations.
	 *
	 * @param suffix the domain (e.g., "school.edu")
	 * @return a random email address
	 */
	String getEmail(String suffix);

	/**
	 * Generates a random first name out of a pool of 1899 unique first names.
	 *
	 * @return a random first name
	 */
	String getFirstName();

	/**
	 * Generates a random first name out of a pool of 899 unique first names.
	 *
	 * @return a random first name
	 */
	String getFirstNameMale();

	/**
	 * Generates a random first name out of a pool of 1000 unique first names.
	 *
	 * @return a random first name
	 */
	String getFirstNameFemale();

	/**
	 * Generates a random last name out of a pool of 999 unique last names.
	 *
	 * @return a random last name
	 */
	String getLastName();

	/**
	 * Generates a random name out of a pool of 1,897,101 unique names using the format {@link #getFirstName()} {@link #getLastName()}.
	 *
	 * @return a random name
	 */
	String getName();

	/**
	 * Generates a random name out of a pool of 898,101 unique names using the format {@link #getFirstNameMale()} {@link #getLastName()}.
	 *
	 * @return a random name
	 */
	String getNameMale();

	/**
	 * Generates a random name out of a pool of 999,000 unique names using the format {@link #getFirstNameFemale()} {@link #getLastName()}.
	 *
	 * @return a random name
	 */
	String getNameFemale();

	String getTitle(int count);

	String getTitle(int min, int max);

	String getHtmlParagraphs(int min, int max);

	String getParagraphs(int min, int max);

	/**
	 * <p>Generates a random lorem ipsum URL.</p>
	 * <b>URL Formats:</b>
	 * <ul>
	 *     <li>https://www.google.com/#q={@link #getWords(int)}</li>
	 *     <li>http://www.bing.com/search?q={@link #getWords(int)}</li>
	 *     <li>https://search.yahoo.com/search?p={@link #getWords(int)}</li>
	 *     <li>https://duckduckgo.com/?q={@link #getWords(int)}</li>
	 * </ul>
	 *
	 * @return a random URL
	 */
	String getUrl();

	/**
	 * <p>Generates a random fictional university name out of a pool of 335,685 unique combinations.</p>
	 * <b>Name Formats:</b>
	 * <ul>
	 *     <li>University of {@link #getAdjective()} {@link #getNoun()}</li>
	 *     <li>{@link #getAdjective()} {@link #getNoun()} State University</li>
	 *     <li>{@link #getAdjective()} {@link #getNoun()} University</li>
	 *     <li>{@link #getAdjective()} {@link #getNoun()} County University</li>
	 *     <li>{@link #getAdjective()} {@link #getNoun()} Technical Institute</li>
	 * </ul>
	 *
	 *
	 * @return a random fictional university name
	 */
	String getUniversityName();

	/**
	 * <p>Generates a random fictional school name out of a pool of 134,274 unique combinations.</p>
	 * <b>Name Formats:</b>
	 * <ul>
	 *     <li>School of {@link #getAdjective()} {@link #getNoun()}</li>
	 *     <li>{@link #getAdjective()} {@link #getNoun()} School</li>
	 * </ul>
	 *
	 *
	 * @return a random fictional school name
	 */
	String getSchoolName();

	/**
	 * <p>Generates a random fictional college name out of a pool of 134,274 unique combinations.</p>
	 * <b>Name Formats:</b>
	 * <ul>
	 *     <li>College of {@link #getAdjective()} {@link #getNoun()}</li>
	 *     <li>{@link #getAdjective()} {@link #getNoun()} College</li>
	 * </ul>
	 *
	 *
	 * @return a random fictional college name
	 */
	String getCollegeName();

	/**
	 * <p>Generates a random fictional dniversity name out of a pool of 134,274 unique combinations.</p>
	 * <b>Name Formats:</b>
	 * <ul>
	 *     <li>Department of {@link #getAdjective()} {@link #getNoun()}</li>
	 *     <li>{@link #getAdjective()} {@link #getNoun()} Department</li>
	 * </ul>
	 *
	 * @return a random fictional department name
	 */
	String getDepartmentName();

	/**
	 * Generates a random adjective from a pool of 139 unique adjectives.
	 *
	 * @return a random adjective
	 */
	String getAdjective();

	/**
	 * Generates a random noun from a pool of 483 unique nouns.
	 *
	 * @return a random noun
	 */
	String getNoun();

	/**
	 * Generates a specified number of words from the famous Lorem Ipsum text.
	 *
	 * @param count the number of words to generate
	 * @return words
	 */
	String getWords(int count);

	/**
	 * Generates a specified number of words from the famous Lorem Ipsum text.
	 *
	 * @param min the min number of words to generate
	 * @param max the max number of words to generate
	 * @return words
	 */
	String getWords(int min, int max);

	/**
	 * Generates a random phone number in the format of: (###) ###-####
	 *
	 * @return a random, formatted phone number
	 */
	String getPhone();

	/**
	 * Generate a random state abbreviation.
	 *
	 * @return a state abbreviation
	 */
	String getStateAbbr();

	/**
	 * Generate a random state name.
	 *
	 * @return a state name
	 */
	String getStateFull();

	/**
	 * Generate a random 5-digit zip code.
	 *
	 * @return a 5-digit zip code
	 */
	String getZipCode();

	List<String> getPossibleAdjectives();

	List<String> getPossibleNouns();

	List<String> getPossibleMaleFirstNames();

	List<String> getPossibleFemaleFirstNames();

	List<String> getPossibleLastNames();

}
