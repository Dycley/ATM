package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import comm.Card;

public class Save extends JFrame implements ActionListener{
	private JLabel lb;
	private JTextField tf2;
	private JButton btn1,btn2;
	Card currCard;
	
	public Save(Card currCard){
		this.currCard=currCard;	
	
		lb=new JLabel("存入金额：");
		tf2=new JTextField(12);
		btn1=new JButton("确定");
		btn2=new JButton("取消");
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2,2));


		p.add(lb);
		p.add(tf2);
		p.add(btn1);
		p.add(btn2);
		btn1.addActionListener(this);
		
		this.add(p);
		this.setTitle("存款服务");
		this.setSize(300,130);
		this.setLocation(400, 150);
		this.setVisible(true);
		
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
 				Save.this.dispose();

			}
			
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int money=0;
		System.out.println(tf2.getText());
		money=Integer.parseInt((tf2.getText()==""||tf2.getText()==null)?"0":tf2.getText());
		currCard.setBanlance(currCard.getBalance()+money);
		JOptionPane.showMessageDialog(null, "恭喜你成功存款"+money+"元\n当前账户余额为："+currCard.getBalance());
		
	}
}

