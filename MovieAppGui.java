import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.net.*;

public class MovieAppGui extends JPanel implements ListSelectionListener {
	JMenuBar menuBar;
	JButton addButton, removeButton, editButton, playButton, imageButton;
	JButton searchButton;
	JTextField searchTF, genreTF, yearTF, durationTF, directorsTF;
	JTextField formatTF, qualityTF, titleTF;
	JTextArea plotTA;
	JLabel genreLbl, yearLbl, durationLbl, directorsLbl, formatLbl;
	JLabel qualityLbl, plotLbl, titleLbl;
	JSplitPane splitPane;
	JList list;
	JLabel picture;
	String[] movieNames = { "Kill_Bill", "Shaun_of_the_Dead", "The_Hobbit", "Star_Wars", "Elf", "300", "Silent_House" };

	public MovieAppGui() {
//		super("Movie Organizer");

		list = new JList(movieNames);
	  	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);

		JScrollPane listScrollPane = new JScrollPane(list);
		
		picture = new JLabel();
		picture.setHorizontalAlignment(JLabel.LEFT);
		picture.setVerticalAlignment(JLabel.TOP);
		JScrollPane movieViewerPane = new JScrollPane(picture);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
						 					listScrollPane, movieViewerPane);
  		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);

		Dimension minimumSize = new Dimension(100, 50);
		listScrollPane.setMinimumSize(minimumSize);
		movieViewerPane.setMinimumSize(minimumSize);

		splitPane.setPreferredSize(new Dimension(600, 700));		
		updateLabel(movieNames[list.getSelectedIndex()]);
	}

	public void valueChanged(ListSelectionEvent e) {
		list = (JList)e.getSource();
		updateLabel(movieNames[list.getSelectedIndex()]);		
	}

	public void updateLabel(String name) {
		ImageIcon icon = new ImageIcon("img/" + name + ".jpg");
		picture.setIcon(icon);
		if (icon != null)
			picture.setText(null);
		else
			picture.setText("Image not found");
	} 

/*	protected static ImageIcon createImageIcon(String path) {
		URL imgURL = MovieAppGui.class.getResource(path);
		if (imgURL != null)
			return new ImageIcon(imgURL);
		else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	} */ 

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Movie Organizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MovieAppGui movieAppGui = new MovieAppGui();
		frame.getContentPane().add(movieAppGui.getSplitPane());
		
		frame.pack();
		frame.setVisible(true);
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
