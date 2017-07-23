package final2;

import GraphViz.GraphDrawer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BackGroundCalculation extends JFrame {

    private JTextField[][] texts1;
    private String firststate1, drawableAns = "";
    private JTextArea textArea;
    int im1, temp2, repeat;
    int[][] myTable;
    boolean[] finalStates;

    public BackGroundCalculation(JTextField[][] texts, int im, String firststate, String finalstate) {

	setSize(200, 200);
	setLocation(600, 500);

	finalStates = new boolean[im];
	for (int i = 0; i < im; i++) {
	    finalStates[i] = false;
	}
	String tmp[] = finalstate.split(",");
	for (int i = 0; i < tmp.length; i++) {
	    finalStates[Integer.parseInt(tmp[i])] = true;
	}
	repeat = 0;
	texts1 = texts;
	firststate1 = firststate;

	textArea = new JTextArea();
	textArea.setSize(100, 100);
	add(textArea);

	im1 = im;
	myTable = new int[im1][128];
	for (int k = 0; k < im1; k++) {
	    for (int i = 0; i < 128; i++) {
		myTable[k][i] = -1;
	    }
	}
	String[] temp;
	for (int i = 1; i <= im1; i++) {
	    for (int j = 1; j <= im1; j++) {
		temp = texts[i][j].getText().split(",");
		for (int k = 0; k < temp.length; k++) {
		    temp2 = (int) temp[k].charAt(0);
		    if (temp2 != 45) {
			myTable[i - 1][temp2] = j - 1;
		    }
		}

	    }

	}
    }

    public void showAdjacent() {
	JTextArea textArea1 = new JTextArea("");
	JFrame temp = new JFrame();
	temp.setVisible(true);
	temp.setSize(350, 300);
	temp.setLocation(500, 600);
	for (int i = 0; i < im1; i++) {

	    textArea1.append("state " + i + ": ");

	    for (int j = 0; j < 128; j++) {

		if (j == 45) {
		    continue;
		}

		if (myTable[i][j] > -1) {

		    textArea1.append("(" + myTable[i][j] + "," + (char) j + ") ");
		}
	    }

	    textArea1.append("\n");
	}
	temp.add(textArea1);
    }

    public void checkString() {

	JTextField m;
	JButton ok;
	JLabel h, z;
	JFrame here;

	here = new JFrame();
	here.setVisible(true);
	here.setLayout(null);
	here.setSize(250, 200);
	here.setLocation(520, 600);
	h = new JLabel("enter your desired String ");
	h.setSize(150, 20);
	h.setLocation(30, 30);
	here.add(h);
	z = new JLabel("");
	z.setSize(350, 20);
	z.setLocation(30, 100);
	here.add(z);

	m = new JTextField();
	m.setSize(80, 25);
	m.setLocation(40, 70);
	here.add(m);

	ok = new JButton("OK");
	ok.setSize(60, 25);
	ok.setLocation(125, 70);
	ok.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		if (m.getText() != null) {
		    z.setText("validity of String is : " + isValid(m.getText()));
		}

	    }
	}
	);
	here.add(ok);

    }

    private boolean isValid(String inp) {
	int index;
	String tmp[] = inp.split(",");
	int currentState = Integer.parseInt(firststate1);

	for (String s : tmp) {

	    index = (int) s.charAt(0);
	    currentState = myTable[currentState][index];

	    if (currentState == -1) {
		return false;
	    }
	}
	return finalStates[currentState];

    }

    public void makePicture() {
	repeat++;
	drawableAns = "";
	for (int i = 0; i < im1; i++) {

	    for (int j = 0; j < 128; j++) {
		if (j == 45) {
		    continue;
		}

		if (myTable[i][j] > -1) {

		    drawableAns = drawableAns + i + "->" + myTable[i][j] + " [ label =" + (char) j + " ]";

		}

	    }

	}
	for (int q = 0; q < im1; q++) {
	    if (finalStates[q]) {
		drawableAns = drawableAns + q + "[shape=doublecircle]";
	    }
	}

	GraphDrawer pic = new GraphDrawer();
	pic.draw("yourGraph" + repeat + ".", drawableAns);
	JFrame temp = new JFrame();
	temp.setVisible(true);
	temp.setSize(250, 400);
	temp.setLocation(800, 650);
	JLabel h;
	h = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("yourGraph" + repeat + ".png")));
	temp.add(h);

  // drawableAns = drawableAns + "s0"+ "->" + myTable[i][j] + " [ label =" + (char) j + " ]";
	  


    }

    public void removeLoop() {

	int seenStates[] = new int[im1];
	for (int i = 0; i < im1; i++) {
	    seenStates[i] = 0;
	}

	for (int k = 0; k < im1; k++) {

	    int currentState;
	    currentState = k;

	    if (seenStates[k] == 2) {
		continue;
	    }
	    for (int i = 0; i < im1; i++) {

		seenStates[i] = 0;
	    }

	    Stack s = new Stack(1000);

	    while (true) {
		seenStates[currentState] = 2;
		for (int i = 0; i < 128; i++) {

		    if (myTable[currentState][i] > -1) {

			if (myTable[currentState][i] == k) {

			    myTable[currentState][i] = -1;
			} else if (seenStates[myTable[currentState][i]] == 0) {
			    s.push(myTable[currentState][i]);
			}

		    }

		}

		if (s.isEmpty()) {
		    break;
		}
		currentState = s.pop();

	    }

	}
    }

    public boolean checkLoop() {

	int seenStates[] = new int[im1];

	for (int i = 0; i < im1; i++) {
	    seenStates[i] = 0;
	}

	for (int k = 0; k < im1; k++) {

	    int currentState;
	    currentState = k;

	    if (seenStates[k] == 2) {
		continue;
	    }
	    for (int i = 0; i < im1; i++) {

		seenStates[i] = 0;
	    }
	    Stack s = new Stack(1000);

	    while (true) {
		seenStates[currentState] = 2;
		for (int i = 0; i < 128; i++) {

		    if (myTable[currentState][i] > -1) {
			if (myTable[currentState][i] == k) {

			    return true;
			} else if (seenStates[myTable[currentState][i]] == 0) {
			    s.push(myTable[currentState][i]);
			}

		    }

		}

		if (s.isEmpty()) {
		    break;
		}
		currentState = s.pop();

	    }

	}
	return false;
    }
}
