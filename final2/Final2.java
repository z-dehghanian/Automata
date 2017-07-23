package final2;

import javax.swing.UIManager;

public class Final2 {

    public static void main(String[] args) {
	try {
	    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (Exception ex) {
	    System.err.println(ex.getMessage());
	}

	FirstFrame a = new FirstFrame();
	a.setVisible(true);

    }

}
