package cuadros_de_dialogo;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class MarcoCuadrosDialogo extends JFrame {
	private static final long serialVersionUID = -3762805823994386940L;
	public MarcoCuadrosDialogo() {
		setBounds(x/4,y/4,x/2,y/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LaminaCuadroDialogos());
	}

	private int[] getScreenDimension() {
		Toolkit getScreenDefault = Toolkit.getDefaultToolkit();
		int x = getScreenDefault.getScreenSize().width;
		int y = getScreenDefault.getScreenSize().height;
		int[] dimension = { x, y };
		return dimension;
	}
	private int x = getScreenDimension()[0];
	private int y = getScreenDimension()[1];
}
