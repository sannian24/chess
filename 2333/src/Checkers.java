package src;

import javax.swing.*;
import java.awt.event.*;

public class Checkers extends JFrame implements ActionListener{


    private static final long serialVersionUID = 6827040500650074373L;
    ChessBoard cb;
    Robot robot;
    JPanel top = new JPanel();
    JButton start = new JButton("New");
    JButton bar = new JButton();
    JComboBox box = new JComboBox();
    JLabel level = new JLabel("Level: ");
    JButton quit = new JButton("Quit");

    public static void main(String[] args){
        new Checkers();
    }

    public Checkers(){
        robot = new Robot();
        cb = new ChessBoard(robot);
        robot.setBorad(cb);
        this.setLayout(null);
        cb.setLocation(0,35);

        top.setBounds(0,0,480,35);
        top.setLayout(null);
        top.add(start);
        top.add(box);
        top.add(bar);
        top.add(level);
        top.add(quit);
        start.setBounds(0,0,80,30);
        start.addActionListener(this);

        level.setBounds(90,0,60,30);
        bar.setBounds(0,30,480,5);
        bar.setEnabled(false);

        box.setBounds(135,0,80,30);
        box.addItem("Easy");
        box.addItem("Normal");
        box.addItem("Hard");
        box.addActionListener(this);


        quit.setBounds(410,0,70,30);
        quit.addActionListener(this);

        this.add(top);
        this.add(cb);
        this.setBounds(100,100,490,545);
        this.setTitle("QI YU SUSSEX");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton){
            JButton jb = (JButton)e.getSource();
            if(jb.equals(start)){ //新游戏
                Util.win = false;
                cb.init();
                cb.setVisible(true);
                cb.repaint();
            }

            else if(jb.equals(quit)){
                int i = JOptionPane.showConfirmDialog(null, "Are you sure to quit?");
                if(i==0)
                    System.exit(0);

            }
            
        }
        if(e.getSource() instanceof JComboBox){//设置难度
            int index = box.getSelectedIndex();
            robot.setLevel(index);
        }
	}

}