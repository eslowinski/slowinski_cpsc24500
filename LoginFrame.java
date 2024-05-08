package application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.*;

class LoginFrame extends JDialog {
	
    private static LoginFrame v;
  //  JFrame parent;
    public static LoginFrame V(JFrame parent) {
    	if (v == null)
    		v = new LoginFrame(parent);
    	return v;
    }
    private final JLabel lblUsername = new JLabel("Username");
    private final JLabel lblPassword = new JLabel("Password");

    private final JTextField txtUsername = new JTextField(20);
    private final JPasswordField txtPassword = new JPasswordField(20);

    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");
    


    private LoginFrame() {
        this(null);
    }

    LoginFrame(final JFrame parent) {
        super(parent, "Log in window");
       
       //code for creating the frame needed here...
        JPanel panlLabels = new JPanel(new GridLayout(2, 1,20,20));
        panlLabels.add(lblUsername); 
        panlLabels.add(lblPassword);
        
        JPanel panlTextfields = new JPanel(new GridLayout(2, 1,20,20));
        txtUsername.setPreferredSize(new Dimension(150, 20));
        txtPassword.setPreferredSize(new Dimension(150, 20));
        panlTextfields.add(txtUsername);
        panlTextfields.add(txtPassword);
        
        JPanel panlOrgan = new JPanel(new GridLayout(1,2,20,20));
        panlOrgan.add(panlLabels);
        panlOrgan.add(panlTextfields);
        
        JPanel panlBut = new JPanel();
        panlBut.add(btnLogin);
        panlBut.add(btnCancel);
        
        setLayout(new BorderLayout());
        add(panlOrgan, BorderLayout.CENTER);
        add(panlBut, BorderLayout.SOUTH);
        setSize(300,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//note how we get the password text from JTextPassword
            	String strPassword = String.valueOf(txtPassword.getPassword());
            	String strUsername = txtUsername.getText().trim();
            	
                
                if (verifyLogin(strUsername, strPassword)) {
                    parent.setVisible(true);
                    ((ExerciseTracker) parent).enableAll(); 
                    setVisible(false);
                } else {
                	//play around with the options
                	JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login", JOptionPane.ERROR_MESSAGE );

                }
            }

			private boolean verifyLogin(String strUsername, String strPassword) {
				if(strUsername.equals("healthy") && strPassword.equals("donut"))
					return true;
				return false;
			}
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	txtPassword.setText("");
            	txtUsername.setText("");
                setVisible(false);
            
            }
        });
    }
}
