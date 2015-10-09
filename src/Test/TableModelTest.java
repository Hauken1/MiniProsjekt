package Test;
import static org.junit.Assert.*;

import org.junit.Test;

public class TableModelTest {

	private String[] columnNames = {
			"Type",
			"Variablenavn",
			"Tekst",
			"Rad",
			"Kolonne",
			"Rader",
			"Kolonner",
			"Utfylling",
			"Forankring"};
	
	@Test
	public void testGetColumnCount() {
		assertEquals(9, columnNames.length);
	}

}
