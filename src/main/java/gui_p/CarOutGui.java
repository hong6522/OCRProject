package gui_p;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarOutGui implements ActionListener{
	static CarOutGui me = null;
	public static CarOutGui getInstance(){
		
        if (me == null)
        {
            me = new CarOutGui();
        }
        return me;
    }
	
	public JLabel signLabel;
	public JTextField inputField;
	public JFrame frame;

    private CarOutGui() {
    	
        frame = new JFrame("출차");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(680,400,300,200);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 150));
       
        panel.setBackground(Color.BLACK);
        
        //signLabel = new JLabel(txt+" 입차 하셨습니다.");
        signLabel = new JLabel("",SwingConstants.CENTER);
        signLabel.setFont(new Font("kor", Font.BOLD, 30));
        signLabel.setForeground(Color.RED);
        inputField = new JTextField(20);
        
        
        
        
        panel.add(signLabel);
       
        
        //panel.remove(signLabel);
        
        frame.getContentPane().add(panel);
       
        frame.setSize(600, 400);
        
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == inputField) {
            String text = inputField.getText();
            signLabel.setText(text);
            inputField.setText("");
        }
    }
    
    public static void main(String[] args) {
        CarOutGui carOut = CarOutGui.getInstance();
        System.out.println(carOut);
    }

}
