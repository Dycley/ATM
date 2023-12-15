package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comm.Card;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = -2110640686325934505L;
	private JButton btTake;
	private JButton btModiPwd;
	private JButton btSave;
	private JButton btQuery;
	private JButton btTransfer;
	private JButton btExit;
	/**
	 * @param args
	 */
	String num;
	Card currCard;
	public MainFrame(Card currCard){
		this.currCard=currCard;
	}
	public void init(){
		//主界面
		((JPanel) this.getContentPane()).setOpaque(false);
		URL url=this.getClass().getResource("j.jpg");
		 ImageIcon img = new ImageIcon(url);
		 JLabel background = new JLabel(img);
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

		Container container=this.getContentPane();
		JPanel panel = new JPanel(null);
		panel.setOpaque(false);


		btTake=new JButton("<-取款");
		btTake.setBounds(20,110,150,50);
		panel.add(btTake);
		
		btModiPwd=new JButton("修改密码");
		btModiPwd.setBounds(770,290,150,50);
		panel.add(btModiPwd);
		
		btSave=new JButton("<-存款");
		btSave.setBounds(20,200,150,50);
		panel.add(btSave);
		
		btQuery=new JButton("<-查询");
		btQuery.setBounds(20,290,150,50);
		panel.add(btQuery);
		
		btTransfer=new JButton("<-转账");
		btTransfer.setBounds(20,380,150,50);
		panel.add(btTransfer);
		


		btExit=new JButton("<-退卡");
		btExit.setBounds(770,380,150,50);
		panel.add(btExit);
		
		container.add(panel);
		this.setSize(950,550);
		this.setLocation(500, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		 //设置不可改变窗口大小
		this.setResizable(false);
		this.setTitle("中国银行ATM取款机");
		this.setVisible(true);
		//注册监听
		btTake.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new Take(currCard).init();
			}
		});
		btQuery.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MainFrame.this, "您当前账户余额为："+currCard.getBanlance());
			}
			
		});
		btModiPwd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new ModiPwd().Password(currCard);
			}
			
		});
		
		btTransfer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			 new Transfer(currCard);
				
				
			}
			
		});

		
		 btSave.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 new Save(currCard);
			}
				
			});



		btExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
				new Login().init();


			}

		});
	}
}