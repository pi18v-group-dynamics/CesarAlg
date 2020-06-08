import javax.swing.*;
import java.util.Scanner;
import java.util.jar.JarFile;

public class Main extends JFrame {

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите сообщение которое надо зашифровать");
		String t=scanner.nextLine();
		System.out.println("Введите ключ");
		x=scanner.nextInt();
		System.out.println("Зашифрованное сообщение "+script(t));
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

}

