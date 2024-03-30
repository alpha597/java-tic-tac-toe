import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel  buttonPanel = new JPanel();
    JLabel textfeild = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1;
    public TicTacToe(){
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800,800);
         frame.getContentPane().setBackground(Color.GRAY);
         frame.setLayout(new BorderLayout());
         frame.setVisible(true);
         textfeild.setBackground(Color.BLACK);
         textfeild.setForeground(Color.WHITE);
         textfeild.setFont(new Font("Ink free",Font.BOLD,75));
         textfeild.setHorizontalAlignment(JLabel.CENTER);
         textfeild.setText("Tic-Tac-Toe");
         textfeild.setOpaque(true);
         title_panel.setLayout(new BorderLayout());
         title_panel.setBounds(0,0,800,800);
         title_panel.add(textfeild);
         frame.add(title_panel,BorderLayout.NORTH);
         for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
         }
         buttonPanel.setLayout(new GridLayout(3,3));
         buttonPanel.setBackground(Color.BLACK);
         frame.add(buttonPanel);
         firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(player1){
                    if(buttons[i].getText()== ""){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                        player1 = false;
                        textfeild.setText("O,s Turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()== ""){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player1 = false;
                        textfeild.setText("X,s Turn");
                        check();
                    }
                }
            }
        }
        
    }
    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt() ==0){
            player1=true;
            textfeild.setText("X Turn");
        }
        else{
            player1 = false;
            textfeild.setText("O Turn");
        }

    }
    public void check(){
        if(buttons[0].getText()=="X" && buttons[1].getText() =="X"&& buttons[2].getText()=="X"){
           xWins(0,1,2);
        }
        if(buttons[3].getText()=="X" && buttons[4].getText() =="X"&& buttons[5].getText()=="X"){
            xWins(3,4,5);
         }        
         if(buttons[7].getText()=="X" && buttons[8].getText() =="X"&& buttons[9].getText()=="X"){
            xWins(7,8,9);
         }

         if(buttons[0].getText()=="X" && buttons[3].getText() =="X"&& buttons[6].getText()=="X"){
            xWins(0,3,6);
         }
         if(buttons[1].getText()=="X" && buttons[4].getText() =="X"&& buttons[7].getText()=="X"){
             xWins(1,4,7);
          }        
          if(buttons[2].getText()=="X" && buttons[5].getText() =="X"&& buttons[8].getText()=="X"){
             xWins(2,5,8);
          }
          if(buttons[0].getText()=="X" && buttons[4].getText() =="X"&& buttons[8].getText()=="X"){
            xWins(0,4,8);
         }
         if(buttons[2].getText()=="X" && buttons[4].getText() =="X"&& buttons[6].getText()=="X"){
            xWins(2,4,6);
         }
         
         
         if(buttons[0].getText()=="O" && buttons[1].getText() =="O"&& buttons[2].getText()=="O"){
            oWins(0,1,2);
         }
         if(buttons[3].getText()=="O" && buttons[4].getText() =="O"&& buttons[5].getText()=="O"){
             oWins(3,4,5);
          }        
          if(buttons[7].getText()=="O" && buttons[8].getText() =="O"&& buttons[9].getText()=="O"){
             oWins(7,8,9);
          }
 
          if(buttons[0].getText()=="O" && buttons[3].getText() =="O"&& buttons[6].getText()=="O"){
             oWins(0,3,6);
          }
          if(buttons[1].getText()=="O" && buttons[4].getText() =="O"&& buttons[7].getText()=="O"){
              oWins(1,4,7);
           }        
           if(buttons[2].getText()=="O" && buttons[5].getText() =="O"&& buttons[8].getText()=="O"){
              oWins(2,5,8);
           }
           if(buttons[0].getText()=="O" && buttons[4].getText() =="O"&& buttons[8].getText()=="O"){
             oWins(0,4,8);
          }
          if(buttons[2].getText()=="X" && buttons[4].getText() =="X"&& buttons[6].getText()=="X"){
             oWins(2,4,6);
          }
          int count=0;
          for(int i=0;i<9;i++){
            if(buttons[i].getText()=="X" || buttons[i].getText()=="O" ){
                count++;
            }
          }
          if(count ==9){
            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textfeild.setText("Match Draw");
    
          }
 


    }
    public void xWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfeild.setText("X wins");


    }
    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfeild.setText(" O wins");


    }
    
}
