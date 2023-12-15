package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;

import comm.Card;
import comm.CardArray;

public class ModiPwd extends JFrame implements ActionListener{
	private JLabel lb1,lb2,lb3;
	private JPasswordField tf1,tf2,tf3;
	private JButton btn1,btn2;
	Card currCard;
	
	public void Password(Card currCard){
		this.currCard=currCard;		
		
		lb1=new JLabel("原始密码：");
		lb2=new JLabel("新密码：");
		lb3=new JLabel("确认密码：");
		
		tf1=new JPasswordField();
		tf2=new JPasswordField();
		tf3=new JPasswordField();
		
		btn1=new JButton("确定");
		btn2=new JButton("取消");
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(4,2));
		
		p.add(lb1);
		p.add(tf1);
		p.add(lb2);
		p.add(tf2);
		p.add(lb3);
		p.add(tf3);
		p.add(btn1);
		p.add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ModiPwd.this.dispose();
			}
			
		});
		this.add(p);
		
		this.setTitle("修改密码");
		this.setSize(950,550);
		this.setLocation(500, 250);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
 		String pwd1=new String(tf1.getPassword());
		String pwd2=new String(tf2.getPassword());
		String pwd3=new String(tf3.getPassword());
		CardArray.getCardList();
		Iterator<Card> it=CardArray.getCardList().iterator();

		
		if(!pwd1.equals(currCard.getPassWord())){
			JOptionPane.showMessageDialog(ModiPwd.this, "对不起，您的密码有误，请重新输入！");
		}else if(pwd2.equals(currCard.getPassWord())){
			JOptionPane.showMessageDialog(ModiPwd.this, "新密码与原密码重复，请重新输入！");
		}else if(!pwd3.equals(pwd2)){
			JOptionPane.showMessageDialog(ModiPwd.this, "两次填写的密码不一致，请重新输入！");
		}else{
			JOptionPane.showMessageDialog(ModiPwd.this, "密码修改成功！");
			currCard.setPassWord(pwd2);
		}
	}

}
