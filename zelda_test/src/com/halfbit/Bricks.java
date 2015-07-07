package com.halfbit;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bricks extends JFrame {
	Zelda zelda;
	public Bricks() {
		JPanel panel = (JPanel) this.getContentPane();
		panel.setPreferredSize(new Dimension(800,600));
		panel.setLayout(null);
		zelda = new Zelda(800,600);
		panel.add(zelda);

		setTitle("Zelda: Java Edition Indev 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setLocationRelativeTo(null);
		
		pack();
		setResizable(false);
		
		zelda.init();
		setVisible(true);
        requestFocus();
        
        zelda.gameLoop();
	}
	
	public static void main(String[] args) {
		Bricks ex = new Bricks();
		
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				Bricks ex = new Bricks();
//			}
//		});
	}
}
