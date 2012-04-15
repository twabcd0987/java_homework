import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DomTreeTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new DOMTreeFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}

class DOMTreeFrame extends JFrame {
	public DOMTreeFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		JMenu file = new JMenu("file");
		JMenuItem open = new JMenuItem("open");
		text = new JTextArea(8, 20);
		JScrollPane sc = new JScrollPane(text);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile(text);
			}
		});
		JMenuItem exit = new JMenuItem("exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JMenuBar bar = new JMenuBar();
		file.add(open);
		file.add(exit);
		bar.add(file);
		setJMenuBar(bar);
		add(sc, BorderLayout.CENTER);
	}

	private void openFile(final JTextArea text) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));

		try {
			chooser.setFileFilter(new FileNameExtensionFilter("xmlÎÄ¼þ", "xml"));
		} catch (Exception e) {

		}
		int result = chooser.showOpenDialog(this);
		if (result != JFileChooser.APPROVE_OPTION) {
			return;
		}
		final File f = chooser.getSelectedFile();
		new SwingWorker<Void, Void>() {
			protected Void doInBackground() throws Exception {
				if (builder == null) {
					DocumentBuilderFactory factory = DocumentBuilderFactory
							.newInstance();
					builder = factory.newDocumentBuilder();
				}
				
				Document doc = builder.parse(f);
				Element root = doc.getDocumentElement();
				text.append(root.getTagName()+"\n");
				NodeList children = root.getChildNodes();
				int length=children.getLength();
				for (int i = 0; i < children.getLength(); i++) {
					find(children.item(i),str);
				}
			
		
//				Node title=root.getFirstChild().getNextSibling();
//				Text titleText=(Text) title.getFirstChild();
//				String s=titleText.getData().trim();
//				str.append(s);
				return null;
			}

			protected void done() {
				try {
					text.append(str.toString());
				} catch (Exception e) {

				}
			}
		}.execute();

	}

	public  StringBuilder find(Node root,StringBuilder mystr){
		NodeList list=root.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			Node c=list.item(i);
			if(c instanceof Element){
				str.append("\n"+(((Element) c).getTagName())+"  ");
				find(c,str);}
			else if(c instanceof Text){
				Text cText=(Text) c;
				mystr.append(cText.getData().trim());
			}
		}
		return str;
	}
	private JTextArea text;
	private StringBuilder str=new StringBuilder();
	private DocumentBuilder builder;
	private int DEFAULT_WIDTH = 300;
	private int DEFAULT_HEIGHT = 300;
}