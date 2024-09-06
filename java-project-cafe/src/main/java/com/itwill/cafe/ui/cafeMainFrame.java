package com.itwill.cafe.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.cafe.cart.CartService;
import com.itwill.cafe.order.OrderService;
import com.itwill.cafe.product.ProductService;
import com.itwill.cafe.user.User;
import com.itwill.cafe.user.UserService;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class cafeMainFrame extends JFrame {
	/*********Service멤버필드선언 *****/
	UserService userService;
	ProductService productService;
	OrderService orderService;
	CartService cartService;
	
	/********* 2.로그인한회원 멤버필드선언 *****/
	User loginUser=null;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginIdTF;
	private JTextField newPassTF;
	private JTextField newNameTF;
	private JTextField newPhoneTF;
	private JTextField newEmailTF;
	private JTextField newIdTF;
	private JTabbedPane tabbedPane;
	private JLabel loginuserNameLabel;
	private JLabel idMsgLB;
	private JLabel passMsgLB;
	private JLabel nameMsgLB;
	private JLabel phoneMsgLB;
	private JLabel emailMsgLB;
	private JPasswordField loginPassTF;
	private JTextField infoNameTF;
	private JTextField infoPhoneTF;
	private JTextField infoEmailTF;
	private JTextField infoIdTF;
	private JTextField infoPassTF;
	private JButton logoutButton;
	private JButton updateInfoButton;
	private JButton updateModeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cafeMainFrame frame = new cafeMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public cafeMainFrame() throws Exception {
		setTitle("카페 주문관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 497);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(400, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 30));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutProcess();
				
			}
		});
		
		logoutButton.setBounds(325, 3, 94, 23);
		panel.add(logoutButton);
		
		loginuserNameLabel = new JLabel("");
		loginuserNameLabel.setBounds(12, 7, 122, 15);
		panel.add(loginuserNameLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(400, 300));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel mainPanel = new JPanel();
		tabbedPane.addTab("메인", null, mainPanel, null);
		mainPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("방문을 환영합니다!!!");
		lblNewLabel_2.setBounds(140, 284, 157, 37);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("mainImage");
		lblNewLabel_3.setIcon(new ImageIcon(cafeMainFrame.class.getResource("/image/mainImage.jpg")));
		lblNewLabel_3.setBounds(12, 0, 400, 265);
		mainPanel.add(lblNewLabel_3);
		
		JPanel loginPanel = new JPanel();
		tabbedPane.addTab("로그인", null, loginPanel, null);
		loginPanel.setLayout(null);
		
		loginIdTF = new JTextField();
		loginIdTF.setBounds(192, 92, 116, 21);
		loginPanel.add(loginIdTF);
		loginIdTF.setColumns(10);
		
		JLabel loginId = new JLabel("아이디");
		loginId.setFont(new Font("굴림", Font.PLAIN, 12));
		loginId.setBounds(95, 93, 57, 15);
		loginPanel.add(loginId);
		
		JLabel loginPass = new JLabel("비밀번호");
		loginPass.setFont(new Font("굴림", Font.PLAIN, 12));
		loginPass.setBounds(95, 140, 57, 15);
		loginPanel.add(loginPass);
		
		JButton loginButton = new JButton("로그인");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********** 회원로그인 ************/
				try {
					String id = loginIdTF.getText();
					String password = loginPassTF.getText();
					User loginUser = userService.login(id, password);
					if(loginUser!=null) {
						//로그인성공
						loginuserNameLabel.setText("접속유저: "+id);
						JOptionPane.showMessageDialog(null,id+"님 로그인 성공");
						loginProcess(loginUser);
						displayUserInfo(loginUser);
						
					} else {
						//로그인실패
						JOptionPane.showMessageDialog(null,"아이디또는 비밀번호를 확인하세요");
						loginIdTF.requestFocus();
						loginIdTF.select(0,id.length());
					}
					
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		loginButton.setBounds(95, 219, 97, 23);
		loginPanel.add(loginButton);
		
		JButton newUserInsetButton = new JButton("회원가입");
		newUserInsetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		newUserInsetButton.setBounds(211, 219, 97, 23);
		loginPanel.add(newUserInsetButton);
		
		loginPassTF = new JPasswordField();
		loginPassTF.setBounds(192, 139, 116, 21);
		loginPanel.add(loginPassTF);
		
		JPanel newMemberPanel = new JPanel();
		tabbedPane.addTab("회원가입", null, newMemberPanel, null);
		newMemberPanel.setLayout(null);
		
		JLabel newId = new JLabel("아이디");
		newId.setBounds(70, 45, 57, 15);
		newMemberPanel.add(newId);
		
		JLabel newPass = new JLabel("비밀번호");
		newPass.setBounds(70, 105, 57, 15);
		newMemberPanel.add(newPass);
		
		JLabel newName = new JLabel("이름");
		newName.setBounds(70, 162, 57, 15);
		newMemberPanel.add(newName);
		
		JLabel newPhone = new JLabel("전화번호");
		newPhone.setBounds(70, 220, 57, 15);
		newMemberPanel.add(newPhone);
		
		JLabel newEmail = new JLabel("이메일");
		newEmail.setBounds(70, 276, 57, 15);
		newMemberPanel.add(newEmail);
		
		newIdTF = new JTextField();
		newIdTF.setBounds(170, 42, 116, 21);
		newMemberPanel.add(newIdTF);
		newIdTF.setColumns(10);
		
		newPassTF = new JTextField();
		newPassTF.setBounds(170, 102, 116, 21);
		newMemberPanel.add(newPassTF);
		newPassTF.setColumns(10);
		
		newNameTF = new JTextField();
		newNameTF.setBounds(170, 159, 116, 21);
		newMemberPanel.add(newNameTF);
		newNameTF.setColumns(10);
		
		newPhoneTF = new JTextField();
		newPhoneTF.setBounds(170, 217, 116, 21);
		newMemberPanel.add(newPhoneTF);
		newPhoneTF.setColumns(10);
		
		newEmailTF = new JTextField();
		newEmailTF.setBounds(170, 273, 116, 21);
		newMemberPanel.add(newEmailTF);
		newEmailTF.setColumns(10);
		
		JButton joinUser = new JButton("가입");
		joinUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********회원가입*************/
				try {
					/****** TextField로 부터 데이타얻기 *****/
					String id = newIdTF.getText();
					String password = newPassTF.getText();
					String name = newNameTF.getText();
					String phone = newPhoneTF.getText();
					String email = newEmailTF.getText();
					/*********** 유효성체크 ****************/
					if(id.trim().equals("")) {
						idMsgLB.setText("아이디를 입력하세요.");
						newIdTF.requestFocus();
						return;
					} else {
						idMsgLB.setText("");
					}
					
					if(password.trim().equals("")) {
						passMsgLB.setText("비밀번호를 입력하세요.");
						newPassTF.requestFocus();
						return;
					} else {
						passMsgLB.setText("");
					}
					
					if(name.trim().equals("")) {
						nameMsgLB.setText("이름을 입력하세요.");
						newNameTF.requestFocus();
						return;
					} else {
						nameMsgLB.setText("");
					}
					
					if(phone.trim().equals("")) {
						phoneMsgLB.setText("전화번호를 입력하세요.");
						newPhoneTF.requestFocus();
						return;
					} else {
						phoneMsgLB.setText("");
					}
					
					if(email.trim().equals("")) {
						emailMsgLB.setText("이메일을 입력하세요.");
						newEmailTF.requestFocus();
						return;
					} else {
						emailMsgLB.setText("");
					}
					
					User user = User.builder()
							.userId(id)
							.password(password)
							.name(name)
							.phone(phone)
							.email(email)
							.build();
					
					int isAdd = userService.create(user);
					if(isAdd == -1) {
						//가입실패--> 아이디중복 
						JOptionPane.showMessageDialog(null,id+" 는 이미사용하고있는 아이디입니다.");
						newIdTF.requestFocus();
						newIdTF.select(0,id.length());
					} else {
						//가입성공--> 로그인화면 전환
						JOptionPane.showMessageDialog(null,id+"님 가입을 환영합니다!");
						newIdTF.setText("");
						newPassTF.setText("");
						newNameTF.setText("");
						newPhoneTF.setText("");
						newEmailTF.setText("");
						tabbedPane.setSelectedIndex(1);
					}
					
				} catch (Exception e1) {
					System.out.println("회원가입에러-->" + e1.getMessage());
				}
			}
		});
		joinUser.setBounds(70, 345, 97, 23);
		newMemberPanel.add(joinUser);
		
		JButton joinUserCacel = new JButton("취소");
		joinUserCacel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		joinUserCacel.setBounds(189, 345, 97, 23);
		newMemberPanel.add(joinUserCacel);
		
		idMsgLB = new JLabel("");
		idMsgLB.setBounds(170, 73, 174, 15);
		newMemberPanel.add(idMsgLB);
		
		passMsgLB = new JLabel("");
		passMsgLB.setBounds(170, 133, 174, 15);
		newMemberPanel.add(passMsgLB);
		
		nameMsgLB = new JLabel("");
		nameMsgLB.setBounds(170, 192, 174, 15);
		newMemberPanel.add(nameMsgLB);
		
		phoneMsgLB = new JLabel("");
		phoneMsgLB.setBounds(170, 248, 174, 15);
		newMemberPanel.add(phoneMsgLB);
		
		emailMsgLB = new JLabel("");
		emailMsgLB.setBounds(170, 304, 174, 15);
		newMemberPanel.add(emailMsgLB);
		
		JPanel userInfoPanel = new JPanel();
		tabbedPane.addTab("회원정보", null, userInfoPanel, null);
		tabbedPane.setEnabledAt(3,false);
		userInfoPanel.setLayout(null);
		
		JLabel infoid = new JLabel("아이디");
		infoid.setBounds(77, 56, 45, 21);
		userInfoPanel.add(infoid);
		
		JLabel infoName = new JLabel("이름");
		infoName.setBounds(79, 142, 39, 18);
		userInfoPanel.add(infoName);
		
		infoNameTF = new JTextField();
		infoNameTF.setBounds(43, 172, 116, 21);
		userInfoPanel.add(infoNameTF);
		infoNameTF.setColumns(10);
		
		infoIdTF = new JTextField();
		infoIdTF.setBounds(43, 87, 116, 21);
		userInfoPanel.add(infoIdTF);
		infoIdTF.setColumns(10);
		
		infoPhoneTF = new JTextField();
		infoPhoneTF.setBounds(229, 172, 116, 21);
		userInfoPanel.add(infoPhoneTF);
		infoPhoneTF.setColumns(10);
		
		JLabel infoPhone = new JLabel("전화번호");
		infoPhone.setBounds(251, 147, 57, 15);
		userInfoPanel.add(infoPhone);
		
		JLabel infoEmail = new JLabel("이메일");
		infoEmail.setBounds(77, 229, 45, 15);
		userInfoPanel.add(infoEmail);
		
		infoEmailTF = new JTextField();
		infoEmailTF.setBounds(43, 254, 163, 21);
		userInfoPanel.add(infoEmailTF);
		infoEmailTF.setColumns(10);
		
		JLabel infoPass = new JLabel("비밀번호");
		infoPass.setBounds(258, 62, 57, 15);
		userInfoPanel.add(infoPass);
		
		infoPassTF = new JTextField();
		infoPassTF.setBounds(229, 87, 116, 21);
		userInfoPanel.add(infoPassTF);
		infoPassTF.setColumns(10);
		
		updateModeButton = new JButton("수정모드전환");
		updateModeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enableText = updateModeButton.getText();
				if(enableText.equals("수정모드전환")) {
					updateFormEnable(true);
					updateModeButton.setText("수정취소");
					updateInfoButton.setVisible(true);
				} else if(enableText.equals("수정취소")) {
					displayUserInfo(loginUser);
					updateModeButton.setText("수정모드전환");	
					updateInfoButton.setVisible(false);
				}
			}
		
		});
		updateModeButton.setBounds(43, 313, 116, 61);
		userInfoPanel.add(updateModeButton);
		
		updateInfoButton = new JButton("회원정보수정");
		updateInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateUserInfo();
					loginUser = userService.findUser(infoIdTF.getText());
					displayUserInfo(loginUser);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		updateInfoButton.setBounds(229, 313, 116, 61);
		userInfoPanel.add(updateInfoButton);
		
		JButton userDeleteButton = new JButton("회원탈퇴");
		userDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?\n탈퇴 시 복구 불가능합니다.","탈퇴안내",JOptionPane.OK_CANCEL_OPTION);
				if(result == JOptionPane.OK_OPTION) {
					try {
						deleteUser();
						logoutProcess();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		userDeleteButton.setBounds(290, 10, 117, 33);
		userInfoPanel.add(userDeleteButton);
		
		JPanel cartPanel = new JPanel();
		tabbedPane.addTab("장바구니", null, cartPanel, null);
		cartPanel.setLayout(null);
		
		JLabel failLabel_1 = new JLabel("장바구니였으면 좋을뻔한것");
		failLabel_1.setBounds(30, 22, 338, 51);
		cartPanel.add(failLabel_1);
		
		JPanel orderPanel = new JPanel();
		tabbedPane.addTab("주문내역", null, orderPanel, null);
		orderPanel.setLayout(null);
		
		JLabel failLabel_2 = new JLabel("주문내역이 되고싶었던 것");
		failLabel_2.setBounds(37, 27, 311, 51);
		orderPanel.add(failLabel_2);
		
		
		userService = new UserService();
		
		/********초기 실행화면************/
		loginuserNameLabel.setText("접속유저: guest");
		tabbedPane.setEnabledAt(4,false);
		tabbedPane.setEnabledAt(5,false);
		logoutButton.setEnabled(false);
		tabbedPane.setSelectedIndex(0);
		
	}
	
	/************* 로그인성공시 호출할메쏘드 ***************/
	void loginProcess(User loginUser) throws Exception {
		/************ 로그인성공시 해야할일*********** 
		 * 1.로그인성공한 멤버객체 멤버필드에저장 
		 * 2.로그인탭,회원가입탭 불활성화 회원정보 탭 활성화 
		 * 3.로그아웃 버튼 활성화 
		 * 4.회원정보 탭 활성화
		 ********************************************/
		this.loginUser=loginUser;
	
		
		tabbedPane.setEnabledAt(1,false );
		tabbedPane.setEnabledAt(2,false );
		tabbedPane.setEnabledAt(3,true );
		tabbedPane.setEnabledAt(4,true );
		tabbedPane.setEnabledAt(5,true );
		 
		tabbedPane.setSelectedIndex(0);

		logoutButton.setEnabled(true);
		
	}
	
	/************* 로그아웃 or 애플리케이션로딩시 호출할메쏘드 ***************/
	void logoutProcess() {
		/*********** 로그아웃시 해야할일*********** 
		 * 1.로그인성공한 멤버객체 멤버필드에서제거 
		 * 2.로그인,회원가입탭 활성화,장바구니, 주문내역, 회원정보탭 불활성화 
		 * 3.로그아웃 버튼 불활성화
		 * 4.메인 화면전환
		 ********************************************/
		loginUser = null;
	
		loginuserNameLabel.setText("접속유저: guest");
		loginIdTF.setText("");
		loginPassTF.setText("");
		
		tabbedPane.setEnabledAt(1,true );
		tabbedPane.setEnabledAt(2,true );
		tabbedPane.setEnabledAt(3,false );
		tabbedPane.setEnabledAt(4,false );
		tabbedPane.setEnabledAt(5,false );
		 
		tabbedPane.setSelectedIndex(0);

		logoutButton.setEnabled(false);
		
	}
	
	
	/************** 로그인성공시 호출할메쏘드 ***************/
	private void displayUserInfo(User user) {
		/**** 로그인한회원상세데이타보여주기 *****/
		infoIdTF.setText(user.getUserId());
		infoPassTF.setText(user.getPassword());
		infoNameTF.setText(user.getName());
		infoPhoneTF.setText(user.getPhone());
		infoEmailTF.setText(user.getEmail());
		
		/***회원정보 수정폼 비활성화(아이디는 절대 수정불가!!****/
		infoIdTF.setEditable(false);
		updateFormEnable(false);
		/***회원정보 수정 이벤트 버튼 숨기기****/
		updateInfoButton.setVisible(false);
		
	}

	
	/************* 회원수정폼 활성/불활성화 ****************/
	private void updateFormEnable(boolean b) {
		infoPassTF.setEditable(b);
		infoNameTF.setEditable(b);
		infoPhoneTF.setEditable(b);
		infoEmailTF.setEditable(b);
	}
	
	
	/************* 회원정보 업데이트시 호출할 메쏘드 ****************/
	private void updateUserInfo() throws Exception {

		User updateUser = User.builder()
				.userId(infoIdTF.getText())
				.password(infoPassTF.getText())
				.name(infoNameTF.getText())
				.phone(infoPhoneTF.getText())
				.email(infoEmailTF.getText())
				.build();
		
		userService.update(updateUser);
		JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.");	
		updateModeButton.setText("수정모드전환");
	
		
	}
	
	
	/************* 회원탈퇴시 호출할 메쏘드 ****************/
	private void deleteUser() throws Exception {
		String deleteUserId = loginUser.getUserId();
		userService.remove(deleteUserId);
		JOptionPane.showMessageDialog(null, "탈퇴처리가 완료되었습니다.\n이용해주셔서 감사합니다.");
		logoutProcess();
		
	}
}
