package Izard_Text_Analyzer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class Izard_Text_AnalyzerTest {

	@Test
	void test() {
		Izard_Text_Analyzer test = new Izard_Text_Analyzer();
		String output = test.processFile("test.txt");
		assertEquals("test : 15\n",output);
	}

}
