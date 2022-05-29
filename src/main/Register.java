package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Register {
	Connection ct;
    PreparedStatement pt;
    ResultSet rs;

	JFrame regFrame;
	JPanel topPanel, midPanel, botPanel, genderPanel, buttonPanel,west, east, main,
	mid1,mid2, mid3, mid4, mid5, mid6, mid7, mid8, mid9, mid10, mid11, mid12, mid13, mid14, mid15;
	JLabel regis, idLabel, username, email, phone, address, password, gender, role, signIn;
	JTextField Idtext, usernameText, emailText, phoneText;
	JTextArea addressTextArea;
	JPasswordField passwordField;
	JRadioButton m, f;
	JComboBox<String> roleCombo;
	ButtonGroup group;
	Vector<String> listRole;
	JButton regisButton;
	
	
	
	
	void panel() {
		main = new JPanel(new BorderLayout(20,20));
		west = new JPanel();
		east = new JPanel();
		mid1 = new JPanel(new GridLayout(1,1));
		mid2 = new JPanel();
		mid3 = new JPanel(new GridLayout(1,1));
		mid4 = new JPanel();
		mid5 = new JPanel(new GridLayout(1,1));
		mid6 = new JPanel();
		mid7 = new JPanel(new GridLayout(1,1));
		mid8 = new JPanel();
		mid9 = new JPanel(new GridLayout(1,1));
		mid10 = new JPanel();
		mid11= new JPanel(new GridLayout(1,1));
		mid12= new JPanel();
		mid13= new JPanel(new GridLayout(1,1));
		mid14= new JPanel(new GridLayout(1,1));
		mid15= new JPanel();
	}
	
	
	
	public void form() {
		
		
		regFrame = new JFrame("Register Form");
		regis = new JLabel("Register Form");
		regis.setFont(new Font("Arial", Font.BOLD, 38));
		idLabel = new JLabel("ID");
		username = new JLabel("User Name");
		email =  new JLabel("Email");
		phone = new JLabel("Phone");
		address = new JLabel("Address");
		password = new JLabel("Password");
		gender = new JLabel("Gender");
		role = new JLabel("Role");
		signIn = new JLabel("     Sign In");
		
		Idtext = new JTextField("US003");
		Idtext.setPreferredSize(new Dimension(200,20));
		Idtext.setEditable(false);
		usernameText = new JTextField();
		usernameText.setPreferredSize(new Dimension(200,20));
		emailText = new JTextField(); 
		emailText.setPreferredSize(new Dimension(200,20));
		phoneText = new JTextField();
		phoneText.setPreferredSize(new Dimension(200,20));
		
		addressTextArea = new JTextArea();
		addressTextArea.setPreferredSize(new Dimension(200,50));
		
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(200,20));
		genderPanel = new JPanel();
		
		m = new JRadioButton("Male");
		f = new JRadioButton("Female");
		
		genderPanel.add(m);
		genderPanel.add(f);
		
		group = new ButtonGroup();
		group.add(m);
		group.add(f);
		
		listRole = new Vector<>();
		listRole.add("Admin");
		listRole.add("Customer");
		
		roleCombo = new JComboBox<String>(listRole);
		
		regisButton = new JButton("Register");
		
		topPanel = new JPanel();
		midPanel = new JPanel(new GridLayout(8, 2));
		botPanel = new JPanel(); 
		
		topPanel.add(regis);
		
		panel();
		
		mid1.add(idLabel);
		mid2.add(Idtext);
		mid3 .add(username);
		mid4 .add(usernameText);
		mid5 .add(email);
		mid6 .add(emailText);
		mid7 .add(phone);
		mid8 .add(phoneText);
		mid9 .add(address);
		mid10 .add(addressTextArea);
		mid11.add(password);
		mid12.add(passwordField);
		mid13.add(gender);
		mid14.add(role);
		mid15.add(roleCombo);
		
		
		midPanel.add(mid1);
		midPanel.add(mid2);
		midPanel.add(mid3);
		midPanel.add(mid4);
		midPanel.add(mid5);
		midPanel.add(mid6);
		midPanel.add(mid7);
		midPanel.add(mid8);
		midPanel.add(mid9);
		midPanel.add(mid10);
		midPanel.add(mid11);
		midPanel.add(mid12);
		midPanel.add(mid13);
		midPanel.add(genderPanel);
		midPanel.add(mid14);
		midPanel.add(mid15);
		
		buttonPanel = new JPanel(new GridLayout(2,1));
		botPanel.add(buttonPanel);
		buttonPanel.add(regisButton);
		buttonPanel.add(signIn);
		
		
		main.add(west, BorderLayout.WEST);
		main.add(east, BorderLayout.EAST);
		main.add(topPanel, BorderLayout.NORTH);
		main.add(midPanel, BorderLayout.CENTER);
		main.add(botPanel, BorderLayout.SOUTH);
		regFrame.add(main);
		
		
			
		regisButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				String password = passwordField.getText();
				String emails = emailText.getText();
				String phone = phoneText.getText();
				String address = addressTextArea.getText();
				boolean street = address.endsWith("Street");
				char[] chars = password.toCharArray();
				
				boolean digit = true;
				for(char c : chars){
					if (Character.isDigit(c)) {
						digit = true;
					} else {
						digit = false;
					}
				}
				
				if(username.length() <5 || username.length() > 30) {
					JOptionPane.showMessageDialog(null, "Username must be between 5-30 characters");
				} else if (!emails.contains("@")) {
					JOptionPane.showMessageDialog(null, "Please fill with valid email!");
				} else if (isNumeric(phone) == false) {
					JOptionPane.showMessageDialog(null, "Phone number must be numeric");
				} else if (phone.length() != 12) {
					JOptionPane.showMessageDialog(null, "Phone number must be 12 digits");
				} else if (address.length() < 10) {
					JOptionPane.showMessageDialog(null, "Address must consist of 10 or more characters ");
				} else if (street == false) {
					JOptionPane.showMessageDialog(null, "Address must ends with 'Street' ");
				} else if (digit == false) {
					JOptionPane.showMessageDialog(null, "Password must at least contain 1 character and 1 digit");
				} else if (password.length() < 5 || password.length() > 30) {
					JOptionPane.showMessageDialog(null, "Password must 5-30 lenght of character");
				} else if (m.isSelected() == false && f.isSelected() == false){
					JOptionPane.showMessageDialog(null, "Gender must be selected!");
				} else {
					insert();
				}
				
				
				
				
				
				
			}
		});
		
		signIn.addMouseListener(new MouseListener() {
			
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
				new Login();
				regFrame.dispose();
				
			}
		});
		
		
		
	}
	
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	public void insert() {
		try{
			pt=ct.prepareStatement("SELECT * FROM users WHERE UserID=?");
			pt.setString(1,Idtext.getText());
			rs=pt.executeQuery();
	           String myQuery;
	           String gender;
	           if (rs.next()) {
	        	   
	           }
	           else{
	                myQuery="insert into users (UserID,UserName,UserEmail,UserPassword,UserGender,UserAddress,UserPhone,UserRole) values (?,?,?,?,?,?,?,?)";
	                JOptionPane.showMessageDialog(null, "Successfully Register!");
	                pt = ct.prepareStatement(myQuery);   
	                pt.setString(1,Idtext.getText());
	                pt.setString(2,usernameText.getText());
		            pt.setString(3,emailText.getText()); 
		               pt.setString(4,passwordField.getText());
		               if (m.isSelected()) {
		            	   gender = "Male";
		            	   pt.setString(5,gender);
		       			} else if (f.isSelected()) {
		       				gender = "Female";
		       				pt.setString(5,gender);
		       			}
		               pt.setString(6,addressTextArea.getText());
		               pt.setString(7,phoneText.getText());
		               pt.setString(8,roleCombo.getSelectedItem().toString());
		              
		               pt.executeUpdate();
	           }
	           
	        }
	        catch(SQLException e){
	            System.out.println(e);
	        }
      
	}
	
	
	
	public void visualFrame() {
		regFrame.setSize(500, 550);
		regFrame.setLocationRelativeTo(null);
		regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regFrame.setResizable(true);
		regFrame.setVisible(true);
	}
	
	public Register() {
		ct=Connect.getConnection();

		form();
		visualFrame();
	}

	

}
