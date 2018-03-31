import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;


public class MenuForm extends JFrame{
   public static void main(String[] args){
      EventQueue.invokeLater(new Runnable(){
         public void run(){
            MenuForm f = new MenuForm();
            f.setVisible(true);
         }
      });
   }


   public MenuForm(){
   		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		setBounds(300,200,500,400);
   		setTitle("Student");
   		getContentPane().setLayout(null);
		JMenuBar menuBar = new JMenuBar();

   		JMenu menu1 = new JMenu("score");
   			JMenuItem menu1_1 = new JMenuItem("record score");
   			menu1.add(menu1_1);
   			menuBar.add(menu1);
   			menu1_1.addActionListener(new ActionListener(){
   				public void actionPerformed(ActionEvent event){
   					RandomFileGUI f = new RandomFileGUI();
   					f.setVisible(true);
   					f.setSize(500,400);
   					f.setLocation(300,200);
   					//f.addWindowListener(new WindowListener());    //HERE !!!!!!!
   				} 
   			});

   		JMenu menu2 = new JMenu("search");
   		JMenuItem menu2_1 = new JMenuItem("by name");
   		JMenuItem menu2_2 = new JMenuItem("by id");
   		menu2.add(menu2_1);
   		menu2.add(menu2_2);
   		menuBar.add(menu2);
         menu2_1.addActionListener(new ActionListener(){          //HERE !!!!!!
            public void actionPerformed(ActionEvent event){
               SearchByName s = new SearchByName();
               s.setVisible(true);
               s.setSize(500,400);
               s.setLocation(300,300);
            }
         });
         menu2_2.addActionListener(new ActionListener(){          //HERE !!!!!!
            public void actionPerformed(ActionEvent event){
               SearchByID i = new SearchByID();       
               i.setVisible(true);
               i.setSize(500,400);
               i.setLocation(300,300);
            }
         });

   		JMenu menu3 = new JMenu("exit");
   		JMenuItem menu3_1 = new JMenuItem("exit");
   		menu3.add(menu3_1);
   		menuBar.add(menu3);
   		menu3_1.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent event){
   				System.exit(0);
   			}
   		});
   	setJMenuBar(menuBar);
   }
}