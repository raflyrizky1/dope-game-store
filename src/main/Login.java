package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login {
	
	Connection ct;
    PreparedStatement pt;
    ResultSet rs;
	JFrame lff;
	JPanel mainpanel, west, east, topPanel, midPanel, botPanel, loginPanel, pnlogin1, pnlogin2, pnlogin3, pnlogin4; 
	JLabel login, emailLabel, passwordLabel, signUp; 
	JTextField emailtextField;
	JPasswordField passwordField;
	JButton button;
	
	
	
	public void form() {
		lff = new JFrame("Login Form");
		login = new JLabel("Login Form");
		login.setFont(new Font("Arial", Font.BOLD, 40));
		emailLabel = new JLabel("Email");
		passwordLabel = new JLabel("Password");
		signUp = new JLabel("Sign Up Here", SwingConstants.CENTER);
		
		emailtextField = new JTextField();
		emailtextField.setPreferredSize(new Dimension(200, 20));
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(200, 20));
		button = new JButton("Login");
		
		mainpanel = new JPanel(new BorderLayout(20,20));
		topPanel = new JPanel();
		midPanel = new JPanel(new GridLayout(2, 2));
		west = new JPanel();
		east = new JPanel();
		botPanel = new JPanel(new GridLayout(2,1));
		pnlogin1 = new JPanel(new GridLayout(1,1));
		pnlogin2 = new JPanel();
		pnlogin3 = new JPanel(new GridLayout(1,1));
		pnlogin4 = new JPanel();
		
		topPanel.add(login);
		
		pnlogin1.add(emailLabel);
		pnlogin2.add(emailtextField);
		pnlogin3.add(passwordLabel);
		pnlogin4.add(passwordField);
		
		midPanel.add(pnlogin1);
		midPanel.add(pnlogin2);
		midPanel.add(pnlogin3);
		midPanel.add(pnlogin4);
		

		loginPanel = new JPanel();
		
		botPanel.add(loginPanel);
		loginPanel.add(button);
		botPanel.add(signUp);
		

		
		mainpanel.add(west, BorderLayout.WEST);
		mainpanel.add(east, BorderLayout.EAST);
		mainpanel.add(topPanel, BorderLayout.NORTH);
		mainpanel.add(midPanel, BorderLayout.CENTER);
		mainpanel.add(botPanel, BorderLayout.SOUTH);
		lff.add(mainpanel);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = emailtextField.getText();
				String pass = passwordField.getText();
				
				if (email.equals("")) {
					JOptionPane.showMessageDialog(null, "Email must be filled!");
				} else if (pass.equals("")) {
					JOptionPane.showMessageDialog(null, "Password must be filled!");
				} else {
					try{
				           pt= ct.prepareStatement("select * from users where UserEmail=? and UserPassword=?");
				            pt.setString(1, emailtextField.getText());
				            pt.setString(2, passwordField.getText());
				            rs=pt.executeQuery();
				            if(rs.next()){
				                rs.first();
				            } else {
				            	JOptionPane.showMessageDialog(null, "Wrong email/password!");
				            }
				            
				            String lvl = rs.getString("UserRole");
				            
				            if (lvl.equals("Customer")) {
				            	String user = rs.getString("UserID").toString();
				            	new MainFormC(user);
								lff.dispose();
				                
				            }else if (lvl.equals("Admin")){
				            	String user = rs.getString("UserID").toString();
				                new MainFormA(user);
				            	lff.dispose();
				            }
				        	}
				    catch(SQLException se){
				            System.out.println(se);
				        	}			
				}

				
			}
		});
		
		signUp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new Register();
				lff.dispose();
				
			}
		});
		
		
		
	}
	
	
	public void visualFrame() {
		lff.setSize(480, 260);
		lff.setLocationRelativeTo(null);
		lff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lff.setResizable(false);
		lff.setVisible(true);
	}
	
	public Login() {
		ct=Connect.getConnection();
		form();
		visualFrame(); 
		
	}

}
