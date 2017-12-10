import java.util.Scanner;
import java.io.*;
public class App{
	public static void main(String[] args){
		try{
			String aux = args[0];	
			if(aux.equals("-help") || aux.equals("-h")){
				System.out.println("----  USAGE  ---- ");
				System.out.println("java App [filename || -h || -help]");
				System.out.println("---- COMMAND ----\ninsert [1-n] [1-n] String \nremove [1-n] [1-n] String\n print \n ePrint [1-n] [1-n]");
				System.out.println("exit");
			

				System.exit(0);
			}
		}
		catch(Exception e){
			
		}
		
		
			
			Table t = null;
			Scanner in = new Scanner(System.in);
			while(in.hasNext()){
				String temp = in.next();
				if(t != null){
					if(temp.equals("insert"))t.insert(in.nextInt(), in.nextInt(), in.nextLine());
					if(temp.equals("remove"))t.remove(in.nextInt(), in.nextInt());
					if(temp.equals( "print"))t.print();
					if(temp.equals("eprint"))t.print(in.nextInt(), in.nextInt());
				}
				if(temp.equals("load")) t = Table.table_init_from_file(in.nextLine());
				if(temp.equals("create")) t = new Table(in.nextInt(), in.nextInt());
				if(temp.equals("exit")) System.exit(0);
				

			}
		
	}

}
