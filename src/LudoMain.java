

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.GroupLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class LudoMain extends JFrame implements MouseListener, ActionListener  {
	static GameEngine GE = new GameEngine();
	static LudoMain frame1;

	
	 static JButton exitGame;
	 static JButton newGame;
	 private static JPanel jp;
	 static String situation = "New Game";

	static Thread a;
	private Image dbImage;
    private Graphics dbg;
    private Image back;
    private Image face;
    private Image face1;
    Rectangle diceButton;
    static Rectangle Counter1;
    static Rectangle Counter3;
    static PCCounter PC;
    PlayerCounter player;
	
	
	public LudoMain(){
		
		Counter1 = new Rectangle(760,650, 55, 55);
		diceButton = new Rectangle(100,90,100,70);
		
		
		Counter3 = new Rectangle(210,200, 55, 55);
		
		player = new PlayerCounter(Counter1,Counter3,diceButton);
		try {
			PC = new PCCounter(Counter3,Counter1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				setSize(1024,730);
		this.setBackground(Color.red);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addMouseListener(this);
	}
	
	
	
	public static void messageFrame(){
		
		final JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		{
			jp = new JPanel();
			GroupLayout jpLayout = new GroupLayout((JComponent)jp);
			jp.setLayout(jpLayout);
			frame.getContentPane().add(jp, BorderLayout.CENTER);
			{
				newGame = new JButton();
				newGame.setText(situation);
				newGame.addActionListener((new ActionListener(){
					public void actionPerformed(ActionEvent e){
						frame1 = new LudoMain();
						frame1.setVisible(true);
						
						a = new Thread(PC);
						a.start();
						frame.setVisible(false);
					}
				}));
			}
			{
				exitGame = new JButton();
				exitGame.setText("Exit Game");
				exitGame.addActionListener((new ActionListener(){
					public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				}));
			}
			jpLayout.setHorizontalGroup(jpLayout.createSequentialGroup()
				.addContainerGap(102, 102)
				.addGroup(jpLayout.createParallelGroup()
				    .addGroup(jpLayout.createSequentialGroup()
				        .addComponent(newGame, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addComponent(exitGame, GroupLayout.Alignment.LEADING, 0, 149, Short.MAX_VALUE))
				.addContainerGap(139, 139));
			jpLayout.setVerticalGroup(jpLayout.createSequentialGroup()
				.addContainerGap(106, 106)
				.addComponent(newGame, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
				.addGap(23)
				.addComponent(exitGame, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(158, Short.MAX_VALUE));
		}
	}
	
	
	
	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g){
			back = new ImageIcon("back.jpg").getImage();
			face = new ImageIcon("mohre-Green copy.png").getImage();
			face1 = new ImageIcon("mohre-Blue copy.png").getImage();

		g.drawImage(back, 0, 0, this);
			g.drawImage(face, Counter1.x, Counter1.y, this);
			g.drawImage(face1, Counter3.x, Counter3.y, this);
			g.setColor(Color.BLACK);
			g.fill3DRect(diceButton.x,diceButton.y,diceButton.width,diceButton.height,true);
			g.setColor(Color.WHITE);
			g.drawString("Roll Dice", diceButton.x+20, diceButton.y+30);
			GE.paint(g);
			
			repaint();
			
	}
	

	public static void main(String[] args) {
		messageFrame();

	}


	public void mouseClicked(MouseEvent e) {
	
	player.mouseClicked(e);
	
	}
	
	


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {
		
	}


	public void mouseReleased(MouseEvent arg0) {
		
	}




	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newGame){
			
		}
		else
			System.exit(0);
		
	}

}
