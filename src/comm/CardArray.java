package comm;

import java.util.ArrayList;

public class CardArray {
	private static ArrayList<Card> cardList;
	public CardArray(){
		if(cardList==null){
			cardList=new ArrayList<Card>();
			cardList.add(new Card("111","111",10));
			cardList.add(new Card("222","222",100));
			cardList.add(new Card("333","333",1000));
		}
	}
	public static ArrayList<Card> getCardList(){
		new CardArray();
		return cardList;
	}
}
