package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import comm.Card;
import comm.CardArray;

public class Transfer extends JFrame implements ActionListener{
	private JLabel lb1,lb2;
	private JTextField tf1,tf2;
	private JButton btn1,btn2;
	Card currCard;
	
	public Transfer(Card currCard){
		this.currCard=currCard;	
	
		lb1=new JLabel("转入账号：");
		lb2=new JLabel("转入金额：");
		tf1=new JTextField();
		tf2=new JTextField();
		JButton btn1=new JButton("确定");
		JButton btn2=new JButton("取消");
		
		btn1.addActionListener(this);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,2));
		
		p.add(lb1);
		p.add(tf1);
		p.add(lb2);
		p.add(tf2);
		p.add(btn1);
		p.add(btn2);
		this.add(p);
		this.setTitle("转账服务");
		this.setSize(300,130);
		this.setLocation(400, 150);
		this.setVisible(true);
		
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
 				Transfer.this.dispose();

			}
			
		});
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		int money;
		money=Integer.parseInt(tf2.getText());
		String in = tf1.getText();
		if(in.length()!=3) {
			JOptionPane.showMessageDialog(Transfer.this, "对不起，请输入3位账号数字！");
		} else if (!in.equals("111")&&!in.equals("222")&&!in.equals("333")) {
			JOptionPane.showMessageDialog(Transfer.this, "对不起，请输入生效的账号！");
		} else {
			int j;
			Card c = null;
			ArrayList<Card> listin = CardArray.getCardList();
			for (j = 0; j < listin.size(); j++) {
				c = listin.get(j);
				if (c.getCardID().equals(in)) {
					break;
				}
			}
			c.setBanlance(c.getBanlance() + money);
			CardArray.getCardList().set(j, c);

			System.out.println(c.getBanlance());

			if(currCard.getBanlance()>money){
				currCard.setBanlance(currCard.getBanlance()-money);
				JOptionPane.showMessageDialog(null, "恭喜你成功转账"+money+"元\n当前账户余额为："+currCard.getBanlance());
			}
			if(currCard.getBanlance()<money){
				JOptionPane.showMessageDialog(Transfer.this, "对不起，您的余额不足！");
			}
		}
		

	}
	

	}
