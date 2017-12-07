import java.util.Scanner;
import java.io.*;
public class App{
	public static void main(String[] args){
		if(args[0].equals("-help") || args[0].equals("-h")){
			System.out.println("----  USAGE  ---- ");
			System.out.println("java App [filename || -h || -help]");
			System.out.println("---- COMMAND ----\ninsert [1-n] [1-n] String \nremove [1-n] [1-n] String\n print \n ePrint [1-n] [1-n]");
			System.out.println("exit");
			

			System.exit(0);
		}
			
			Table t = Table.table_init_from_file(args[0]);	
			Scanner in = new Scanner(System.in);
			while(in.hasNext()){
				String temp = in.next();
				if(temp.equals("exit")) System.exit(0);
				if(temp.equals("insert"))t.insert(in.nextInt(), in.nextInt(), in.nextLine());
				if(temp.equals("remove"))t.remove(in.nextInt(), in.nextInt());
				if(temp.equals( "print"))t.print();
				if(temp.equals("eprint"))t.print(in.nextInt(), in.nextInt());
			}
		
	}

}
