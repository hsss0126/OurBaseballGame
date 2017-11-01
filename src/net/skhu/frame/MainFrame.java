package net.skhu.frame;

import javax.swing.JFrame;

import net.skhu.connection.MyConnection;

public class MainFrame {

	private MyConnection myConnection;
	private JFrame frame;

	private String myNickName;
	private String result;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame window = new MainFrame(null);
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
	public MainFrame(String nickName) {
		this.myNickName = nickName;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		result = myConnection.infoConnection(myNickName);
		System.out.println(result);
	}

}
