package hexagon;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShapeClicker extends JFrame implements ActionListener{

    JButton s, l, r;
    JTextField f;
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
        add(new ShapePanel(), BorderLayout.CENTER);
        JPanel bottom = new JPanel(new FlowLayout());
        add(bottom, BorderLayout.SOUTH);
        bottom.add(s = new JButton("Save"));
        bottom.add(l = new JButton("Left"));
        bottom.add(r = new JButton("Right"));
        bottom.add(f = new JTextField("55"));
        s.addActionListener(this);
        l.addActionListener(this);
        r.addActionListener(this);
        fills = loadList();
    }

	private ArrayList<Integer[]> loadList() {
		ArrayList<Integer[]> fills;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
			fills = (ArrayList<Integer[]>) ois.readObject();
			System.out.println("List loaded");

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			fills = new ArrayList<>();
		}
		
		return fills;
	}

	private void saveList() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))){
			oos.writeObject(fills);
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
		}
		f.setText( String.valueOf(i));
	}


}

