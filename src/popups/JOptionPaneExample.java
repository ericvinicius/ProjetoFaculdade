package popups;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utilities.Utilites;

public class JOptionPaneExample {
	public static void createMessageDialog(String message, String titulo, ImageIcon icon) {
		JOptionPane.showMessageDialog(null, getOptionPanel(message, icon), titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void createConfirmDialog(String message, String titulo, ImageIcon icon) {
		JOptionPane.showConfirmDialog(null, getOptionPanel(message, icon), titulo, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void createInputDialog(String message, String titulo, ImageIcon icon) {
		JOptionPane.showInputDialog(null, getOptionPanel(message, icon), titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public static void main(String... args) {
		JOptionPaneExample.createMessageDialog("teste", "teste", Utilites.imageLock);
	}

	private static JPanel getOptionPanel(String message, ImageIcon icon) {
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		try {
			JLabel label = new JLabel(message, icon, JLabel.RIGHT);
			panel.add(label);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}
}