package net.skhu.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

import org.json.simple.JSONObject;

import net.skhu.connection.MyConnection;
import net.skhu.connection.ResponseCode;
import net.skhu.connection.URLs;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;

public class JoinFrame {

	private JFrame frame;
	private JTextField nickNameField;
	private JPasswordField pwdField;
	private JPasswordField repwdField;
	private JButton joinBtn;
	private JButton cancelBtn;
	
	private MyConnection myConnection;
	
	private String nickName;
	private String password;
	private String repassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinFrame window = new JoinFrame();
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
	public JoinFrame() {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		myConnection = new MyConnection();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		nickNameField = new JTextField();
		panel.add(nickNameField);
		nickNameField.setColumns(10);
		
		pwdField = new JPasswordField();
		panel.add(pwdField);
		
		repwdField = new JPasswordField();
		panel.add(repwdField);
		//가입 버튼
		joinBtn = new JButton("\uAC00\uC785");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nickName = nickNameField.getText();
				password = new String(pwdField.getPassword());
				repassword = new String(repwdField.getPassword());
				String checkResult;
				String joinResult;
				//비밀번호 동일하게 입력했는지 확인(대소문자 구분없음)
				if(password.equalsIgnoreCase(repassword)) {
					System.out.println("입력 비밀번호 동일");
					//닉네임 중복확인
					checkResult = myConnection.loginConnection(nickName,password);
					
					switch(Integer.parseInt(checkResult)) {
					case ResponseCode.connect_error:
						System.out.println("서버 연결 오류");
						break;
					case ResponseCode.id_error:
						System.out.println("가입 가능");
						joinResult = myConnection.joinConnection(nickName,password);
						switch(Integer.parseInt(joinResult)) {
						case ResponseCode.connect_error:
							System.out.println("서버 연결 오류");
							break;
						case ResponseCode.join_success:
							System.out.println("회원가입 완료");
							frame.dispose();
							break;
						}
						break;
					default :
						System.out.println("닉네임 중복");
						break;
					}
				}
			}
		});
		panel.add(joinBtn);
		//취소 버튼
		cancelBtn = new JButton("\uCDE8\uC18C");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(cancelBtn);
	}

}
