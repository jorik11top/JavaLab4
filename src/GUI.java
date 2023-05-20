import  java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
    private JButton up1 = new JButton("Up el1");
    private JTextField input = new JTextField("",5);
    private JLabel label = new JLabel("Input:");
    private JRadioButton radio1 = new JRadioButton("Select:");

    public GUI(){
        super("Elevator GUI");
        this.setBounds(100,100,400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,1,1,1));
        container.add(label);
        container.add(input);
        container.add(radio1);
        radio1.setSelected(true);


    }
}
