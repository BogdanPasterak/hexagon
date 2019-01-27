package hexagon;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShapeClicker extends JFrame implements ActionListener{

    JButton s, l, r;
    JTextField f;
    int newField = 20;

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
        bottom.add(s = new JButton("Save as..."));
        bottom.add(l = new JButton("Left"));
        bottom.add(r = new JButton("Right"));
        bottom.add(f = new JTextField("55"));
        s.addActionListener(this);
        l.addActionListener(this);
        r.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = Integer.parseInt(f.getText());
		if (e.getSource() == s) {
			i = 30;
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

