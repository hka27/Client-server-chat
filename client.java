import java.net.*;
import java.io.*;


class client{
	public static void main(String args[]){
	try{	
	Socket s=new Socket("localhost",3000);
	
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	DataInputStream dis= new DataInputStream(s.getInputStream());
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

	String usr="", cl;
	String end = "bye";
	cl=dis.readUTF();
	System.out.println(cl);
	while(true){
		System.out.print("client: ");
		usr=br.readLine();
		dos.writeUTF(usr);
		cl=dis.readUTF();
		System.out.println("server: "+cl);
		if(end.equalsIgnoreCase(usr)){
			break;
		}
	}
	cl=dis.readUTF();
	System.out.println("server: "+cl);
	
	dos.close();
	dis.close();

	}catch(Exception e){}
}
}
