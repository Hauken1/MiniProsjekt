package ObjectsForTest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class KomponentTest {

	@Test
	public void loadAndSaveTest() {
		TableModel dataModel = new TableModel();
		dataModel.append(new Komponent());
        
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            dataModel.saveToFile(oos);
            oos.flush();
            TableModel dataModel1 = new TableModel();
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
	
	@Test
    public void testConstructor() {
        TableModel dataModel = new TableModel();
        assertEquals(0, dataModel.getRowCount());
        assertEquals(9, dataModel.getColumnCount());
        assertEquals("Row", dataModel.getColumnName(3));
    }

    @Test
    public void testInsertData() {
    	TableModel dataModel = new TableModel();
        dataModel.append(new Komponent());
        assertEquals(1, dataModel.getRowCount());
    }

    @Test
    public void testGetValueAt() {
    	TableModel dataModel = new TableModel();
    	dataModel.append(new Komponent());
        
    	dataModel.setValueAt(2, 0, 0);
        
        assertEquals(2, dataModel.getValueAt(0, 0));
    }
}
