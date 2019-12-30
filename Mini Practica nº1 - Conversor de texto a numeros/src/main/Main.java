package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.EventQueue;
import java.awt.Font;

public class Main extends JFrame implements WindowFocusListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2879147677028311419L;
	/**
	 * Launch the application. ç
	 */
	
	private static JTextPane[] txt = {new JTextPane(), new JTextPane()};
	private static byte k = 0, kl = 1, pos = 0, p = 0;
	private double o = 0;
	private static String[] g;
	private static String[] PG = {"αἷμα", "ἀήρ", "ἀήρ", "ἄθρωπς", "ἄρχω", "ας", "ἀσθενεία", "βάλλω", "βαρύς",
			"βίς", "γάμς", "γαστήρ", "γῆς", "γιγώσκω", "γλυκύς", "εῖα", "γλῶσσα", "γλῶττα", "γράμμα", "γράφω",
			"γυή", "γυαικς", "δάκτυλς", "δέκα", "δέρμα", "δύναμις", "δώδεκα", "ἕνδεκα", "ἐέα", "κεφαλή",
			"καρδία", "κεφαλή", "κρατέω", "κύστις", "λάτρεια", "λαρίγξ", "μαία", "ματεία", "πευμώ", "σῆμα",
			"σπείρω", "τέτταρες", "τρεῖς", "φαγεῖ", "ἐσθίω", "φιλέω", "φλεβς", "φωή", "χρῶμα", "ψευδής", "χρῶμα"};
	//palabras en griego,limite 570 letras aproximadamente
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/** LVL
	 * Create the frame.
	 */
	public Main() {
		
		JMenuBar menuBar = new JMenuBar();
		try{
			setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaTimeThumb.png")));
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 437);
		setJMenuBar(menuBar);
		addWindowFocusListener(this);
		ImageIcon h = null;
		try{
			h = new ImageIcon(Main.class.getResource("/icons/Icontxt.gif"));
		}catch(NullPointerException e) {
			System.out.println("¡¡¡QUE MIERDAS TE PASA!!! POR QUE TIENES QUE HACER QUE EL PROGRAMA DE MIERDA NO ENCUENTRE EL ARCHIVO, PENDEJO");
			txt[1].setText("¡¡¡QUE MIERDAS TE PASA!!! POR QUE TIENES QUE HACER QUE EL PROGRAMA DE MIERDA NO ENCUENTRE EL ARCHIVO, PENDEJO");
			JOptionPane.showMessageDialog(this, "El icono de txt no fue encontrado.", "Aviso", 2);
			e.printStackTrace();
		}
		JPanel contentPane = new JPanel();
		
		JPopupMenu j = new JPopupMenu();
		ButtonGroup tt = new ButtonGroup();
		ButtonGroup ttt = new ButtonGroup();
		
		JMenu mntmArchivo = new JMenu("Archivo");
		JMenu mntmEdicion = new JMenu("Edición");
		JMenu mntmAyuda = new JMenu("Ayuda");
		
		JMenuItem[] guardar = {new JMenuItem("Guardar"), new JMenu("Guardar como...")};
		JMenu nuevoArchivo = new JMenu("Nuevo archivo...");
		
		JMenu t = new JMenu("Tamaño de letra...");
		JMenu tl = new JMenu("Tipo de letra...");
		JMenu minvertir = new JMenu("Invertir texto...");
		JMenu conversor = new JMenu("Traducir...");
		
		JMenuItem[] cortar = {new JMenuItem("Cortar"), new JMenuItem("Copiar"), new JMenuItem("Pegar")};
		JMenuItem[] invertir = {new JMenuItem("Invertir texto por números"), new JMenuItem("Invertir texto por caracter")};
		JMenuItem[] traductor = {new JMenuItem("Conversor texto a números"), new JMenuItem("Conversor número a texto")};
		
		JMenuItem cont = new JMenuItem("Contar el número de palabras");
		JMenuItem cont1 = new JMenuItem("Contar el número de palabras");
		JMenuItem borrar = new JMenuItem("Borrar");
		JMenuItem quitar = new JMenuItem("Quitar...");
		JMenuItem btnConvertir = new JMenuItem("Convertir TaN");
		JMenuItem btnConvertiri = new JMenuItem("Convertir NaT");
		
		JRadioButtonMenuItem tamaño[] = {new JRadioButtonMenuItem("8"), new JRadioButtonMenuItem("10"), new JRadioButtonMenuItem("12"), new JRadioButtonMenuItem("14"), new JRadioButtonMenuItem("16"),
				new JRadioButtonMenuItem("18")};
		JRadioButtonMenuItem tletra[] = {new JRadioButtonMenuItem("Arial"), new JRadioButtonMenuItem("Courier"), new JRadioButtonMenuItem("Verdana"), new JRadioButtonMenuItem("Serif"),
				new JRadioButtonMenuItem("Console")};
		
		JMenuItem[] pdf = {new JMenuItem("PDF"),  new JMenuItem("txt", h)};
		JMenuItem[] pdf2 = {new JMenuItem("PDF"),  new JMenuItem("txt", h)};
		
		mntmAyuda.add(cont);
		
		for(byte i = 0; i < 2; i++) {
			
			guardar[1].add(pdf[i]);
			nuevoArchivo.add(pdf2[i]);
			mntmArchivo.add(guardar[i]);
			minvertir.add(invertir[i]);
			conversor.add(traductor[i]);
			
		}
		mntmArchivo.addSeparator();
		mntmArchivo.add(nuevoArchivo);
		
		for(byte i = 0; i < 3; i++) 
			mntmEdicion.add(cortar[i]);
		
		btnConvertir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		btnConvertiri.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		cortar[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		cortar[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		cortar[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		cont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
		
		borrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		quitar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0));
		
		mntmEdicion.addSeparator();
		mntmEdicion.add(borrar);
		mntmEdicion.add(quitar);
		mntmEdicion.addSeparator();
		mntmEdicion.add(btnConvertir);
		mntmEdicion.add(btnConvertiri);
		mntmEdicion.add(minvertir);
		mntmEdicion.add(conversor);
		mntmEdicion.addSeparator();
		mntmEdicion.add(t);
		mntmEdicion.add(tl);
		
		for(byte i = 0; i < 6; i++) {
			
			tt.add(tamaño[i]);
			t.add(tamaño[i]);
			tamaño[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					txt[0].setFont(new Font(txt[0].getFont().getFontName(), Font.PLAIN, Integer.parseInt(e.getActionCommand())));
					txt[1].setFont(new Font(txt[0].getFont().getFontName(), Font.PLAIN, Integer.parseInt(e.getActionCommand())));
					
				}
				
			});
			
		}
		
		for(byte i = 0; i < 5; i++) {
			
			ttt.add(tletra[i]);
			tl.add(tletra[i]);
			tletra[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					txt[0].setFont(new Font(e.getActionCommand(), Font.PLAIN, txt[0].getFont().getSize()));
					txt[1].setFont(new Font(e.getActionCommand(), Font.PLAIN, txt[1].getFont().getSize()));
					
				}
				
			});
			
		}
		
		menuBar.add(mntmArchivo);
		menuBar.add(mntmEdicion);
		menuBar.add(mntmAyuda);
		
		borrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				txt[0].setText("");
				txt[1].setText("");
				
			}
			
		});
		
		quitar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Press p = new Press();
				p.setVisible(true);
				
			}
			
		});
		
		invertir[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Invertir(" ");
				
			}
			
		});
		invertir[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Invertir("");
				
			}
			
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Mini Practica nº1 - Conversor de texto a numeros");
		
		JScrollPane f = new JScrollPane(txt[0]);
		txt[0].setFont(new Font("Arial", Font.PLAIN, 12));
		txt[0].setComponentPopupMenu(j);
		j.add(cont1);
		
		traductor[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				k = 0;
				kl = 1;
				
			}
			
		});
		traductor[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				k = 1;
				kl = 0;
				
			}
			
		});
		
		btnConvertiri.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				convertir();
				
			}
				
		});
		btnConvertir.addActionListener(new ActionListener() {
			
			String[] h;
			
			public void actionPerformed(ActionEvent e) {
				
				k = 0;
				kl = 1;
				
				txt[k].setText("");
				
				h = txt[kl].getText().toLowerCase().split("");
				txt[kl].setText("");
				
				for(String c: h) {
					
					switch(c) {
					
					case "a":
						
						txt[k].setText(txt[k].getText() + "-01");
						
						break;
					
					case "b":
						
						txt[k].setText(txt[k].getText() + "-02");
						
						break;
					
					case "c":
						
						txt[k].setText(txt[k].getText() + "-03");
						
						break;
					
					case "d":
						
						txt[k].setText(txt[k].getText() + "-04");
						
						break;
					
					case "e":
						
						txt[k].setText(txt[k].getText() + "-05");
						
						break;
						
						
					case "f":
						
						txt[k].setText(txt[k].getText() + "-06");
						
						break;
					
					case "g":
						
						txt[k].setText(txt[k].getText() + "-07");
						
						break;
					
					case "h":
						
						txt[k].setText(txt[k].getText() + "-08");
						
						break;
					case "i":
						
						txt[k].setText(txt[k].getText() + "-09");
						
						break;
					
					case "j":
						
						txt[k].setText(txt[k].getText() + "-10");
						
						break;
					
					case "k":
						
						txt[k].setText(txt[k].getText() + "-11");
						
						break;
						
					case "l":
						
						txt[k].setText(txt[k].getText() + "-12");
						
						break;
					
					case "m":
						
						txt[k].setText(txt[k].getText() + "-13");
						
						break;
					case "n":
						
						txt[k].setText(txt[k].getText() + "-14");
						
						break;
					
					case "ñ":
						
						txt[k].setText(txt[k].getText() + "-15");
						
						break;
					
					case "o":
						
						txt[k].setText(txt[k].getText() + "-16");
						
						break;
						
						
					case "p":
						
						txt[k].setText(txt[k].getText() + "-17");
						
						break;
					
					case "q":
						
						txt[k].setText(txt[k].getText() + "-18");
						
						break;
					
					case "r":
						
						txt[k].setText(txt[k].getText() + "-19");
						
						break;
					case "s":
						
						txt[k].setText(txt[k].getText() + "-20");
						
						break;
					
					case "t":
						
						txt[k].setText(txt[k].getText() + "-21");
						
						break;
					
					case "u":
						
						txt[k].setText(txt[k].getText() + "-22");
						
						break;
						
					case "v":
						
						txt[k].setText(txt[k].getText() + "-23");
						
						break;
					
					case "w":
						
						txt[k].setText(txt[k].getText() + "-24");
						
						break;
					
					case "x":
						
						txt[k].setText(txt[k].getText() + "-25");
						
						break;
					case "y":
						
						txt[k].setText(txt[k].getText() + "-26");
						
						break;
					
					case "z":
						
						txt[k].setText(txt[k].getText() + "-27");
						
						break;
					case "ĉ":
						txt[k].setText(txt[k].getText() + "-28");
						break;
					case "ŭ":
						txt[k].setText(txt[k].getText() + "-29");
						break;
					case "ĝ":
						txt[k].setText(txt[k].getText() + "-30");
						break;
					case "ĥ":
						txt[k].setText(txt[k].getText() + "-31");
						break;
					case "ĵ":
						txt[k].setText(txt[k].getText() + "-32");
						break;
					case "á":
						txt[k].setText(txt[k].getText() + "-33");
						break;
					case "é":
						txt[k].setText(txt[k].getText() + "-34");
						break;
					case "í":
						txt[k].setText(txt[k].getText() + "-35");
						break;
					case "ó":
						txt[k].setText(txt[k].getText() + "-36");
						break;
					case "ú":
						txt[k].setText(txt[k].getText() + "-37");
						break;
					case "1":
						txt[k].setText(txt[k].getText() + "-ça");
						break;
					case "2":
						txt[k].setText(txt[k].getText() + "-çb");
						break;
					case "3":
						txt[k].setText(txt[k].getText() + "-çc");
						break;
					case "4":
						txt[k].setText(txt[k].getText() + "-çd");
						break;
					case "5":
						txt[k].setText(txt[k].getText() + "-çe");
						break;
					case "6":
						txt[k].setText(txt[k].getText() + "-çf");
						break;
					case "7":
						txt[k].setText(txt[k].getText() + "-çg");
						break;
					case "8":
						txt[k].setText(txt[k].getText() + "-çh");
						break;
					case "9":
						txt[k].setText(txt[k].getText() + "-çi");
						break;
					case " ":
						txt[k].setText(txt[k].getText() + "-_");
						break;
					default:
						txt[k].setText(txt[k].getText() + "-" + c);
						break;
					
					}
					
					
					
					if((byte) (Math.random() * 3) == 1) {
						
						o = 0;
						txt[k].setText(txt[k].getText() + PG[p].charAt(pos));
						pos++;
						if(pos == PG[p].length()) {
							
							pos = 0;
							p = (byte) (Math.random() * 51);
							
						}
						
						
					}
					
				}
				
				txt[k].setText(txt[k].getText().substring(1));
				
			}
			
		});
		cont.addActionListener(gg);
		cont1.addActionListener(gg);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		JScrollPane d = new JScrollPane(txt[1]);
		d.setMaximumSize(new Dimension(32767, 22));
		contentPane.add(d);
		contentPane.add(f);
		
	}
	
	private void Invertir(String s) {
		
		g = txt[k].getText().split(s);
		txt[k].setText("");
		
		for(String h:g) 
			txt[k].setText(h + s + txt[k].getText());
		
	}
	
	static void quitarE(String e) {
		
		g = txt[k].getText().split(e);
		txt[k].setText("");
		
		for(String h:g) 
			txt[k].setText(txt[k].getText() + h);
		
	}
	
	static void convertir() {
		
		k = 1;
		kl = 0;
		
		String[] h;
		txt[k].setText("");
		
		h = txt[kl].getText().toLowerCase().split("-");
		txt[kl].setText("");
		
		for(String c: h) {
			
			switch(c) {
			
			case "01":
				
				txt[k].setText(txt[k].getText() + "a");
				
				break;
			
			case "02":
				
				txt[k].setText(txt[k].getText() + "b");
				
				break;
			
			case "03":
				
				txt[k].setText(txt[k].getText() + "c");
				
				break;
			
			case "04":
				
				txt[k].setText(txt[k].getText() + "d");
				
				break;
			
			case "05":
				
				txt[k].setText(txt[k].getText() + "e");
				
				break;
				
				
			case "06":
				
				txt[k].setText(txt[k].getText() + "f");
				
				break;
			
			case "07":
				
				txt[k].setText(txt[k].getText() + "g");
				
				break;
			
			case "08":
				
				txt[k].setText(txt[k].getText() + "h");
				
				break;
			case "09":
				
				txt[k].setText(txt[k].getText() + "i");
				
				break;
			
			case "10":
				
				txt[k].setText(txt[k].getText() + "j");
				
				break;
			
			case "11":
				
				txt[k].setText(txt[k].getText() + "k");
				
				break;
				
			case "12":
				
				txt[k].setText(txt[k].getText() + "l");
				
				break;
			
			case "13":
				
				txt[k].setText(txt[k].getText() + "m");
				
				break;
			case "14":
				
				txt[k].setText(txt[k].getText() + "n");
				
				break;
			
			case "15":
				
				txt[k].setText(txt[k].getText() + "ñ");
				
				break;
			
			case "16":
				
				txt[k].setText(txt[k].getText() + "o");
				
				break;
				
				
			case "17":
				
				txt[k].setText(txt[k].getText() + "p");
				
				break;
			
			case "18":
				
				txt[k].setText(txt[k].getText() + "q");
				
				break;
			
			case "19":
				
				txt[k].setText(txt[k].getText() + "r");
				
				break;
			case "20":
				
				txt[k].setText(txt[k].getText() + "s");
				
				break;
			
			case "21":
				
				txt[k].setText(txt[k].getText() + "t");
				
				break;
			
			case "22":
				
				txt[k].setText(txt[k].getText() + "u");
				
				break;
				
			case "23":
				
				txt[k].setText(txt[k].getText() + "v");
				
				break;
			
			case "24":
				
				txt[k].setText(txt[k].getText() + "w");
				
				break;
			
			case "25":
				
				txt[k].setText(txt[k].getText() + "x");
				
				break;
			case "26":
				
				txt[k].setText(txt[k].getText() + "y");
				
				break;
			
			case "27":
				
				txt[k].setText(txt[k].getText() + "z");
				
				break;
			case "28":
				txt[k].setText(txt[k].getText() + "ĉ");
				break;
			case "29":
				txt[k].setText(txt[k].getText() + "ŭ");
				break;
			case "30":
				txt[k].setText(txt[k].getText() + "ĝ");
				break;
			case "31":
				txt[k].setText(txt[k].getText() + "ĥ");
				break;
			case "32":
				txt[k].setText(txt[k].getText() + "ĵ");
				break;
			case "33":
				txt[k].setText(txt[k].getText() + "á");
				break;
			case "34":
				txt[k].setText(txt[k].getText() + "é");
				break;
			case "35":
				txt[k].setText(txt[k].getText() + "í");
				break;
			case "36":
				txt[k].setText(txt[k].getText() + "ó");
				break;
			case "37":
				txt[k].setText(txt[k].getText() + "ú");
				break;
			case "ça":
				txt[k].setText(txt[k].getText() + "1");
				break;
			case "çb":
				txt[k].setText(txt[k].getText() + "2");
				break;
			case "çc":
				txt[k].setText(txt[k].getText() + "3");
				break;
			case "çd":
				txt[k].setText(txt[k].getText() + "4");
				break;
			case "çe":
				txt[k].setText(txt[k].getText() + "5");
				break;
			case "çf":
				txt[k].setText(txt[k].getText() + "6");
				break;
			case "çg":
				txt[k].setText(txt[k].getText() + "7");
				break;
			case "çh":
				txt[k].setText(txt[k].getText() + "8");
				break;
			case "çi":
				txt[k].setText(txt[k].getText() + "9");
				break;
			case "_":
				txt[k].setText(txt[k].getText() + " ");
				break;
			default:
				txt[k].setText(txt[k].getText() + c);
				break;
				
			}
			
		}
		
	}
	
	ActionListener gg = new ActionListener() {
		
		int i = 0, p = 0;
		String[] y = {""};
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			i = txt[kl].getText().split(" ").length;
			y = txt[kl].getText().split(" ");
			
			System.out.println("El numero de palabras es: " + i);
			System.out.println("La nombro de vortoj estas: " + i);
			
			JFrame h = new JFrame("La nombro de vortoj estas: " + i);
			h.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			h.setSize(245, 50);
			h.setLocationRelativeTo(null);
			h.setVisible(true);
			h.add(new JLabel("La nombro de vortoj estas: " + i));
			
			for(int l = 0;l < i;l++) {
				
				for(int j = 0;j < i;j++) {
					
					if(y[l].equalsIgnoreCase(y[j])) {
						p++;
					}
					
				}
				
			}
			
			System.out.println("El numero de palabras iguales es: " + p);
			p = 0;
			
		}
		
	};

	@Override
	public void windowGainedFocus(WindowEvent arg0) {
		
		setTitle("Mini Practica nº1 - Conversor de texto a numeros");
		
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		
		setTitle("Esperanto estas la plej bona lingvo en la tuta mondo, eĉ pli bona ol Ido!");
		
	}
	
}