package net.skhu.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.skhu.connection.MyConnection;
import net.skhu.connection.ResponseCode;
import net.skhu.dto.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame {

	private JFrame frame;
	private JTextField nickNameField;
	private JButton loginBtn;
	private JButton joinBtn;
	
	private JoinFrame joinFrame;
	
	private MyConnection myConnection;
	
	private String nickName;
	private String password;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		myConnection = new MyConnection();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		nickNameField = new JTextField();
		panel.add(nickNameField);
		nickNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		panel.add(passwordField);
		//�α��� ��ư
		loginBtn = new JButton("\uB85C\uADF8\uC778");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nickName = nickNameField.getText();
				password = new String(passwordField.getPassword());
				String result;
				
				result = myConnection.loginConnection(nickName, password);
				
				switch(Integer.parseInt(result)) {
				case ResponseCode.connect_error:
					System.out.println("�������� ����");
					break;
				case ResponseCode.login_success:
					System.out.println("�α��� ����");
					break;
				case ResponseCode.id_error:
					System.out.println("�ش� �г��� ����");
					break;
				case ResponseCode.pwd_error:
					System.out.println("�н����� ����");
					break;
				}
            }
		});
		panel.add(loginBtn);
		//ȸ������ ��ư
		joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinFrame = new JoinFrame();
				JFrame frame = joinFrame.getFrame();
				frame.setVisible(true);
			}
		});
		panel.add(joinBtn);
	}

	
}
