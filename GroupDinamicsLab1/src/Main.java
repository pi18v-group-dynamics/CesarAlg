import javax.swing.*;
import java.util.Scanner;
import java.util.jar.JarFile;

public class Main extends JFrame {

	public static void main(String[] args){
		System.out.println("1-зашифровка\n2-расшифровка");
		Scanner scanner = new Scanner(System.in);
		int enter=scanner.nextInt();
		if(enter==1){
			scanner = new Scanner(System.in);
			System.out.println("Введите сообщение которое надо зашифровать");
			String t=scanner.nextLine();
			scanner = new Scanner(System.in);
			System.out.println("Введите ключ");
			x=scanner.nextInt();
			System.out.println("Зашифрованное сообщение "+script(t));
		}
		else{
			scanner = new Scanner(System.in);
			System.out.println("Введите сообщение которое надо зашифровать");
			String t=scanner.nextLine();
			scanner = new Scanner(System.in);
			System.out.println("Введите ключ");
			x=scanner.nextInt();
			System.out.println("Зашифрованное сообщение "+descript(t));
		}
	}

	static char[] alfavitEn=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static int x;
    static public String script(String y){
    	char[] str=y.toCharArray();
    	int j=0;
		for(int i =0;i<y.length(); i++){
			if(str[i]==' ') i++;
			while(alfavitEn[j]!=str[i])
				j++;
			int n=j+x;
			if(n<alfavitEn.length)
				str[i]=alfavitEn[n];
			else str[i]=alfavitEn[n-26];
			j=0;
		}
		return String.valueOf(str);
	}
	static public String descript(String y){
		char[] str=y.toCharArray();
		int j=0;
		for(int i=0;i<y.length();i++){
			if(str[i]==' ') i++;
			while(alfavitEn[j]!=str[i])
				j++;
			int n=j-x;
			if(n<0)str[i]=alfavitEn[n+26];
			else if(n<alfavitEn.length)
				str[i]=alfavitEn[n];
			j=0;
		}
		return String.valueOf(str);
	}
}

