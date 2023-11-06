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


public class Clear implements ActionListener{
	
	static Clear me = null;
	public static Clear getInstance(){
		
        if (me == null)
        {
            me = new Clear();
        }
        return me;
    }
	
	public JLabel signLabel;
    public JTextField inputField;
    public JFrame frame;

    public Clear() {
        frame = new JFrame("주차장 빈공간");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350,0,300,200);
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

       // signLabel.setText("나는기훈이");
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
    	
        Clear carIn = Clear.getInstance();
        System.out.println(carIn);
        
    }

}
