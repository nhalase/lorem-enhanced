package org.nhalase.lorem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
 * All other copyright for project lorem-enhanced are held by Nicholas Halase, 2016.
 *
 */
public class LoremIpsum implements Lorem {

	/*
	 * this command was useful:
	 * 
	 * cat lorem.txt | sed -e 's/[,;.]//g' | sed -e 's/ /\n/g' | sed -e \
	 * 'y/ABCDEFGHIJKLMNOPQRSTUVWXYZ/abcdefghijklmnopqrstuvwxyz/' | sort | \
	 * uniq > lorem.txt.2
	 */
	private static LoremIpsum instance;

	private List<String> words = new ArrayList<>();
	private Random random = null;
	private List<String> maleNames;
	private List<String> femaleNames;
	private List<String> surnames;
	private List<String> firstNames;
	private List<String> stateAbbr;
	private List<String> stateFull;
	private List<String> cities;
	private List<String> countries;
	private List<String> adjectives;
	private List<String> nouns;

	private String[] COLLEGE_NAME_TOKENS = new String[]{"College of %s",
		"%s College"};
	private String[] DEPARTMENT_NAME_TOKENS = new String[]{"Department of %s",
		"%s Department"};
	private String[] SCHOOL_NAME_TOKENS = new String[]{"School of %s",
		"%s School"};
	private String[] UNIVERSITY_NAME_TOKENS = new String[]{"University of %s",
		"%s State University",
		"%s University",
		"%s County University",
		"%s Technical Institute"};
	private String[] URL_HOSTS = new String[]{"https://www.google.com/#q=%s",
		"http://www.bing.com/search?q=%s",
		"https://search.yahoo.com/search?p=%s",
		"https://duckduckgo.com/?q=%s"};

	public static synchronized LoremIpsum getInstance() {
		if (instance == null) {
			instance = new LoremIpsum(null);
		}
		return instance;
	}

	public LoremIpsum() {
		this(null);
	}

	public LoremIpsum(Long seed) {
		if (seed == null) {
			this.random = new Random();
		}
		else {
			this.random = new Random(seed);
		}
		words = readLines("lorem.txt");
		maleNames = readLines("male_names.txt");
		femaleNames = readLines("female_names.txt");
		surnames = readLines("surnames.txt");
		firstNames = new ArrayList<>();
		firstNames.addAll(maleNames);
		firstNames.addAll(femaleNames);

		cities = readLines("cities.txt");
		stateAbbr = readLines("state_abbr.txt");
		stateFull = readLines("state_full.txt");
		countries = readLines("countries.txt");
		adjectives = readLines("adjectives.txt");
		nouns = readLines("nouns.txt");
	}

	private List<String> readLines(String file) {
		List<String> ret = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(getClass()
				.getResourceAsStream(file), "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				ret.add(line.trim());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getCity()
	 */
	@Override
	public String getCity() {
		return getRandom(cities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getCountry()
	 */
	@Override
	public String getCountry() {
		return getRandom(countries);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getEmail()
	 */
	@Override
	public String getEmail() {
		String email = getFirstName().toLowerCase() +
			"." +
			getLastName().toLowerCase() +
			"@example.com";

		return email.replace(' ', '.');
	}

	@Override
	public String getEmail(String suffix) {
		String email = getFirstName().toLowerCase() +
			"." +
			getLastName().toLowerCase() + "@" + suffix;

		return email.replace(' ', '.');
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return getRandom(firstNames);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getFirstNameMale()
	 */
	@Override
	public String getFirstNameMale() {
		return getRandom(maleNames);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getFirstNameFemale()
	 */
	@Override
	public String getFirstNameFemale() {
		return getRandom(femaleNames);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getLastName()
	 */
	@Override
	public String getLastName() {
		return getRandom(surnames);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getName()
	 */
	@Override
	public String getName() {
		return getFirstName() + " " + getLastName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getNameMale()
	 */
	@Override
	public String getNameMale() {
		return getFirstNameMale() + " " + getLastName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getNameFemale()
	 */
	@Override
	public String getNameFemale() {
		return getFirstNameFemale() + " " + getLastName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getTitle(int)
	 */
	@Override
	public String getTitle(int count) {
		return getWords(count, count, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getTitle(int, int)
	 */
	@Override
	public String getTitle(int min, int max) {
		return getWords(min, max, true);
	}

	private int getCount(int min, int max) {
		if (min < 0) {
			min = 0;
		}
		if (max < min) {
			max = min;
		}
		return max != min ? random.nextInt(max - min) + min : min;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getHtmlParagraphs(int, int)
	 */
	@Override
	public String getHtmlParagraphs(int min, int max) {
		int count = getCount(min, max);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append("<p>");
			sb.append(getParagraphs(1, 1));
			sb.append("</p>");
		}
		return sb.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getParagraphs(int, int)
	 */
	@Override
	public String getParagraphs(int min, int max) {
		int count = getCount(min, max);
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < count; j++) {
			int sentences = random.nextInt(5) + 2; // 2 to 6
			for (int i = 0; i < sentences; i++) {
				String first = getWords(1, 1, false);
				first = first.substring(0, 1).toUpperCase()
					+ first.substring(1);
				sb.append(first);

				sb.append(getWords(2, 20, false));
				sb.append(".  ");
			}
			sb.append("\n");
		}
		return sb.toString().trim();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getUrl()
	 */
	@Override
	public String getUrl() {
		StringBuilder sb = new StringBuilder();
		int hostId = random.nextInt(URL_HOSTS.length);
		String host = String.format(URL_HOSTS[hostId], getWords(1));
		sb.append(host);
		return sb.toString();
	}

	private String getAdjectiveNoun() {
		return getAdjective() + " " + getNoun();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getUrl()
	 */
	@Override
	public String getUniversityName() {
		return getUniversityName(getAdjectiveNoun());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getSchoolName()
	 */
	@Override
	public String getSchoolName() {
		return getSchoolName(getAdjectiveNoun());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getCollegeName()
	 */
	@Override
	public String getCollegeName() {
		return getCollegeName(getAdjectiveNoun());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getDepartmentName()
	 */
	@Override
	public String getDepartmentName() {
		return getDepartmentName(getAdjectiveNoun());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getAdjective()
	 */
	@Override
	public String getAdjective() {
		String s = getRandom(adjectives);
		return Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getNoun()
	 */
	@Override
	public String getNoun() {
		String s = getRandom(nouns);
		return Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
	}

	private String getUniversityName(String universityName) {
		StringBuilder sb = new StringBuilder();
		int tokenId = random.nextInt(UNIVERSITY_NAME_TOKENS.length);
		String name = String.format(UNIVERSITY_NAME_TOKENS[tokenId], universityName);
		sb.append(name);
		return sb.toString();
	}

	private String getCollegeName(String collegeName) {
		StringBuilder sb = new StringBuilder();
		int tokenId = random.nextInt(COLLEGE_NAME_TOKENS.length);
		String name = String.format(COLLEGE_NAME_TOKENS[tokenId], collegeName);
		sb.append(name);
		return sb.toString();
	}

	private String getDepartmentName(String departmentName) {
		StringBuilder sb = new StringBuilder();
		int tokenId = random.nextInt(DEPARTMENT_NAME_TOKENS.length);
		String name = String.format(DEPARTMENT_NAME_TOKENS[tokenId], departmentName);
		sb.append(name);
		return sb.toString();
	}

	private String getSchoolName(String schoolName) {
		StringBuilder sb = new StringBuilder();
		int tokenId = random.nextInt(SCHOOL_NAME_TOKENS.length);
		String name = String.format(SCHOOL_NAME_TOKENS[tokenId], schoolName);
		sb.append(name);
		return sb.toString();
	}

	private String getWords(int min, int max, boolean title) {
		int count = getCount(min, max);
		return getWords(count, title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getWords(int)
	 */
	@Override
	public String getWords(int count) {
		return getWords(count, count, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getWords(int, int)
	 */
	@Override
	public String getWords(int min, int max) {
		return getWords(min, max, false);
	}

	private String getWords(int count, boolean title) {
		StringBuilder sb = new StringBuilder();
		int size = words.size();
		int wordCount = 0;
		while (wordCount < count) {
			String word = words.get(random.nextInt(size));
			if (title) {
				if (wordCount == 0 || word.length() > 3) {
					word = word.substring(0, 1).toUpperCase()
						+ word.substring(1);
				}
			}
			sb.append(word);
			sb.append(" ");
			wordCount++;
		}
		return sb.toString().trim();
	}

	private String getRandom(List<String> list) {
		int size = list.size();
		return list.get(random.nextInt(size));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getPhone()
	 */
	@Override
	public String getPhone() {
		StringBuilder sb = new StringBuilder();

		sb.append("(");
		sb.append(random.nextInt(9) + 1);
		for (int i = 0; i < 2; i++) {
			sb.append(random.nextInt(10));
		}
		sb.append(") ");

		sb.append(random.nextInt(9) + 1);
		for (int i = 0; i < 2; i++) {
			sb.append(random.nextInt(10));
		}
		sb.append("-");

		for (int i = 0; i < 4; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getStateAbbr()
	 */
	@Override
	public String getStateAbbr() {
		return getRandom(stateAbbr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getStateFull()
	 */
	@Override
	public String getStateFull() {
		return getRandom(stateFull);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.nhalase.Lorem#getZipCode()
	 */
	@Override
	public String getZipCode() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getPossibleAdjectives()
	 */
	@Override
	public List<String> getPossibleAdjectives() {
		return adjectives;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getPossibleNouns()
	 */
	@Override
	public List<String> getPossibleNouns() {
		return nouns;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getPossibleMaleFirstNames()
	 */
	@Override
	public List<String> getPossibleMaleFirstNames() {
		return maleNames;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getPossibleFemaleFirstNames()
	 */
	@Override
	public List<String> getPossibleFemaleFirstNames() {
		return femaleNames;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.nhalase.Lorem#getPossibleLastNames()
	 */
	@Override
	public List<String> getPossibleLastNames() {
		return surnames;
	}

}
