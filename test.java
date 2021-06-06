import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import java.awt.event.*;
class test{
    static JFrame frame;
    static Container c;
	public static void main(String[] args) {
    frame=new JFrame("ROCK-PAPER-scissors");
	frame.setSize(530,665);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    c=frame.getContentPane();
    c.setLayout(null);
    c.setBackground(Color.green);
    make obj=new make();
    c.add(obj);
	}
}

class make extends JPanel implements ActionListener{
	Image rock_img,paper_img,scissors_img; 
	JButton rock_bt=new JButton("ROCK");
	JButton paper_bt=new JButton("PAPER");
	JButton scissors_bt=new JButton("scissors");
	Random rand=new Random();
	int comp;
	Boolean rock_status=false,paper_status=false,scissors_status=false;
    String comp_move,player_move;
    int player_score=0,comp_score=0;
public void paint(Graphics g){
super.paint(g);
try{
rock_img=ImageIO.read(new File("C:/Users/Arnab Naha/Desktop/gAmE/rock-paper-scissors/rock.png"));
paper_img=ImageIO.read(new File("C:/Users/Arnab Naha/Desktop/gAmE/rock-paper-scissors/paper.png"));
scissors_img=ImageIO.read(new File("C:/Users/Arnab Naha/Desktop/gAmE/rock-paper-scissors/scissors.png"));
}catch(Exception e){}
g.setColor(Color.white);
g.drawLine(0,275,505,275);
g.setColor(Color.cyan);
g.setFont(new Font("Arial",Font.BOLD,30));
g.drawString("COMPUTER:"+String.valueOf(comp_score),0,600);
g.drawString("YOU:"+String.valueOf(player_score),360,600);
g.setFont(new Font("Arial",Font.BOLD,15));
g.drawString("COMPUTER",4,15);
g.drawString("YOU",4,290);
selection(g);
 }
make(){
    this.setBounds(5,6,505,610);
    this.setLayout(null);
    this.setBackground(Color.black);
    position();
    this.add(rock_bt);
    this.add(paper_bt);
    this.add(scissors_bt);
    rock_bt.addActionListener(this);
    paper_bt.addActionListener(this);
    scissors_bt.addActionListener(this);
  }
public void position(){
rock_bt.setBounds(0,533,171,30);rock_bt.setFont(new Font("Arial",Font.BOLD,25));
paper_bt.setBounds(171,533,171,30);paper_bt.setFont(new Font("Arial",Font.BOLD,25));
scissors_bt.setBounds(342,533,171,30);scissors_bt.setFont(new Font("Arial",Font.BOLD,25));
  }  
public void selection(Graphics g){
if(rock_status==true)
	g.drawImage(rock_img,150,310,null);
if(paper_status==true)
	g.drawImage(paper_img,150,310,null);
if(scissors_status==true)
	g.drawImage(scissors_img,150,310,null);
if(comp==1){
    g.drawImage(rock_img,120,30,null);
    
    }
if(comp==2){
    g.drawImage(paper_img,120,30,null);
    }
if(comp==3){
    g.drawImage(scissors_img,120,30,null);
   }

 }
public void actionPerformed(ActionEvent  ev){
if(ev.getSource()==rock_bt){
    rock_status=true;paper_status=false;scissors_status=false;
    comp=rand.nextInt(3)+1;
    player_move="rock";
    if(comp==1)  comp_move="rock";
    if(comp==2)  comp_move="paper";
    if(comp==3)  comp_move="scissors";
    check();
    repaint();
    }
if(ev.getSource()==paper_bt){
    rock_status=false;paper_status=true;scissors_status=false;
    comp=rand.nextInt(3)+1;
    player_move="paper";  
    if(comp==1)  comp_move="rock";
    if(comp==2)  comp_move="paper";
    if(comp==3)  comp_move="SCISSORS";
    check();
    repaint();
    }
if(ev.getSource()==scissors_bt){
    rock_status=false;paper_status=false;scissors_status=true;  
    comp=rand.nextInt(3)+1;
    player_move="scissors";
    if(comp==1)  comp_move="rock";
    if(comp==2)  comp_move="paper";
    if(comp==3)  comp_move="scissors";
    check();
    repaint();
    }
  }
public void check(){
if(player_move=="rock" && comp_move=="scissors")
    player_score++;
if(player_move=="paper" && comp_move=="rock")
    player_score++;
if(player_move=="scissors" && comp_move=="paper")
    player_score++;

if(comp_move=="rock"  &&  player_move=="scissors")
    comp_score++;
if(comp_move=="paper"  &&  player_move=="rock")
    comp_score++;
if(comp_move=="scissors"  &&  player_move=="paper")
    comp_score++;
 }
}