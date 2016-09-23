package lorem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.nhalase.lorem.Lorem;
import org.nhalase.lorem.LoremIpsum;

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
public class LoremSeedTest {

	private Lorem lorem;

	@Before
	public void init() {
		lorem = new LoremIpsum(99L);
	}

	@Test
	public void testSeededPseudoRandom() {
		assertEquals("Atlantis", lorem.getCity());
		assertEquals("ignota mus", lorem.getWords(2));
		assertEquals("Suriname", lorem.getCountry());
		assertEquals("(424) 909-8919", lorem.getPhone());
	}

}
