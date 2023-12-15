package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import comm.CardArray;
import comm.Card;
public class Login extends JFrame {
	JTextField tfAccount;
	JPasswordField tfPwd;
	JButton btOk,btCancel;
	Card currCard;
	private int count;
	public void init(){


		Container container=this.getContentPane();
		JPanel panelOne = new JPanel(null);
		panelOne.setOpaque(false);            //组件设置为透明;

		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("E:/atm2/src/gui/j.jpg"); //添加图片
		JLabel background = new  JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());



		//账号
		JLabel lAccount=new JLabel("账号");
		lAccount.setBounds(340,180,80,60);
		panelOne.add(lAccount);
		//账号框
		tfAccount=new JTextField();
		tfAccount.setBounds(380, 195, 200, 30);
		panelOne.add(tfAccount);


		//密码
		JLabel lPwd=new JLabel("密码");
		lPwd.setBounds(340,250,50,60);
		panelOne.add(lPwd);
		//密码框
		tfPwd=new JPasswordField();
		tfPwd.setBounds(380, 260, 200, 30);
		panelOne.add(tfPwd);




		btOk=new JButton("确定");
		btOk.setBounds(360,320,100,40);
		panelOne.add(btOk);

		btCancel=new JButton("取消");
		btCancel.setBounds(490,320,100,40);
		panelOne.add(btCancel);


		panelOne.add(lAccount);
		panelOne.add(lPwd);
		panelOne.add(btOk);
		panelOne.add(btCancel);

 		container.add(panelOne);

		this.setTitle("欢迎来到中国银行！");
		this.setSize(950,550);
		this.setLocation(500, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//注册监听
		btOk.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
 				String account=tfAccount.getText();
				String pwd=new String(tfPwd.getPassword());
				CardArray.getCardList();
				Iterator<Card> it=CardArray.getCardList().iterator();
				//和集合中的合法数据进行匹配
				while(it.hasNext()){
					currCard=it.next();//保存当前账户
					if(account.equals(currCard.getCardID())){
						System.out.println("ok");
						break;
					}
				}
				if(currCard==null){
					JOptionPane.showMessageDialog(Login.this, "对不起，您的账号有误!");
					currCard=null;
					tfAccount.setText("");
				}else if(pwd.equals(currCard.getPassWord())){
							Login.this.dispose();
							new MainFrame(currCard).init();
				}else{
							JOptionPane.showMessageDialog(Login.this, "对不起，您的密码有误，请重新输入！您还有"+(2-count)+"次机会");
							count++;
							if(count==3){
								JOptionPane.showMessageDialog(Login.this, "您的密码三次错误，已吞卡！");

								tfAccount.setText("");
								tfPwd.setText("");
								System.exit(0);
						}
					}
				}			
		});
	}
	public static void main(String[] args) {
		new Login().init();
	}

}
