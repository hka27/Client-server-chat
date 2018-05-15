import java.net.*;
import java.io.*;

class server{
	public static void main(String args[]){
	try{	
	ServerSocket server=new ServerSocket(3000);
	Socket s=server.accept();

	System.out.println("Connected");

	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	DataInputStream dis= new DataInputStream(s.getInputStream());
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

	String cl = "";
	String usr = "Connected";
	String end = "bye";
	dos.writeUTF(usr);
	cl=dis.readUTF();
	System.out.println("client: "+cl);

	while(true){
		System.out.print("server: ");
		usr=br.readLine();
		dos.writeUTF(usr);
		cl=dis.readUTF();
		System.out.println("client: "+cl);
		if(end.equalsIgnoreCase(cl)){
			System.out.println("server: "+cl);
			dos.writeUTF(cl);
			break;
		}
	}
	if(cl=="bye" || cl=="Bye"){
		dos.writeUTF(cl);
		s.close();
	}
	dis.close();
	dos.close();

	}catch(Exception e){}
}
}
