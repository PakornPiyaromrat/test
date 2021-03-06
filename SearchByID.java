import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class SearchByID extends JFrame implements ActionListener {
	int id,sid; String dept, name; double mid, fin;
   	TextField text1,text2, text3, text4, text5;
   	Button clear,search,back; 
   	RandomAccessFile file;

   	SearchByID(){   
   		openFile();   
    	setTitle("Search By ID");
    	setLayout(new GridLayout(10,2,10,5));		//rows,color,hgap,vgap
	  	add(new Label("Search ID   "));
      	add(text1 = new TextField(" ",20));
	  	add(new Label("Name   "));
     	add(text2 = new TextField(" ",20)); text2.setEditable(false);
     	add(new Label("Dept  "));
    	add(text3 = new TextField(" ",20)); text3.setEditable(false);
      	add(new Label("Midterm  "));
      	add(text4 = new TextField(" ",20)); text4.setEditable(false);
      	add(new Label("Final   "));
      	add(text5 = new TextField(" ",20)); text5.setEditable(false);

 	  	add(clear = new Button("Clear"));
	 	add(search = new Button("Search"));
	  	add(back = new Button("Back"));
	  
	  	clear.addActionListener(this);    
	  	search.addActionListener(this);
	  	back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
      if(e.getSource() == search)
      	{	sid = Integer.parseInt(text1.getText().trim());
      		searchFile(sid);
      	}
      else if(e.getSource() == clear)
      	{clearText();}

      else if(e.getSource() == back)
      	{	closeFile();
      		setVisible(true);
      		dispose();
      		MenuForm f = new MenuForm();
      		f.setVisible(true);
      	}
   	}

   	public void clearText(){
		text1.setText(" ");
		text2.setText(" ");
	    text3.setText(" ");
		text4.setText(" ");
		text5.setText(" ");
	}

	public void searchFile(int sid){
		try{file.seek(0);
			while(true){
				id = file.readInt();
				dept = file.readUTF();
				name = file.readUTF();
				mid = file.readDouble();
				fin = file.readDouble();

				if(id == sid){
					text2.setText(name);
					text3.setText(dept);
					text4.setText(String.valueOf(mid));
					text5.setText(String.valueOf(fin));
					break;
				}
			}
		}
		catch(EOFException e){text2.setText("not found");}
		catch(IOException e){System.out.println("Error read to file");}

	}

	public void closeFile(){ 
		try { file.close();}
	    catch(IOException e) 
			{System.out.println("ERROR CLOSING FILE");System.exit(1);} 
	}

	public void openFile(){
		boolean success=false ;
    	do{	try
		    	{	String filename = JOptionPane.showInputDialog("enter filename");  
		      		file = new RandomAccessFile(filename,"rw");
			  		success = true;   }
          	catch (IOException e)
		     		{System.out.println("File cannot Open");
		      	success = false;}
       }while (!success);
 	}

  	public static String formText(String x, int k){
  		int p = x.length();
	 	for (int i = p+1;i <= k ;i++ )
	    		x = x+" ";
	 	return x;  
	} 

	public static void main(String[] args) throws IOException{
		SearchByID f = new SearchByID(); 
		f.setVisible(true);  
    	f.setSize(500,400);
		f.setLocation(300,200);
		
	}
}
