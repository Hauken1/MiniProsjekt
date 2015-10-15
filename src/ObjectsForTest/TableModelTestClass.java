package ObjectsForTest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class TableModelTestClass {

	/**
	 * Saves and load and test stream of data with a Komponent object.
	 */
	@Test
	public void loadAndSaveTest() {
		TableModelTest dataModel = new TableModelTest();
		dataModel.append(new KomponentTest());
        
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            dataModel.saveToFile(oos);
            oos.flush();
            TableModelTest dataModel1 = new TableModelTest();
            ByteArrayInputStream bais = new ByteArrayInputStream(
                    baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            dataModel1.loadFromFile(ois);
            assertEquals("", dataModel1.getValueAt(0, 1));
            assertEquals(1, dataModel1.getValueAt(0, 5));
        } catch (Exception e) {
            fail(e.getMessage());
        }
	}
	
	/**
	 * Test of TableModel variables. 
	 */
	@Test
    public void testTableModel() {
        TableModelTest dataModel = new TableModelTest();
        assertEquals(0, dataModel.getRowCount());
        assertEquals(9, dataModel.getColumnCount());
        assertEquals("Row", dataModel.getColumnName(3));
    }

	/**
	 * Initialize constructor of komponent and checks that it gets added to the vector
	 */
    @Test
    public void testConstructor() {
    	TableModelTest dataModel = new TableModelTest();
        dataModel.append(new KomponentTest());
        assertEquals(1, dataModel.getRowCount());
    }

    /**
     * Make a new Komponent in the vector and sets the Komponent type and
     * checks that the correct type is set
     */
    @Test
    public void testGetValueAt() {
    	TableModelTest dataModel = new TableModelTest();
    	dataModel.append(new KomponentTest());
        
    	dataModel.setValueAt(2, 0, 0);
        
        assertEquals(2, dataModel.getValueAt(0, 0));
    }
}
