import java.io.*;

public class Table{

	private String[][] table;
	private int row;
	private int col;

	public Table(int row, int col){
		table = new String[row][col];
		this.row = row;
		this.col = col;	
	}
	//Reads file and returns table
	
	public static Table table_init_from_file(String file_name){
		try{ 	//reads file
			BufferedReader reader = new BufferedReader(new FileReader(new File(file_name)));
			String line;
			String text = "";
			int col, row;
			col = row = 0;
			//row and col count
			while((line = reader.readLine()) != null){
				text += line;
				row++;
				for(int cont = 0; cont < line.length(); cont++){
					if(line.charAt(cont) == ',')
						col++;
				}
			}
		
			col = (col / row) + 1;
		
			Table t = new Table(row, col);
			t.populate(text);

			return t;
		}catch(IOException e){
			System.out.println("File doesn't exist.");
			e.printStackTrace();
			return null;
		}	
			
	}
	private void populate(String text){
		//will fill the array
		String[] aux = read_elements(text);
		String[][] j = get_table();
		int c = 0;
		
		for(int cont = 0; cont < row; cont ++){
			for(int i = 0; i < Math.ceil(aux.length/get_row()); i++){
				j[cont][i] = aux[c];
								
				c++;			
			}
		}
		set_table(j);
		
		
	}
	private String[] read_elements(String text){
		String aux[] = new String[get_col() * get_row()];
		int i = 0;
		int start = 0;
		for(int cont = 0; cont < text.length(); cont++){
		
			if(text.charAt(cont) == ','){
				aux[i] = text.substring(start, cont);
	
				i++;
				start = cont+2;
			}
			if(text.charAt(cont) == '|'){
				aux[i] = text.substring(start, cont);

				i++;
				start = cont+1;
			}
		}
		return aux;
	}


	public int get_col(){
		return this.col;
	}
	public int get_row(){
		return this.row;
	}
	public String[][] get_table(){
		return this.table;
	}
	public void set_table(String[][] s){
		this.table = s;
	}
	public void insert(int a, int b, String s){
		String[][] aux = get_table();
		aux[a-1][b-1] = s;
		set_table(aux);
	}
	public void remove(int a, int b){
		String[][] aux = get_table();
		aux[a-1][b-1] = "";
		set_table(aux);
	}
	public void print(){
		String[][] aux = get_table();

		for(int i = 0; i < get_row(); i++){
			for(int j = 0; j < get_col(); j++){
				System.out.print(aux[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
