package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
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



public class MainFormC {
	public static String user;
	
	
	Connection ct;
    PreparedStatement pt;
    ResultSet rs;
	
	// Main frame 
	JFrame f;
	JInternalFrame iframe;
	JDesktopPane deskpane;
	JLabel title;
	JMenuBar mn1;
	JMenu pr, trc;
	JMenuItem ep, exit, bg, view;
	JPanel toppanel, midpanel, botpanel; 
	
	// Buy game 
	JPanel mnPanel, titlePanel, cPanelbut, cPanelTop, 
	cPanelMid, cPanelBot, bPanel,
	bPanelTop, bPanelBot; 
	JTable tableGaming, tableBawah;
	DefaultTableModel tableModel, tableModelBawah;
	JScrollPane scrollPane, scrollPaneBawah;
	JLabel tLabel, gameIdLabel, gameNameLabel, gameTypeLabel, gamePriceLabel, gameStockLabel, gameQuantityLabel;
	JTextField gameIdtf, gameNametf, gameTypetf, gamePrice, gameStock;
	JSpinner gameQuality; 
	JButton atcButton, rscButton, ccButton, cButton;
	
	// Profile 
	JPanel update, name, email,phone, adres, gender,  nametex, emailtex, phonetex,adrestex, buttonup, genderpanel, west, east;
	JLabel updatelbl, namelbl, emaillbl, phonelbl, addreslbl, genderlbl;
	JTextField nametxt,emailtxt, phonetxt;
	JTextArea addrestxt;
	JButton upbutton;
	JRadioButton male, female;
	ButtonGroup buttong;
	
	// Transaction form
	JPanel intiPanel, judulPanel, TOPPanel, MIDPanel, BOTPanel, midAtas, midBawah, botAtas, botBawah;
	JLabel ttl, sltId, gt;
	JTable htTable, dtTable;
	DefaultTableModel htdt, dtdt;
	JScrollPane htScroll, dtScroll;
	JTextField sltIdtf, gttf;
	
	
	
	public void buyGm() {
		mnPanel = new JPanel(new BorderLayout());
		titlePanel = new JPanel(); 
		cPanelTop = new JPanel(new BorderLayout());
		cPanelMid = new JPanel(new BorderLayout()); 
		cPanelBot = new JPanel(new GridLayout(3, 4));
		cPanelbut = new JPanel();
		bPanel = new JPanel(new BorderLayout()); 
		bPanelTop = new JPanel(new BorderLayout());
		bPanelBot = new JPanel(); 
		
		
		
		atcButton = new JButton("Add to Cart"); 
		rscButton = new JButton("Remove Selected Cart"); 
		ccButton = new JButton("Clear Cart"); 
		cButton = new JButton("Checkout");
		
		gameIdLabel = new JLabel("Game Id"); 
		gameNameLabel = new JLabel("Game Name"); 
		gameTypeLabel = new JLabel("Game Type");
		gamePriceLabel = new JLabel("Game Price");
		gameStockLabel = new JLabel("Game Stock");
		gameQuantityLabel = new JLabel("Game Quantity");
		
		gameIdtf = new JTextField();
		gameNametf = new JTextField();
		gameTypetf = new JTextField();
		gamePrice= new JTextField();
		gameStock = new JTextField();
		gameQuality = new JSpinner();
		
		
		tLabel = new JLabel("Buy Game");
		titlePanel.add(tLabel);
		
		
		
		
        tableGaming.setModel(tableModel);
        tableGaming.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameIdtf.setText(tableModel.getValueAt(tableGaming.getSelectedRow(),0).toString());
		        tampilGameForm();
			}
		});
		

		
		
		scrollPane = new JScrollPane(tableGaming);
		scrollPane.setPreferredSize(new Dimension(100, 200));
		
		
		
		cPanelTop.add(scrollPane);
		
		cPanelMid.add(cPanelTop, BorderLayout.NORTH);
		
		cPanelMid.add(cPanelBot, BorderLayout.CENTER);
		
		cPanelBot.add(gameIdLabel);
		cPanelBot.add(gameIdtf);
		cPanelBot.add(gamePriceLabel);
		cPanelBot.add(gamePrice);
		cPanelBot.add(gameNameLabel);
		cPanelBot.add(gameNametf);
		cPanelBot.add(gameStockLabel);
		cPanelBot.add(gameStock);
		cPanelBot.add(gameTypeLabel);
		cPanelBot.add(gameTypetf);
		cPanelBot.add(gameQuantityLabel);
		cPanelBot.add(gameQuality);
		gameIdtf.setEditable(false);
		gamePrice.setEditable(false);
		gameNametf.setEditable(false);
		gameStock.setEditable(false);
		gameTypetf.setEditable(false);
		
		
		cPanelMid.add(cPanelbut, BorderLayout.SOUTH);
		
		cPanelbut.add(atcButton);
		
		bPanel.add(bPanelTop, BorderLayout.NORTH);
		bPanel.add(bPanelBot, BorderLayout.SOUTH);
		
		
		Object[] colomBawah = new Object[] {"Game ID", "Game Name", "Game Type", "Game Price", "Game Stock", "Game Quantity", "Sub Total"};
		Object[][] rowBawah = new Object[][] {};
		
		tableModelBawah = new DefaultTableModel(rowBawah, colomBawah);
		
		tableBawah = new JTable(tableModelBawah);
		scrollPaneBawah = new JScrollPane(tableBawah);
		scrollPaneBawah.setPreferredSize(new Dimension(100, 200));
		
		bPanelTop.add(scrollPaneBawah);
		bPanelBot.add(rscButton);
		bPanelBot.add(ccButton);
		bPanelBot.add(cButton);
		
		
		
		
		mnPanel.add(titlePanel, BorderLayout.NORTH);
		mnPanel.add(cPanelMid, BorderLayout.CENTER);
		mnPanel.add(bPanel, BorderLayout.SOUTH);
		
		
		
		iframe = new JInternalFrame();
		iframe.setVisible(true);
		iframe.setSize(1000,600);
		iframe.setClosable(true);
		iframe.setMaximizable(true);
		iframe.setResizable(true);
		
		iframe.add(mnPanel);
		
		deskpane = new JDesktopPane();
		deskpane.add(iframe);
		f.add(deskpane);
		
		
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
        
        String[] judul={"Game ID","Game Name","Game Type","Game Price","Game Stock"};
        tableModel=new DefaultTableModel(data,judul);
        tableGaming = new JTable(tableModel);
        
    }
	
	private void tampilGameForm(){
		
        try{
            pt=ct.prepareStatement("select * from games where GameID=? ");
            pt.setString(1, gameIdtf.getText());
            rs=pt.executeQuery();
            if(rs.next()){
            	gameNametf.setText(rs.getString("GameName"));
            	gameTypetf.setText(rs.getString("GameType"));
            	gamePrice.setText(rs.getString("GamePrice"));
            	gameStock.setText(rs.getString("GameStock"));
            }
            else{
            	gameNametf.setText("");
            	gameTypetf.setText("");
            	gamePrice.setText("");
            	gameStock.setText("");
            }
    }catch(SQLException se){
            System.out.println(se);
        }
    }
	
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
		f.add(deskpane);
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
	boolean klik = false;
	
	public void transactionForm() {
		intiPanel =  new JPanel(new BorderLayout());
		judulPanel = new JPanel();
		
		TOPPanel = new JPanel(new BorderLayout());
		MIDPanel = new JPanel(new BorderLayout());
		BOTPanel = new JPanel(new BorderLayout());
		
		midAtas = new JPanel(new BorderLayout());
		midBawah = new JPanel(new GridLayout(1,2));
		botAtas = new JPanel(new BorderLayout());
		botBawah = new JPanel(new GridLayout(1,2));
		

		dtTable.setModel(tableModelBawah);
		htTable.setModel(tableModel);
		htTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sltIdtf.setText(tableModel.getValueAt(htTable.getSelectedRow(),0).toString());
				klik = true;
				Object [][] data=null;
		        try{
		            pt=ct.prepareStatement("select * from detailtransactions where TransactionID=?");
		            pt.setString(1, "TR002");
		            rs=pt.executeQuery();
		            rs.last();
		            int jmlRec=rs.getRow();
		            data=new Object[jmlRec][3];
		            rs.beforeFirst();
		            int i=0;
		            while(rs.next()){
		                data[i][0] =rs.getString("TransactionID");
		                data[i][1] =rs.getString("GameID");
		                data[i][2] = rs.getString("Quantity");
		                i++;
		  
		            }
		  
		        }
		        catch(SQLException se){
		            System.out.println(se);
		        }
		        
		        String[] judul={"Transaction ID","Game ID","Quantity"};
		        tableModelBawah=new DefaultTableModel(data,judul);
		        dtTable = new JTable(tableModelBawah);
			}
		});
		
		htScroll = new JScrollPane(htTable);
		htScroll.setPreferredSize(new Dimension(1000, 200));
		
		
		Object[] dt1 = new Object[] {"Transaction ID", "Game ID", "Game Name", "Game Type", "Game Price", "Game Quantity", "Sub Total"};
		Object[][] dt2 = new Object[][] {};
		
		dtdt = new DefaultTableModel(dt2,dt1);
		
		
		dtScroll = new JScrollPane(dtTable);
		dtScroll.setPreferredSize(new Dimension(1000, 200));
		
		ttl  = new JLabel("Transaction History");
		sltId  = new JLabel("Selected ID");
		gt = new JLabel("Grand Total");
		
		sltIdtf = new JTextField();
		sltIdtf.setEditable(false);
		gttf = new JTextField();
		gttf.setEditable(false);
		
		judulPanel.add(ttl);
		
		

		
		midAtas.add(htScroll);
		midBawah.add(sltId);
		midBawah.add(sltIdtf);
		

		
		
		botAtas.add(dtScroll);
		botBawah.add(gt);
		botBawah.add(gttf);
		
		TOPPanel.add(judulPanel);
		
		MIDPanel.add(midAtas, BorderLayout.CENTER);
		MIDPanel.add(midBawah, BorderLayout.SOUTH);
		
		BOTPanel.add(botAtas, BorderLayout.CENTER);
		BOTPanel.add(botBawah, BorderLayout.SOUTH);
		
		intiPanel.add(TOPPanel, BorderLayout.NORTH);
		intiPanel.add(MIDPanel, BorderLayout.CENTER);
		intiPanel.add(BOTPanel, BorderLayout.SOUTH);
		
		iframe = new JInternalFrame();
		iframe.setVisible(true);
		iframe.setSize(1000,600);
		iframe.setClosable(true);
		iframe.setMaximizable(true);
		iframe.setResizable(true);
		
		iframe.add(intiPanel);
		
		deskpane = new JDesktopPane();
		deskpane.add(iframe);
		f.add(deskpane);
		
	}
	
	private void tampilTransaction(){
		Object [][] data=null;
        try{
        	String myQuery = null;     
            myQuery="select * from headertransactions";     
	        pt=ct.prepareStatement(myQuery);
	        rs=pt.executeQuery();
            rs.last();
            int jmlRec=rs.getRow();
            data=new Object[jmlRec][3];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                data[i][0] =rs.getString("TransactionID");
                data[i][1] =rs.getString("UserID");
                data[i][2] = rs.getString("TransactionDate");
                i++;
  
            }
  
        }
        catch(SQLException se){
            System.out.println(se);
        }
        
        String[] judul={"Transaction ID","User ID","TransactionDate"};
        tableModel=new DefaultTableModel(data,judul);
        htTable = new JTable(tableModel);
        dtTable = new JTable(tableModelBawah);
        
        
    }
	
	private void tampilTransactionForm(){
		
		if (klik == false) {
			Object [][] data=null;
	        try{
	            pt=ct.prepareStatement("select * from detailtransactions");
	            rs=pt.executeQuery();
	            rs.last();
	            int jmlRec=rs.getRow();
	            data=new Object[jmlRec][3];
	            rs.beforeFirst();
	            int i=0;
	            while(rs.next()){
	                data[i][0] =rs.getString("TransactionID");
	                data[i][1] =rs.getString("GameID");
	                data[i][2] = rs.getString("Quantity");
	                i++;
	  
	            }
	  
	        }
	        catch(SQLException se){
	            System.out.println(se);
	        }
	        
	        String[] judul={"Transaction ID","Game ID","Quantity"};
	        tableModelBawah=new DefaultTableModel(data,judul);
	        dtTable = new JTable(tableModelBawah);
	        
		}
	}
		
		
	
	
	public void form() {
		f = new JFrame();
		
		title = new JLabel("Welcome to DoPe Game Store, ", SwingConstants.CENTER );
		title.setFont(new Font("Roboto", Font.BOLD, 35));
		
		mn1 = new JMenuBar();
		f.setJMenuBar(mn1);
		
		pr = new JMenu("Profile");
		ep = new JMenuItem("Edit Profile");
		exit = new JMenuItem("Exit");
		pr.add(ep);
		pr.add(exit);
		
		trc = new JMenu("Transaction");
		bg = new JMenuItem("Buy Game");
		view = new JMenuItem("View Transaction History");
		trc.add(bg);
		trc.add(view);
		
		
		bg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tampilGame();
				buyGm();
				
			}
		});
		
		ep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tampilUser();
				editProfile();
				
			}
		});
		
		view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tampilTransaction();
				tampilTransactionForm();
				klik = true;
				transactionForm();

			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		mn1.add(pr);
		mn1.add(trc);
		
		f.add(title);
	}
	
	public void visual() {
	f.setTitle("DoPe Game Store");	
	f.setSize(845, 550);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setResizable(true);
	f.setVisible(true);
	
	
	}
	
	
	public MainFormC(String user) {
		this.user = user;
		updatelbl = new JLabel("");
		updatelbl.setText("Edit Profile " +user);
		ct=Connect.getConnection();
		form();
		visual();
		
		
	}

	
}
