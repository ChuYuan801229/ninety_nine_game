
import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class ninety_nine {
	
	/**
	 * ���J�P�ƶq
	 */
	private static ArrayList<Integer> cardList = new ArrayList<Integer>();
	
	
	/**
	 * ���a
	 */
	private static ArrayList<Integer> playerone = new ArrayList<Integer>();
	private static ArrayList<Integer> playertwo = new ArrayList<Integer>();
	private static ArrayList<Integer> playerthree = new ArrayList<Integer>();
	private static  ArrayList<Integer> playerfour = new ArrayList<Integer>();
	/**
	 * ����
	 */
	private static  ArrayList<Integer> score = new ArrayList<Integer>();
	/**
	 * �Ѿl�P
	 */
	private static  ArrayList<Integer> owncard = new ArrayList<Integer>();
	
	private static int sum = 0;
	private static int total = 99;
	
	/**
	 * �C���}�l
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Let's start 99 game!");
		System.out.print("Please enter your name:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println("Welcom"+" "+name+"!");
		System.out.println("We have 4 people, it is deal now");
		turnplayer();
		 
	}

	private static void turnplayer() {
		while(grade()<99){
			player();
			continue;
		}
	}
	
	/**
	 * �d���|�Ӫ��A13�ӼƦr�@52�i
	 * @param cardList
	 */
	private static void card(ArrayList<Integer> cardList) {
		for(int i =1; i<5; i++) {
			for(int j=1; j<14; j++) {
				cardList.add(j);
			}
		}
		getcard(cardList);
	}
	/**
	 * �Ĥ@�^�C�Ӫ��a�⤤���P��
	 * @param cardList
	 */
	private static void getcard(ArrayList<Integer> cardList) {
		 int[] random = new int[20];
		 
			 for(int j=0; j<20; j++){
				random[j]=(int)Math.floor(Math.random()*52);
				for(int k=j; k<j; j++){
					if(random[k]==random[j]){
						random[k]=(int)Math.floor(Math.random()*52);
						owncard.add(random[k]);
					}
				}
				if(j<5){
					playerone.add(cardList.get(random[j]));
				}else if(5<=j && j<10){
					playertwo.add(cardList.get(random[j]));
				}else if(10<=j && j<15){
					playerthree.add(cardList.get(random[j]));
				}else if(14<j){
					playerfour.add(cardList.get(random[j]));
				}
			 }
			 
	}
	/**
	 * ��ܪ��a�P��
	 */
	private static void player() {
		
		card(cardList);
		System.out.println("�ڪ��P��:");
		for( int i= 1; i<6; i++) {
			System.out.print("["+i+"] "+playerfour.get(i-1)+" ");
		}
		System.out.println("\n");
		outputcard();
		computer();
		
	}
	
	/**
	 * ���ƭp��A�P�_�O�_�U�@��
	 * @return
	 */
	private static int grade() {
		
		String[] playname = {"player","playerone","playertwo","playerthree"};
		summ(playname);
		System.out.println ("score:"+sum );
		score.clear();
		if(sum<=total){
			System.out.print("----------------NEXT----------------");
			return sum;		
		}else{
			System.out.print("----------------END----------------");
		}
		return total;
	}

	private static void summ(String[] playname) {
		for(int j :score){
			
			sum =sum+j; 
			
			while(sum>99){
				int [] other = {j};
				System.out.println(playname[4-other.length]+"�z�F");
//				System.out.println(5-other.length);
				break;
			}
		}
	}
	
	/**
	 * �q���X�P
	 */
	private static void computer() {
		int[] random = new int[3];
		 for(int w = 0; w<3; w++){
			 random[w] = (int)Math.floor(Math.random()*4+1);
		 }
		 score.add(playerone.get(random[0]));
		 score.add(playertwo.get(random[1]));
		 score.add(playerthree.get(random[2]));
		 System.out.println("�q��1�X�P: "+playerone.get(random[0])+" ");
		 System.out.println("*****************");
		 System.out.println("�q��2�X�P: "+playertwo.get(random[1])+" ");
		 System.out.println("*****************");
		 System.out.println("�q��3�X�P: "+ playerthree.get(random[2])+" ");
		 System.out.println("*****************");
		 removecard(random);
//		 takecard(Leftover);
	}

	private static void removecard(int[] random) {
		 playerone.remove(playerone.get(random[0]));
		 playertwo.remove(playertwo.get(random[1]));
		 playerthree.remove(playerthree.get(random[2]));
	}
	
	/**
	 * ���a���w�X�P
	 */
	private static int outputcard() {
		int choose = 0;
		System.out.println("\n");
		System.out.print("��ܥX�P: ");
		Scanner scanner = new Scanner(System.in);
		choose =scanner.nextInt();
		
		switch(choose){
		case 1 :
			System.out.print("��ܥX�P:");
			System.out.println(playerfour.get(0));
			System.out.println("*****************");
			score.add(playerfour.get(0));
			playerfour.remove(playerfour.get(0));
			break;
		case 2 :
			System.out.print("���a�X�P:");
			System.out.println(playerfour.get(1));
			System.out.println("*****************");
			score.add(playerfour.get(1));
			playerfour.remove(playerfour.get(1));
			break;
		case 3 :
			System.out.print("���a�X�P:");
			System.out.println(playerfour.get(2));
			System.out.println("*****************");
			score.add(playerfour.get(2));
			playerfour.remove(playerfour.get(2));
			break;
		case 4 :
			System.out.print("���a�X�P:");
			System.out.println(playerfour.get(3));
			System.out.println("*****************");
			score.add(playerfour.get(3));
			playerfour.remove(playerfour.get(3));
			break;
		case 5 :
			System.out.print("���a�X�P:");
			System.out.println(playerfour.get(4));
			System.out.println("*****************");
			score.add(playerfour.get(4));
			playerfour.remove(playerfour.get(4));
			break;
		}
		return choose;
	}
}
