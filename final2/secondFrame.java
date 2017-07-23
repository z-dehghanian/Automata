
package final2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author zahraDehghanian
 */
public class secondFrame extends JFrame {

    private JLabel h;
    private JButton m;
    private JTextField[][] texts;
    private JTextField firststate, finalstate;
    int im;

    public secondFrame(int i) {

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	getContentPane().setBackground(new Color(255, 255, 204));
	JPanel table = new JPanel();
	JPanel okff = new JPanel();
	JFrame a = this;
	this.im = i;
	firststate = new JTextField("firststate");
	finalstate = new JTextField("laststate");

	h = new JLabel("please intial your states ");
	texts = new JTextField[(i + 1)][(i + 1)];
	setSize(400, 400);
	setLocation(500, 400);
	h.setFont(new Font("Afra", Font.PLAIN, 30));
	this.add(h, BorderLayout.NORTH);
	table.setLayout(new GridLayout(i + 1, i + 1));
	for (int j = 0; j < i + 1; j++) {
	    for (int k = 0; k < i + 1; k++) {
		if (k == 0 && j == 0) {
		    texts[j][k] = new JTextField("     state");
		    texts[j][k].setEditable(false);
		    texts[j][k].setFont(new Font("Afra", Font.PLAIN, 20));
		    table.add(texts[j][k]);
		} else {

		    texts[j][k] = new JTextField();
		    if (j == 0 || k == 0) {
			texts[j][k].setText("      " + (j + k - 1));
			texts[j][k].setEditable(false);
			texts[j][k].setFont(new Font("Afra", Font.PLAIN, 15));

		    }

		    table.add(texts[j][k]);
		}
	    }
	}
	this.add(table, BorderLayout.CENTER);
	m = new JButton("OK");
	okff.add(firststate, BorderLayout.NORTH);
	okff.add(finalstate, BorderLayout.CENTER);
	okff.add(m, BorderLayout.SOUTH);
	this.add(okff, BorderLayout.SOUTH);
	m.setFont(new Font("Afra", Font.PLAIN, 20));
	m.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		FinalFrame finalFrame = new FinalFrame(new BackGroundCalculation(texts, im, firststate.getText(), finalstate.getText()));
		//a.setVisible(false);
		finalFrame.setVisible(true);

	    }
	}
	);
    }

}
