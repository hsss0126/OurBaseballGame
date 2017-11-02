package net.skhu.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.skhu.connection.MyConnection;

public class MainFrame extends JFrame{

//----------------------------------------------------
	private JFrame frame;
	static MakeRoom makeRoom;
	
	private CardLayout cards = new CardLayout();
	
	private MyConnection myConnection;
//----------------------------------------------------

	//원래거 - 닉네임정보 같이전달
	/*public MainFrame(String nickName) {
		this.myNickName = nickName; //유지
		initialize();
	}*/
	
	//프레임 테스트용 - 기본생성자로
	public MainFrame() {
		initialize();
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

	private void initialize() {
		myConnection = new MyConnection();
	
		getContentPane().setLayout(cards);	//카드레이아웃
		setBackground(Color.WHITE);
		setSize(800,600);
		//setUndecorated(true); //프레임 타이틀바 없애기
		setVisible(true);
		setLocation(1100,100);
		setResizable(false);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add("WaitingPanel", new WaitingPanel(this));
		getContentPane().add("RoomPanel", new RoomPanel());
		
		
		
		//--------------------------------------------------수정ㄴㄴ
		/*result = myConnection.infoConnection(myNickName);
		System.out.println(result);*/
		//--------------------------------------------------
		
	}
	
	public void  changePanel() {
		cards.next(this.getContentPane());
	}
	
	public CardLayout getCardLayout() {
		return cards;
	}


}
