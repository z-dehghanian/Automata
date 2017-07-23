package final2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FirstFrame extends JFrame {

    JTextField m;
    JButton ok;
    JLabel h;
    JFrame here;

    public FirstFrame() {

	here = this;
	getContentPane().setBackground(Color.CYAN);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	setSize(250, 200);
	setLocation(500, 600);
	h = new JLabel("enter number of vertex here");
	h.setSize(150, 20);
	h.setLocation(30, 30);
	add(h);

	m = new JTextField();
	m.setSize(80, 25);
	m.setLocation(40, 70);
	add(m);

	ok = new JButton("OK");
	ok.setSize(60, 25);
	ok.setLocation(125, 70);
	ok.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		int z = 0;
		if (m.getText() != null) {
		    z = Integer.parseInt(m.getText());
		}
		secondFrame za = new secondFrame(z);
		za.setVisible(true);
		//here.setVisible(false);

	    }
	}
	);
	add(ok);

    }

}
////t,t,g,t,c,a,a,a,c,a,c,a,c,a,g,a
////t,g,c,a,a,c,a,c,a,a,c
////t,g,c,a,a,a,a,a,c,a,c,a,a,g,t,t
////t,g,c,a,a,a,a,a,c,a,c,a,a,g,t,t,t,t,g,t,c,a,a,a,c,a,c,a,c,a,g,a
////a,c,a,c,a,g,a,c,a,c,a,g,a
////a,c,c,a,c,a,c,a,g,a,c,a,c,a,g,a
////a,b,b,a,b,a,a,b,b,a,b,b
////a,b,b,a,b,b,a,b,a,a,b,a,a,b,b,a,b,b,b
////a,b,a,b,b,b,a,a,b,b,a,b,b,b,a,a
////a,b,a,a,b,a,a,b,b,a,b,a,a,b,a,a,b,a,a,b,b
////b,a,a,b,a,a,b,a,a,b,b,a,b,b,a,,b,a,a,b,b
//
//
////a,b,a,b,a,b,b,b,b,a,b
////b,b,a,b,b,b,b,b,a,b,b,b,a,b,a,b,a,b,b,b,b,b,a,b,b,b
////b,a,a,b,b,b,b,a,b,b
////a,b,a,b,b,b,b,b,a,b,b,b,a,b,b,b,a,b
//
//
//a,b,b,a,a,b,b,a
//a,b,b,a,a,a,a,a
//a,b,b,a,a,b,a,b,a,b,b,a,a
//a,b,b,a,a,b,a,b,a,b,b,a,a,b,b,a,b,a,b,a,b
//a,a,a,a,a,a,a,a,a,a,a,a,a
//a,a,a,a,a,a,a,a,a,a,b,a,b,b,a,a,b,b,a,b


//a,a,a,a,a,a,a,a,b,b,a
//a,b,b,b,b,b,b,a
//b,a,a,a,a,a,a,b,b
//b,a,a,a,a,a,a,b,b,a,a,b,b,a
//b,a,a,b,b,b,b,b,b