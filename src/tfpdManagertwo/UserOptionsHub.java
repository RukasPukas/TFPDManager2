package tfpdManagertwo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class UserOptionsHub {
	
	JFrame userOptionFrame;
	JPanel panel;
	
	UserOptionsHub(String enteredUserName, String enteredPassword, Boolean adminStatus, Boolean superAdminStatus, String userEmail, JFrame hubFrame)
	{
		userOptionFrame = new JFrame("User Options");
		userOptionFrame.setSize(535,364);
		userOptionFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		userOptionFrame.setLocationRelativeTo(null);
		userOptionFrame.setResizable(false);
		
		
		ImageIcon icon = new ImageIcon("TroyIcon.png");
		Image img = icon.getImage();
        userOptionFrame.setIconImage(img);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		userOptionFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Options");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 32));
		lblNewLabel.setBounds(152, 11, 232, 59);
		panel.add(lblNewLabel);
		
		JButton resetPasswordButton = new JButton("Change Your Password");
		resetPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ResetCPW(enteredUserName,enteredPassword,adminStatus,superAdminStatus,userEmail,hubFrame);
				userOptionFrame.dispose();
			}
		});
		resetPasswordButton.setBackground(Color.LIGHT_GRAY);
		resetPasswordButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		resetPasswordButton.setForeground(Color.BLACK);
		resetPasswordButton.setBounds(24, 81, 216, 59);
		panel.add(resetPasswordButton);
		
		JButton btnResetMemberPassword = new JButton("Reset Member Password");
		btnResetMemberPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ResetFTMemberPassword(enteredUserName,  enteredPassword,  adminStatus,  superAdminStatus,  userEmail,userOptionFrame,hubFrame);
				userOptionFrame.setEnabled(false);
			}
		});
		btnResetMemberPassword.setForeground(Color.BLACK);
		btnResetMemberPassword.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnResetMemberPassword.setBackground(Color.LIGHT_GRAY);
		btnResetMemberPassword.setBounds(279, 82, 216, 59);
		
		File adminCheck = new File("User/Permissions/Admin/"+enteredUserName+".txt");
		
		if(adminCheck.exists()) {
			System.out.println("Admin security privilege granted.");
			btnResetMemberPassword.setEnabled(true);
		}
		else {
			System.out.println("Admin security privilege revoked.");
			btnResetMemberPassword.setEnabled(false);
		}
		panel.add(btnResetMemberPassword);
		
		JButton addFTEButton = new JButton("Add FT Member");
		addFTEButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddNewFTE(enteredUserName,  enteredPassword,  adminStatus,  superAdminStatus,  userEmail,userOptionFrame,hubFrame);
				userOptionFrame.setEnabled(false);
			}
		});
		addFTEButton.setForeground(Color.BLACK);
		addFTEButton.setFont(new Font("Monospaced", Font.BOLD, 15));
		addFTEButton.setBackground(Color.LIGHT_GRAY);
		addFTEButton.setBounds(24, 160, 216, 59);
		
		if(adminStatus==true)
		{
			addFTEButton.setEnabled(true);
			
		
		}
		else
		{
			addFTEButton.setEnabled(false);
		}
		panel.add(addFTEButton);
		
		JButton manageRosterButton = new JButton("Roster Management");
		manageRosterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userOptionFrame.dispose();
				new ManageRoster(enteredUserName,  enteredPassword,  adminStatus,  superAdminStatus,  userEmail,userOptionFrame,hubFrame);
				
			}
		});
		manageRosterButton.setForeground(Color.BLACK);
		manageRosterButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		manageRosterButton.setBackground(Color.LIGHT_GRAY);
		manageRosterButton.setBounds(279, 160, 216, 59);
		panel.add(manageRosterButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userOptionFrame.dispose();
				new CentralHub(enteredUserName,  enteredPassword,  adminStatus,  superAdminStatus,  userEmail);
			}
		});
		exitButton.setForeground(Color.BLACK);
		exitButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBounds(152, 249, 216, 59);
		panel.add(exitButton);
		
		
		
		
		userOptionFrame.setVisible(true);
	}
}
