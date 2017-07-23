package final2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;

public class FinalFrame extends JFrame {

    BackGroundCalculation back;
    JButton pic, checkL, ommitL, checkS, Adjacent;

    FinalFrame(BackGroundCalculation cal) {
	back = cal;

	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(350, 400);
	setLocation(500, 400);
	getContentPane().setBackground(new Color(51, 102, 0));
	//JPanel table = new JPanel();
	// JFrame a = this ;

	JTextField z = new JTextField();
	//z.setEditable(false);
	z.setSize(80, 25);
	z.setLocation(135, 150);
	add(z);

	pic = new JButton("draw");
	pic.setSize(100, 30);
	pic.setLocation(125, 50);
	pic.setFont(new Font("Afra", Font.PLAIN, 20));
	pic.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		back.makePicture();

	    }
	}
	);
	add(pic);

	checkL = new JButton("loop?");
	checkL.setSize(100, 30);
	checkL.setLocation(125, 100);
	checkL.setFont(new Font("Afra", Font.PLAIN, 20));
	checkL.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		z.setText("" + back.checkLoop());

	    }
	}
	);
	add(checkL);

	ommitL = new JButton("delete");
	ommitL.setSize(100, 30);
	ommitL.setLocation(125, 200);
	ommitL.setFont(new Font("Afra", Font.PLAIN, 20));
	ommitL.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		back.removeLoop();
		//back.makePicture();

	    }
	}
	);
	add(ommitL);

	checkS = new JButton("string");
	checkS.setSize(100, 30);
	checkS.setLocation(125, 250);
	checkS.setFont(new Font("Afra", Font.PLAIN, 20));
	checkS.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		back.checkString();
		//back.makePicture();

	    }
	}
	);
	add(checkS);

	Adjacent = new JButton("adjacen");
	Adjacent.setSize(100, 30);
	Adjacent.setLocation(125, 300);
	Adjacent.setFont(new Font("Afra", Font.PLAIN, 20));
	Adjacent.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		back.showAdjacent();
		//back.makePicture();

	    }
	}
	);
	add(Adjacent);

    }

}
//
