package hexagon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShapeClicker extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JButton c, s, l, r, e;
	JButton[] bMat;
    JTextField f;
    ShapePanel shapePanel;
    Color[] material = {Color.decode("#f2ebcd"), Color.decode("#5b7c88"), Color.decode("#ca8b00"),
    					Color.decode("#65e7ee"), Color.decode("#d3b06d"), Color.decode("#f9d400"),
    					Color.decode("#bb3625"), Color.decode("#c038bc"), Color.decode("#c22574")};
    String[] mat = {"Mar","Sta","Dre","Kry","Zwo","Jed","Eli","Pyl","Kle"};
    int newField = 20;
    ArrayList<Integer[]> fills;
    final String PATH = "fillsList.obj";

    public ShapeClicker() {
    	initComponents();
    }

    public static void main(String[] args) {

        //create frame and components on EDT
        ShapeClicker frame = new ShapeClicker();
        frame.setTitle("Shape Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.pack();
        
    }

    private void initComponents() {
    	setLayout(new BorderLayout());
    	shapePanel = new ShapePanel();
        add(shapePanel, BorderLayout.CENTER);
        JPanel bottom = new JPanel(new FlowLayout());
        add(bottom, BorderLayout.SOUTH);
        bMat = new JButton[9];
        for (int i = 0; i < 9; i++) {
			bMat[i] = new JButton(String.valueOf(i));
			bMat[i].setBackground(material[i]);
			bMat[i].addActionListener(this);
			bottom.add(bMat[i]);
		}
        bottom.add(c = new JButton(mat[0]));
        bottom.add(e = new JButton("Edit"));
        bottom.add(s = new JButton("Save"));
        bottom.add(l = new JButton("Left"));
        bottom.add(r = new JButton("Right"));
        bottom.add(f = new JTextField("55"));
        c.setBackground(material[0]);
        shapePanel.setColorToFill(material[0]);
        c.addActionListener(this);
        s.addActionListener(this);
        l.addActionListener(this);
        r.addActionListener(this);
        shapePanel.setMap(loadList());
    }

	private MapList loadList() {
		MapList map;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
			map = (MapList) ois.readObject();
			System.out.println("List loaded");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			map = new MapList();
		}
		
		return map;
	}

	private void saveList() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))){
			oos.writeObject(shapePanel.getMap());
			System.out.println("Save");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int i = Integer.parseInt(f.getText());
		if (e.getSource() == s) {
			saveList();
		} else if (e.getSource() == l) {
			i--;
			if ( i < 0 )
				i = newField;
		} else if (e.getSource() == r) {
			i++;
			if ( i > newField )
				i = 0;
		} else if (e.getSource() == c) {
			int colorNr = Arrays.asList(mat).indexOf(c.getText());
			colorNr++;
			colorNr %= 9;
			c.setBackground(material[colorNr]);
			shapePanel.setColorToFill(material[colorNr]);
			c.setText(mat[colorNr]);
			//System.out.println(colorNr);
		} else if (Arrays.asList(bMat).contains(e.getSource())) {
			int cur = Arrays.asList(bMat).indexOf(e.getSource());
			c.setBackground(material[cur]);
			c.setText(mat[cur]);
		}
		f.setText( String.valueOf(i));
	}


}

