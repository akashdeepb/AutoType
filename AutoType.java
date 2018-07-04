import java.util.Scanner;
import java.io.*;
public class AutoType {
	public String file;

	//Constructor for AutoType
	public AutoType(){
		file=getFile();
		getCode();
	}
	
	//Function to Print the code extracted from File
	public void print(String cline){
		try{
			for(int i=0;i<cline.length();i++){
				System.out.print(cline.charAt(i));
				Thread.sleep(100);
			}
			System.out.print("\n");
		}catch(InterruptedException ex){
			System.err.println("\n\n -- Error while Printing -- \n");
		}
	}

	//Function to Get Filename from the User
	public String getFile() {
		String fname;
		Scanner sc=new Scanner(System.in);
		System.out.print("\n\n Enter the File name : ");
		fname=sc.next();
		return fname;
	}

	//Function to Get Code from the given Filename
	public void getCode(){
		try{
			BufferedReader in=new BufferedReader(new FileReader(file));
			String line;
			while((line=in.readLine())!=null)
				print(line);
			in.close();
		}catch(FileNotFoundException ex){
			System.err.println("\n\n -- File Not Found -- \n\n");
		}
		catch(IOException ex){
			System.out.println("\n\n Error Reading File");
		}
	}

	//Main Function of AutoType
	public static void main(String[] args){
		AutoType a=new AutoType();
	}
}
