import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        JFrame frame=new JFrame("Complexity Tool");
        JLabel voidLabel=new JLabel();
        voidLabel.setBounds(100,100,100,20);
        JLabel loopLabel=new JLabel();
        loopLabel.setBounds(100,100,100,20);

        JButton button=new JButton("Click Here");
        frame.setBounds(500,500,500,500);
        button.setBounds(50,100,95,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try{
                        File file= new File("D:\\eclipse-workspace\\Manoo\\src\\Rectangle.java");
                        Scanner input=new Scanner(file);
                        int voidCount=0;
                        int loopCount=0;
                        int intCount=0;

                        while (input.hasNext()){
                            String word=input.next();
                            if (word.equals("void")){
                                voidCount++;
                            }
                            else if (word.equals("public")){
                                loopCount++;
                            }else if(word.equals("int")){
                                intCount++;
                            }else if(word.equals("(int")){
                                intCount++;
                            }

                        }
                        int sum=intCount+voidCount+loopCount;
                        if(sum==10){
                            System.out.println("Complex Program");
                        }else if(sum<10){
                            System.out.println("Less Complex Program");
                        }

                        System.out.println("Void : "+voidCount + ", Loop : "+loopCount + ", Int : "+intCount);

                    }
                    catch (IOException io){
                        io.printStackTrace();
                    }
            }
        });

        frame.add(button);
        frame.add(voidLabel);
        frame.add(loopLabel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}