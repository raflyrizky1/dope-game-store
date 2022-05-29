package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MainFormA {
	public static String user;
	Connection ct;
    PreparedStatement pt;
    ResultSet rs;
	
	JFrame mfr;
	JInternalFrame iframe;
	JDesktopPane deskpane;
	JLabel title;
	JMenuBar mn1;
	JMenu pr, mng;
	JMenuItem ep, exit, mg;
	JPanel toppanel, midpanel, botpanel; 
	
	// Profile 
	JPanel update, name, email,phone, adres, gender,  nametex, emailtex, phonetex, adrestex, buttonup, genderpanel, west, east,users;
	JLabel updatelbl, namelbl, emaillbl, phonelbl, addreslbl, genderlbl;
	JTextField nametxt,emailtxt, phonetxt;
	JTextArea addrestxt;
	JButton upbutton;
	JRadioButton male, female;
	ButtonGroup buttong;
	
	// Manage
	JLabel title1, id, name1, type, price,stock, newid, newname, newtype, newprice, newstock, stockbot,userlbl;
	JTextField idt, namet, pricet, stockt, newidt, newnamet, newpricet;
	JSpinner newstockt, addstock;
	JPanel toppanel1, midpanel1, midpanel2, botpanel0,botpanel1, botpanel2, west1, east1, tablepnl;
	JTable table;
	DefaultTableModel dtm;
	JScrollPane sp;
	JComboBox<String> types1, types2;
	Vector<String> listtype1, listtype2;
	JButton insert, update1, delete, reset, add;
	
	public void editProfile() {
		west = new JPanel();
		east = new JPanel();

		
		update = new JPanel();
		update.add(updatelbl);
		
		namelbl = new JLabel("Username");

		nametxt.setPreferredSize(new Dimension(400,40));
		name = new JPanel(new GridLayout(1,1));
		name.add(namelbl);
		nametex = new JPanel();
		nametex.add(nametxt);
		
		
		
		
		emaillbl = new JLabel("User Email");

		emailtxt.setPreferredSize(new Dimension(400,40));
		email = new JPanel(new GridLayout(1,1));
		email.add(emaillbl);
		emailtex = new JPanel();
		emailtex.add(emailtxt);
		
		phonelbl = new JLabel("User Phone");

		phonetxt.setPreferredSize(new Dimension(400,40));
		phone = new JPanel(new GridLayout(1,1));
		phone.add(phonelbl);
		phonetex = new JPanel();
		phonetex.add(phonetxt);
		
		addreslbl = new JLabel("User Address" );

		addrestxt.setPreferredSize(new Dimension(400,40));
		adres = new JPanel(new GridLayout(1,1));
		adres.add(addreslbl);
		adrestex = new JPanel(new BorderLayout(10,10));
		adrestex.add(addrestxt);
		
		genderlbl = new JLabel("User Gender");

		buttong = new ButtonGroup();
		buttong.add(male);
		buttong.add(female);
		gender = new JPanel(new GridLayout(1,1));
		gender.add(genderlbl);
		genderpanel = new JPanel(new GridLayout(1,1));
		genderpanel.add(male);
		genderpanel.add(female);
		
		
		upbutton = new JButton("Update Profile");
		upbutton.setPreferredSize(new Dimension(200, 40));
		upbutton.addActionListener(new ActionListener() {
			
			String username = nametxt.getText();
			String emails = emailtxt.getText();
			String phones = phonetxt.getText();
			String address = addrestxt.getText();
			boolean street = addrestxt.getText().endsWith("Street");
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean street = addrestxt.getText().endsWith("Street");
				if(nametxt.getText().length() <5 || nametxt.getText().length() > 30) {
					JOptionPane.showMessageDialog(null, "Username must be between 5-30 characters");
				} else if (!emailtxt.getText().contains("@")) {
					JOptionPane.showMessageDialog(null, "Please fill with valid email!");
				} else if (isNumeric(phonetxt.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Phone number must be numeric");
				} else if (addrestxt.getText().length() < 10) {
					JOptionPane.showMessageDialog(null, "Address must consist of 10 or more characters ");
				} else if (phonetxt.getText().length() != 12)  {
					JOptionPane.showMessageDialog(null, "Phone must be 12 number");
				} else if (street == false) {
					JOptionPane.showMessageDialog(null, "Address must ends with 'Street' ");
				} 
				else if (male.isSelected() == false && female.isSelected() == false){
					JOptionPane.showMessageDialog(null, "Gender must be selected!");
				} else {
					update();
				}
				
				

			}
		});
		buttonup = new JPanel();
		buttonup.add(upbutton);
		
		
		
		toppanel = new JPanel();
		toppanel.add(update);
		
		
		midpanel= new JPanel(new GridLayout(5,2));
		midpanel.add(name);
		midpanel.add(nametex);
		midpanel.add(email);
		midpanel.add(emailtex);
		midpanel.add(phone);
		midpanel.add(phonetex);
		midpanel.add(adres);
		midpanel.add(adrestex);
		midpanel.add(gender);
		midpanel.add(genderpanel);
		
		botpanel = new JPanel();
		botpanel.add(buttonup);
		
		
		
		iframe = new JInternalFrame();
		iframe.setVisible(true);
		iframe.setSize(830,490);
		iframe.setClosable(true);
		iframe.setMaximizable(true);
		
		
		iframe.add(toppanel, BorderLayout.NORTH);
		iframe.add(midpanel, BorderLayout.CENTER);
		iframe.add(botpanel, BorderLayout.SOUTH);
		iframe.add(west, BorderLayout.WEST);
		iframe.add(east, BorderLayout.EAST);
		
		
		deskpane = new JDesktopPane();
		deskpane.add(iframe);
		mfr.add(deskpane);
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
	
	private void tampilUser(){
		try{
			pt=ct.prepareStatement("SELECT * FROM users WHERE UserID=?");
			pt.setString(1,user);
			rs=pt.executeQuery();
	           if (rs.next()) {
	        	   rs.first();
	        	   nametxt = new JTextField();
		       		emailtxt = new JTextField();
		       		phonetxt = new JTextField();
		       		addrestxt = new JTextArea();
		       		male = new JRadioButton("Male");
		       		female = new JRadioButton("Female");
	        	   
	        	   String name = rs.getString("UserName");
	        	   nametxt.setText(name);
	        	   emailtxt.setText(rs.getString("UserEmail"));
	        	   addrestxt.setText(rs.getString("UserAddress"));
	        	   String gender = rs.getString("UserGender");
	        	   if (gender.equals("Male")) {
	        		   male.setSelected(true);
	        	   } else if (gender.equals("Female")) {
	        		   female.setSelected(true);
	        	   }
	        	   phonetxt.setText(rs.getString("UserPhone"));
	        	   
	        	   
	           }
	           
	        }
	        catch(SQLException e){
	            System.out.println(e);
	        }
        
    }
	
	public void update() {
		try{
			pt=ct.prepareStatement("SELECT * FROM users WHERE UserID=?");
			pt.setString(1,user);
			rs=pt.executeQuery();
	           String myQuery;
	           String gender;
	           if (rs.next()) {
	        	   
	        	   JOptionPane.showMessageDialog(null, "Update Success!");
	        	   myQuery="UPDATE users SET UserName=?, UserEmail=?, UserGender=?, UserAddress=?, UserPhone=? where UserID=?";
	               pt=ct.prepareStatement(myQuery);   
	               
	               pt.setString(1,nametxt.getText());
	               pt.setString(2,emailtxt.getText()); 
	               if (male.isSelected()) {
	            	   gender = "Male";
	            	   pt.setString(3,gender);
	       			} else if (female.isSelected()) {
	       				gender = "Female";
	       				pt.setString(3,gender);
	       			}
	               pt.setString(4,addrestxt.getText());
	               pt.setString(5,phonetxt.getText());
	               
	               pt.setString(6,user);
	               pt.executeUpdate();
	           }
	           
	        }
	        catch(SQLException e){
	            System.out.println(e);
	        }
	}
	
	public void manageGM() {
		toppanel1 = new JPanel();
		 midpanel1 = new JPanel(new BorderLayout()); 
		 midpanel2 = new JPanel(new GridLayout(5,4));
		 botpanel0 = new JPanel(new GridLayout(2,2));
		 botpanel1 = new JPanel(new GridLayout(1,3));
		 botpanel2 = new JPanel(new GridLayout(1,4));
		 west1 = new JPanel();
		 east1 = new JPanel();
		 tablepnl = new JPanel(new BorderLayout(20,20));
		 
		title1 = new JLabel("Manage Game");
		
		table = new JTable(dtm);
		
		table.setRowHeight(30);
		
		sp = new JScrollPane(table);
		
		sp.setPreferredSize(new Dimension(700, 400));
		tablepnl.add(sp);
		
		
		 newid = new JLabel("New Game ID");
		 newname = new JLabel("New Game Name");
		 newtype = new JLabel("New Game Type");
		 newprice= new JLabel("New Game Price");
		 newstock= new JLabel("New Game Stock");
		 
		 id = new JLabel("Game ID");
		 name1 = new JLabel("Game Name");
		 type = new JLabel("Game Type");
		 price = new JLabel("Game Price");
		 stock = new JLabel("Game Stock");
		 
		 
		 newidt = new JTextField(); 
		 newidt.setEditable(true);
		 newnamet = new JTextField(); 
		 
		 listtype1 = new Vector<>();
		 listtype1.add("RPG");
		 listtype1.add("MMORPG");
		 listtype1.add("TPS");
		 listtype1.add("FPS");
		 
		 types1 = new JComboBox<String>(listtype1);
		 types1.setEditable(false);
		 newpricet = new JTextField();
		 newstockt= new JSpinner();
		 
		 idt = new JTextField(); 
		 idt.setEditable(false);
		 namet = new JTextField(); 
		 
		 listtype2 = new Vector<>();
		 listtype2.add("RPG");
		 listtype2.add("MMORPG");
		 listtype2.add("TPS");
		 listtype2.add("FPS");
		 
		 types2 = new JComboBox<String>(listtype2);
		 types2.setEditable(false);
		 pricet = new JTextField(); 
		 stockt = new JTextField(); 
		 stockt.setEditable(false);
		 
		  midpanel2.add(newid);
		  midpanel2.add(newidt);
		  midpanel2.add(id);
		  midpanel2.add(idt);
		  midpanel2.add(newname);
		  midpanel2.add(newnamet);
		  midpanel2.add(name1);
		  midpanel2.add(namet);
		  midpanel2.add(newtype);
		  midpanel2.add(types1);
		  midpanel2.add(type);
		  midpanel2.add(types2);
		  midpanel2.add(newprice);
		  midpanel2.add(newpricet);
		  midpanel2.add(price);
		  midpanel2.add(pricet);
		  midpanel2.add(newstock);
		  midpanel2.add(newstockt);
		  midpanel2.add(stock);
		  midpanel2.add(stockt);
		  String gmName = newnamet.getText();
		  String gmprice = newpricet.getText();
		  

		  insert = new JButton("Insert Game");
		  insert.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					if (gmName.length() <5 || gmName.length() > 30) {
						JOptionPane.showMessageDialog(null, "Game name must be between 5-30 characters");
					} else if (isNumeric(newpricet.getText()) == false) {
						JOptionPane.showMessageDialog(null, "Game price must be numeric");
					} else if (gmprice.length() <= 0) {
						JOptionPane.showMessageDialog(null, "Game price must be more than 0");
					} else if (types2.getSelectedItem().toString() == null) {
						JOptionPane.showMessageDialog(null, "Game type must be selected");
					} else {
						insert();
						tampilGame();
					}
					
					
					
				}
			});
		  
		  update1 = new JButton("Update Game");
		  delete = new JButton("Delete Game");
		  
		  botpanel1.add(insert);
		  botpanel1.add(update1);
		  botpanel1.add(delete);
		  

		  reset = new JButton("Reset");
		  stockbot = new JLabel("Add Stock");
		  addstock = new JSpinner();
		  add = new JButton("Add Stock");
		  botpanel2.add(reset);
		  botpanel2.add(stockbot);
		  botpanel2.add(addstock);
		  botpanel2.add(add);
		  
		  update1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gmName.length() <5 || gmName.length() > 30) {
					JOptionPane.showMessageDialog(null, "Game name must be between 5-30 characters");
				} else if (isNumeric(newpricet.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Game price must be numeric");
				} else if (gmprice.length() <= 0) {
					JOptionPane.showMessageDialog(null, "Game price must be more than 0");
				} else if (types2.getSelectedItem().toString() == null) {
					JOptionPane.showMessageDialog(null, "Game type must be selected");
				} else {
					updateData();
				}
				
				
			}
		});
		 
		//top
		toppanel1.add(title1);
		//mid
		midpanel1.add(tablepnl, BorderLayout.NORTH);	
		midpanel1.add(midpanel2, BorderLayout.CENTER);
		//bot
		botpanel0.add(botpanel1, BorderLayout.NORTH);
		botpanel0.add(botpanel2, BorderLayout.CENTER);
		
		
		iframe = new JInternalFrame();
		iframe.setVisible(true);
		iframe.setSize(1065,659);
		iframe.setClosable(true);
		iframe.setMaximizable(true);
		
		iframe.add(toppanel1, BorderLayout.NORTH);
		iframe.add(midpanel1, BorderLayout.CENTER);
		iframe.add(botpanel0, BorderLayout.SOUTH);
		iframe.add(west1, BorderLayout.WEST);
		iframe.add(east1, BorderLayout.EAST);
	
		
		
		deskpane = new JDesktopPane();
		deskpane.add(iframe);
		
		mfr.add(deskpane);
	}
	
	private void tampilGame(){
		Object [][] data=null;
        try{
        	String myQuery = null;     
            myQuery="select * from games";     
	        pt=ct.prepareStatement(myQuery);
	        rs=pt.executeQuery();
            rs.last();
            int jmlRec=rs.getRow();
            data=new Object[jmlRec][5];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                data[i][0] =rs.getString("GameID");
                data[i][1] =rs.getString("GameName");
                data[i][2] = rs.getString("GameType");
                data[i][3] = rs.getString("GamePrice");
                data[i][4] = rs.getString("GameStock");
                i++;
  
            }
  
        }
        catch(SQLException se){
            System.out.println(se);
        }
        
        String[] judul={"Game ID","Game Name","Game Type", "Game Price", "Game Stock"};
        dtm=new DefaultTableModel(data,judul);
        table = new JTable(dtm);
        
        
        
    }
	
	public void updateData() {
		try{
			pt=ct.prepareStatement("SELECT * FROM games WHERE GameID=?");
			pt.setString(1,newidt.getText());
			rs=pt.executeQuery(); 
			String myQuery;

			if (rs.next()) {
				myQuery="UPDATE games SET GameName=?, GameType=?, GamePrice=?, GameStock=? where UserID=?";
				JOptionPane.showMessageDialog(null, "Successfully Update Game!");
				pt=ct.prepareStatement(myQuery);   
	            pt.setString(5,idt.getText());
	            pt.setString(1,namet.getText()); 
	            pt.setString(2,types2.getSelectedItem().toString());
	            pt.setString(3,pricet.getText());
	            pt.setString(4,stockt.getText());
	            pt.executeUpdate();
	           
			} else {
				JOptionPane.showMessageDialog(null, "Update Fail");
			}

		} catch(SQLException e){
			System.out.println(e);
	        
		}
	}
	
	public void insert() {
		
		try{
			pt=ct.prepareStatement("SELECT * FROM games WHERE GameID=?");
			pt.setString(1,newidt.getText());
			rs=pt.executeQuery(); 
			String myQuery;

			if (rs.next()) {
				
			} else{
				myQuery="insert into games (GameID, GameName, GameType, GamePrice, GameStock) values (?,?,?,?,?)";
				JOptionPane.showMessageDialog(null, "Successfully Add Game!");
				pt = ct.prepareStatement(myQuery);   
				pt.setString(1,newidt.getText());
				pt.setString(2,newnamet.getText()); 
				pt.setString(3,types1.getSelectedItem().toString());
				pt.setString(4,newpricet.getText());
		        pt.setString(5,newstockt.getValue().toString()); 
		        pt.executeUpdate();

		        tampilGame();
			}

		} catch(SQLException e){
			System.out.println(e);
	        
		}
      
	}
	
	
	
	
	public void form() {
		mfr = new JFrame();
		
		title = new JLabel("Welcome to DoPe Game Store, ", SwingConstants.CENTER);
		title.setFont(new Font("Roboto", Font.BOLD, 35));
		
		mn1 = new JMenuBar();
		mfr.setJMenuBar(mn1);
		
		pr = new JMenu("Profile");
		ep = new JMenuItem("Edit Profile");
		exit = new JMenuItem("Exit");
		pr.add(ep);
		pr.add(exit);
		
		mng = new JMenu("Manage");
		mg = new JMenuItem("Manage Game");
		mng.add(mg);
		
		mg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manageGM();
				
			}
		});
		
		ep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tampilUser();
				editProfile();
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		mn1.add(pr);
		mn1.add(mng);
		
		
		mfr.add(title);
	}
	
	public void visual() {
	mfr.setSize(1080,720);
	mfr.setLocationRelativeTo(null);
	mfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mfr.setResizable(true);
	mfr.setTitle("DoPe Game Store");
	mfr.setVisible(true);
	}
	
	
	public MainFormA(String user) {
		this.user = user;
		updatelbl = new JLabel("");
		updatelbl.setText("Edit Profile " +user);
			
		
		ct=Connect.getConnection();
		tampilGame();
		form();
		visual();
	}
}
	

