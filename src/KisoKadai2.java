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
public class KisoKadai2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		kazu:while(true){
		
			String str=null;
			int ran = (int)(Math.random()*100);
			ran+=1;
			int count=0;
			boolean flg;
			try{
				flg=true;
				while (flg) {
					System.out.println("半角で数値を入力してください");
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					str=br.readLine();
					if(isNumber(str)){
						// 数値の場合
						count+=1;
						int i=Integer.parseInt(str);
						if (i<=100 && i>=1) {
							if (ran-i<0) {
								System.out.println("もっと小さい数だよ");
								continue;
							}else if (ran-i>0) {
								System.out.println("もっと大きい数だよ");
								continue;
							}
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
				System.out.println("正解");
				System.out.println(count+"回かかったよ");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			while (true) {
				
				try{
					System.out.println("まだゲームを続けますか？\n[y]続ける\n[n]終わる");
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					str=br.readLine();
					if (str.equals("y")) {
						continue kazu;
					}else if (str.equals("n")) {
						System.out.println("終了しました");
						break kazu;
					}else {
						System.out.println("もう一度入力してください");
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
