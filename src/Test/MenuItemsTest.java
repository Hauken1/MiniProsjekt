package Test;
import static org.junit.Assert.*;

import javax.swing.JMenu;

import org.junit.*;

public class MenuItemsTest {

	@Test
	public void testReturnFileMenu() {
		JMenu fileMenu = new JMenu("FIL");
		assertNotNull(fileMenu);
	}

	@Test
	public void testReturnRedigerMenu() {
		JMenu redigerMenu = new JMenu("Rediger");
		assertNotNull(redigerMenu);
	}

	@Test
	public void testReturnHjelpMenu() {
		JMenu hjelpMenu = new JMenu("Hjelp");
		assertNotNull(hjelpMenu);
	}

}
