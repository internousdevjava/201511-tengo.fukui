import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		kuku:while(true){

			String strx=null;
			String stry=null;
			boolean flg;
			try{
				flg=true;
				while (flg) {
					System.out.println("Xの値を半角数字で入力してください");
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					strx=br.readLine();
					if(isNumber(strx)){
						// 数値の場合
						int i=Integer.parseInt(strx);
						if (i<=100 && i>=1) {
							break;
						}else{
							System.out.println("1～100までの値を入れてね！！");
							continue;
						}
					}else{
						// 文字列の場合
						System.out.println("数値じゃありません");
						continue;
					}
				}
					System.out.println("Xの値:"+strx);
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				flg=true;
				while(flg) {
					System.out.println("Yの値を半角数字で入力してください");
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					stry=br.readLine();
					if(isNumber(stry)){
						int j=Integer.parseInt(stry);
						if (j<=100 && j>=1) {
							break;
						}else{
							System.out.println("1～100までの値を入れてね！！");
							continue;
						}
					}else{
						System.out.println("数値じゃありません");
						continue;
					}
				}
					System.out.println("Yの値:"+stry);
			}catch(Exception e){
				e.printStackTrace();
			}
	
			int x=Integer.parseInt(strx);
			int y=Integer.parseInt(stry);
	
			for(int n=1;n<=y;n++){
				for(int m=1;m<=x;m++){
					
					for(int keta=(int)Math.log10(n*m)+1;keta<=5;keta++){
						System.out.print(" ");
					}
				/*	if(n*m<10){
						System.out.print("     ");
					}else if(n*m<100){
						System.out.print("    ");
					}else if(n*m<1000){
						System.out.print("   ");
					}else if(n*m<10000){
						System.out.print("  ");
					}else{
						System.out.print(" ");
					}*/
	
					System.out.print(n*m);
				}
	
				System.out.println("");
			}
			while (true) {
				
				try{
					System.out.println("まだ続けますか？\n[y]続ける\n[n]終わる");
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					strx=br.readLine();
					if (strx.equals("y")) {
						continue kuku;
					}else if (strx.equals("n")) {
						System.out.println("終了しました");
						break kuku;
					}else {
						System.out.println("もう一度お願いします");
						continue;
					}
				}catch(IOException e){
					System.out.println(e);
				}
			}
		
		}

	}

	public static boolean isNumber(String val) {
		String regex = "\\A[-]?[0-9]+\\z";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(val);
		return m1.find();
	}

}
