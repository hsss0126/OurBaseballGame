package net.skhu.frame;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
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

public class JoinFrame extends JFrame{

//---------------------------------------------------------------
	private JFrame frame;
	
	private JPanel joinPanel;
		private JLabel label;
		private JLabel nameLabel;
		private JLabel pwLabel_1;
		private JLabel pwLabel_2;//비밀번호
		private JLabel pwLabel_3;//재입력
		private JTextField nickNameField;
		private JPasswordField pwdField;
		private JPasswordField repwdField;
		private JButton joinBtn;
		private JButton cancelBtn;
	
	private Font font1 = new Font("맑은 고딕",Font.BOLD,20);
	private Font font2 = new Font("맑은 고딕",Font.BOLD,30);
	
	private MyConnection myConnection;
	
	private String nickName;
	private String password;
	private String repassword;
//----------------------------------------------------------------
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JoinFrame window = new JoinFrame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(400,600);
		//setUndecorated(true); //프레임 타이틀바 없애기
		setVisible(true);
		setLocation(1100,100);
		setResizable(false);	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		joinPanel = new JPanel();
			joinPanel.setBackground(Color.WHITE);
			joinPanel.setLayout(null);
			joinPanel.setSize(400,600);
		add(joinPanel);
				
		details();

	}
	
	void details() {
		
		label = new JLabel("회  원  가  입");
			label.setBackground(Color.WHITE);
			label.setFont(font2);
			label.setSize(400, 60);
			label.setLocation(100, 100);
		joinPanel.add(label);
		
		nameLabel = new JLabel("닉 네 임  :");
			nameLabel.setBackground(Color.WHITE);
			nameLabel.setFont(font1);
			nameLabel.setSize(95, 30);
			nameLabel.setLocation(60, 250);
		joinPanel.add(nameLabel);
		
		pwLabel_1 = new JLabel("비밀번호 :");
			pwLabel_1.setBackground(Color.WHITE);
			pwLabel_1.setFont(font1);
			pwLabel_1.setSize(95, 30);
			pwLabel_1.setLocation(60, 310);
		joinPanel.add(pwLabel_1);
		
		nickNameField = new JTextField("");
			nickNameField.setFont(font1);
			nickNameField.setSize(190, 35);
			nickNameField.setLocation(170, 253);
		joinPanel.add(nickNameField);
		
		pwdField = new JPasswordField("");
			pwdField.setFont(font1);
			pwdField.setSize(190, 35);
			pwdField.setLocation(170, 313);
		joinPanel.add(pwdField);
		
		pwLabel_2 = new JLabel("비밀번호 :");
			pwLabel_2.setBackground(Color.WHITE);
			pwLabel_2.setFont(font1);
			pwLabel_2.setSize(95, 30);
			pwLabel_2.setLocation(60, 370);
		joinPanel.add(pwLabel_2);
		
		pwLabel_3 = new JLabel("재 입 력");
			pwLabel_3.setBackground(Color.WHITE);
			pwLabel_3.setFont(font1);
			pwLabel_3.setSize(95, 30);
			pwLabel_3.setLocation(63, 395);
		joinPanel.add(pwLabel_3);
		
		repwdField = new JPasswordField("");
			repwdField.setFont(font1);
			repwdField.setSize(190, 35);
			repwdField.setLocation(170, 380);
		joinPanel.add(repwdField);
		
		//회원가입 완료 버튼
		joinBtn = new JButton("가 입 완 료");
			joinBtn.setFont(font1);
			joinBtn.setSize(140, 50);
			joinBtn.setLocation(55, 480);
			joinBtn.setBackground(Color.pink);
			
			joinBtn.addActionListener(new ActionListener() {
	 			public void actionPerformed(ActionEvent e) {
	 				
	 				nickName = nickNameField.getText();
					password = new String(pwdField.getPassword());
					repassword = new String(repwdField.getPassword());
					String checkResult;
					String joinResult;
					//패스워드 입력 재확인(대소문자 구분 x)
					/*if(password.equalsIgnoreCase(repassword)) {
						System.out.println("패스워드 동일");
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
								System.out.println("가입 성공");
								dispose(); //해당 프레임만 종료
								break;
							}
							break;
						default :
							System.out.println("닉네임 중복");
							break;
						}
					}*/
					
					dispose(); //해당 프레임만 종료
	 			}
	 		});
		joinPanel.add(joinBtn);
		
		//취소 버튼
		cancelBtn = new JButton("취   소");
			cancelBtn.setFont(font1);
			cancelBtn.setSize(140, 50);
			cancelBtn.setLocation(210, 480);
			cancelBtn.setBackground(Color.pink);
			
			cancelBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
						dispose(); //해당 프레임만 종료
				}
			});
		joinPanel.add(cancelBtn);
	}

}
