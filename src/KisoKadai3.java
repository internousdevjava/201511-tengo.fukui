import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String nab=null;
		boolean fl=true;
		while(fl){

	//リスト表示(下のif(nab)内に移動しました)
	/*	System.out.println("ーーふぁいる一覧ーー");
		File test=new File("C:\\KisoKadai3\\");
		String filelist[] = test.list();
	    for (int i = 0 ; i < filelist.length ; i++){
	      System.out.println(filelist[i]);
	    }
	    System.out.println("ーーーーーーーーーー");*/

	    System.out.println("\n[r]読み込み　[w]書き込み　[n]新規作成　[l]リスト表示　[f]終了");

		try{
			InputStreamReader is=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(is);
			nab=br.readLine();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println();
		}





	//read 読み込み
		if (nab.equals("r")) {
			System.out.println("読み込むファイル名を指定してください([99]でメニューに戻る)\n例:C:\\test\\test.txt");
			try{
				InputStreamReader is=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(is);
				String filena=br.readLine();
			//メニューに戻る
				if (filena.equals("99")) {
					System.out.println("メニューに戻ります");
					continue;
				}

		    	 File file=new File(filena);

		    	 if (!file.exists()) {
					System.out.println("ファイルが存在しません\n先に新規作成で作ってください");
					continue;
				}
		    	 if (file.isDirectory()) {
		    		 System.out.println("フォルダの一覧表示はメニューの[l]からお願いします");
				}

		    	  FileReader filereader = new FileReader(file);
		    	  BufferedReader br2 = new BufferedReader(filereader);

		    	  String str = br2.readLine();
		    	  System.out.println("\n～～～～～"+filena+"～～～～～\n");
		    	  while(str != null){
		    	    System.out.println(str);

		    	    str = br2.readLine();
		    	  }

		    	  br2.close();
		    	  System.out.println("\n～～～～～～～～～～\n");
		    }catch(FileNotFoundException e){
		    	  System.out.println(e);
		    }catch(IOException e){
		    	  System.out.println(e);
		    }

	//write 書き込み
		}else if(nab.equals("w")){
			try{
				boolean boo =true;
				String str1=null;
				String flg;

				System.out.println("書き込むファイル名を指定してください([99]でメニューに戻る)\n例:C:\\test\\test.txt");
				InputStreamReader is1=new InputStreamReader(System.in);
				BufferedReader br1=new BufferedReader(is1);
				str1=br1.readLine();

				File file=new File(str1);

				if (!file.exists()) {
					System.out.println("ファイルが存在しません\n先に新規作成で作ってください");
					continue;
				}
				if (!file.isFile()) {
					System.out.println("ファイル以外が選択されています");
					continue;
				}



			//メニューに戻る
				if (str1.equals("99")) {
					System.out.println("メニューに戻ります");
					continue;
				}

				while(true){
					System.out.println("[1]上書き[2]追記  *上書きを選択すると元の内容は消えてしまいます");
					InputStreamReader is2=new InputStreamReader(System.in);
					BufferedReader br2=new BufferedReader(is2);
					flg=br2.readLine();

					if (flg.equals("2")) {
						boo=true;
						break;
					}else if(flg.equals("1")){
						boo=false;
						break;
					}else{
						System.out.println("もう一度お願いします");
						continue;
					}
				}

				FileWriter filewriter = new FileWriter(file,boo);
				BufferedWriter bw = new BufferedWriter(filewriter);
				PrintWriter pw = new PrintWriter(bw);

				System.out.println("書き込む内容はなにかな？");
				String str=null;
				try{
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					str=br.readLine();
				}catch(Exception e){
					e.printStackTrace();
				}

				  pw.println(str);;

				  pw.close();
			}catch(IOException e){
				  System.out.println(e);
				  System.out.println("ファイルを選択できませんでした");
			}

	//new file 新規作成
		}else if (nab.equals("n")) {

			String flg=null;
			try{
				System.out.println("[1]すぐにファイルを作る　[2]絶対パスを指定する([99]でメニューに戻る)\n*おすすめは[2]です");
				InputStreamReader is2=new InputStreamReader(System.in);
				BufferedReader br2=new BufferedReader(is2);
				flg=br2.readLine();
			}catch(Exception e){
				e.printStackTrace();
			}
		//メニューに戻る
			if (flg.equals("99")) {
				System.out.println("メニューに戻ります");
				continue;
			}

			if (flg.equals("1")) {

	//相対パス作成（廃止予定）
		/*		System.out.println("テキスト名書けよ");
				String str=null;
				try{
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					str=br.readLine();
					File newfile=new File("C:\\KisoKadai3\\"+str+".txt");
					newfile.createNewFile();
				}catch(Exception e){
					e.printStackTrace();
				}*/

	//ローカルディスク内に作る
				System.out.println("テキスト名入力でテキストを作ります([99]でメニューに戻る)\n例:test.txt\n（テキストはこのローカルディスク内のKisoKadai3フォルダに作られます）");
				try{
					String str=null;
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					str=br.readLine();
				//メニューに戻る
					if (str.equals("99")) {
						System.out.println("メニューに戻ります");
						continue;
					}


					File fileh=new File("C:\\KisoKadai3\\"+str);

					File dir=new File(fileh.getParent());
					if(!dir.exists()){
						System.out.println("フォルダがありません。:"+fileh.getAbsolutePath());
						dir.mkdirs();
						System.out.println("フォルダを作成しました");
					} else {
						System.out.println("フォルダは既に存在します。");
					}

					if(fileh.exists()){
						System.out.println("ファイルは既に存在します。\n" + fileh.getAbsolutePath());
					}else{
						System.out.println("ファイルは存在しません。\n"+fileh.getAbsolutePath());
						try{
							if (fileh.createNewFile()){
								System.out.println("ファイルを作成しました");
							}else{
								System.out.println("作成失敗");
							}
						}catch(IOException e){
							System.out.println(e);
						}
					}

			/*		File newfile=new File("C:\\KisoKadai3\\"+str);
					newfile.createNewFile();*/
				}catch(Exception e){
					e.printStackTrace();
				}

			}else if(flg.equals("2")){

	//絶対パス指定作成

				try{

				System.out.println("絶対パスを入力してください([99]でメニューに戻る)\n例:C:\\test\\test.txt\n例(フォルダのみ)C:\\test\\\n");
				String file=null;
				try{
					InputStreamReader is=new InputStreamReader(System.in);
					BufferedReader br=new BufferedReader(is);
					file=br.readLine();


				//メニューに戻る
					if (file.equals("99")) {
						System.out.println("メニューに戻ります");
						continue;
					}

				}catch(Exception e){
					e.printStackTrace();
				}
					File fileh=new File(file);

					File dir=new File(fileh.getParent());


				if(!dir.exists()){
					System.out.println("フォルダがありません。:"+fileh.getAbsolutePath());
					dir.mkdirs();
					System.out.println("フォルダを作成しました");
				} else {
					System.out.println("フォルダは既に存在します。");
				}

				if(fileh.exists()){
					System.out.println("ファイルは既に存在します。\n" + fileh.getAbsolutePath());
				}else{
					System.out.println("ファイルは存在しません。\n"+fileh.getAbsolutePath());
					try{
						if (fileh.createNewFile()){
							System.out.println("ファイルを作成しました");
						}else{
							System.out.println("作成失敗");
						}
					}catch(IOException e){
						System.out.println(e);
					}
				}

				}catch (Exception e) {
					System.out.println(e);
					System.out.println();
				}

			}else{
				System.out.println("メニューに戻ります");
			}





	//リスト表示
		}else if (nab.equals("l")) {
			System.out.println("一覧表示したいフォルダを指定してください([99]でメニューに戻る)\n例:C:\\test\\mydir");
			String str=null;
			try{
				InputStreamReader is=new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(is);
				str=br.readLine();
			//メニューに戻る
				if (str.equals("99")) {
					System.out.println("メニューに戻ります");
					continue;
				}


				File test=new File(str+"\\");
				File filelist[] = test.listFiles();

				if (test.exists()) {
					if (test.isFile()) {
						System.out.println("フォルダを選択してください");
						continue;
					}
				}else{
					System.out.println("この名前のフォルダが存在しません\n先に新規作成で作ってください");
					continue;
				}
				System.out.println("[F]ファイル　[D]フォルダ");
				System.out.println("ーー"+str+"ーー");
			    for (int i = 0 ; i < filelist.length ; i++){
			    	 if (filelist[i].isFile()){
			    		 System.out.println("[F]"+filelist[i].getName());
			    		  }else if (filelist[i].isDirectory()){
			    			  System.out.println("[D]"+filelist[i].getName());
			    		  }else {
			    			  System.out.println("[?]"+filelist[i].getName());
			    		  }

			    }
			    System.out.println("ーーーーーーーーーー");

			}catch(FileNotFoundException e){
				System.out.println(e);
			}catch(Exception e){
				e.printStackTrace();
			}





	//終了とか
		}else if(nab.equals("f")){
			break;
		}else{
			System.out.println("メニューから選択してください");
			continue;
		}

		}
		System.out.println("終了します");











		// 文字列入力
	/*	String str=null;
		try{
			InputStreamReader is=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(is);
			str=br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}*/


		//メニューに戻る
	/*	if (str.equals("99")) {
			System.out.println("メニューに戻ります");
			continue;
		}*/


		//ファイル一覧表示
	/*	File test=new File("C:\\KisoKadai3\\");
		String filelist[] = test.list();
	    for (int i = 0 ; i < filelist.length ; i++){
	      System.out.println(filelist[i]);
	    }  */


		//ファイル新規作成
	/*	File newfile = new File("c:¥¥tmp¥¥newfile.txt");
		newfile.createNewFile();*/


		//ファイル読み込み
	/*	try{
	    	 File file=new File("C:\\KisoKadai3\\sample.txt");
	    	  FileReader filereader = new FileReader(file);
	    	  BufferedReader br = new BufferedReader(filereader);

	    	  String str = br.readLine();
	    	  while(str != null){
	    	    System.out.println(str);

	    	    str = br.readLine();
	    	  }


	    	  br.close();
	    }catch(FileNotFoundException e){
	    	  System.out.println(e);
	    }catch(IOException e){
	    	  System.out.println(e);
	    }*/


		//ファイル上書き[false]追記[true]
	/*	try{
			  File file=new File("C:\\KisoKadai3\\sample.txt");
			  FileWriter filewriter = new FileWriter(file,true);
			if (file.canWrite()) {
				System.out.println("OK");
			}else{
				System.out.println("NO");
			}

			  filewriter.write(str);

			  filewriter.close();
		}catch(IOException e){
			  System.out.println(e);
		}*/



				// ファイルパスを指定する
		/*		File file = new File(args[0]);
				// ディレクトリパスを取得する
				File dir=new File(file.getParent());

				if(!dir.exists()){
					System.out.println("フォルダがありません。:"+file.getAbsolutePath());
					dir.mkdirs();
					System.out.println("作成成功");
				} else {
					System.out.println("フォルダは既に存在します。");
				}

				if(file.exists()){
					System.out.println("ファイルは既に存在します。\n" + file.getAbsolutePath());
				}else{
					System.out.println("ファイルは存在しません。\n"+file.getAbsolutePath());
					try{
						if (file.createNewFile()){
							System.out.println("作成成功");
						}else{
							System.out.println("作成失敗");
						}
					}catch(IOException e){
						System.out.println(e);
					}
				}*/

	}

}











