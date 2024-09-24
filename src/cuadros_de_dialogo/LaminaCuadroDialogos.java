package cuadros_de_dialogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LaminaCuadroDialogos extends JPanel {

	private static final long serialVersionUID = 1005518723405836465L;

	public LaminaCuadroDialogos() {
		setLayout(new BorderLayout());
		add(getBoxs(6), BorderLayout.CENTER);
		add(getButton(), BorderLayout.SOUTH);
	}

	private JPanel getBoxs(int amountBox) {
		JPanel LaminaPrincipal = new JPanel();
		LaminaPrincipal.setLayout(new GridLayout(2, 3));
		String[] namesBoxs = { "Tipo", "Tipo de Mensaje", "Mensaje", "Confirmar", "Opción", "Entrada" };
		Border boxBorders = BorderFactory.createLineBorder(new Color(49, 54, 59));
		for (int i = 0; i < amountBox; i++) {
			Box BoxGenerated = Box.createVerticalBox();
			getBoxOptions(BoxGenerated, i);
			BoxGenerated.setBorder(getBorder());
			BoxGenerated.setBorder(BorderFactory.createTitledBorder(boxBorders, namesBoxs[i]));

			LaminaPrincipal.add(BoxGenerated);
		}
		return LaminaPrincipal;
	}

	private JPanel getButton() {
		JPanel laminaInferior = new JPanel();
		showMe.addActionListener(new ActionBoton());
		laminaInferior.add(showMe);
		return laminaInferior;
	}

	private void getBoxOptions(Box getBox, int option) {

		String[] types = { "Mensaje", "Confirmar", "Opción", "Entrada" };
		String[] types_messages = { "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE",
				"PLAIN_MESSAGE" };
		String[] messages = { "Cadena", "Icono", "Componente", "Otros", "Object[]" };
		String[] confirmMessages = { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" };
		String[] Options = { "String[]", "Icon[]", "Objects[]" };
		String[] inputs = { "Campo de texto", "Combo" };
		switch (option) {
		case 0 -> generatorBoxs(getBox, types);
		case 1 -> generatorBoxs(getBox, types_messages);
		case 2 -> generatorBoxs(getBox, messages);
		case 3 -> generatorBoxs(getBox, confirmMessages);
		case 4 -> generatorBoxs(getBox, Options);
		case 5 -> generatorBoxs(getBox, inputs);
		}
	}

	private void generatorBoxs(Box getBox, String[] names) {
		groupsButtons = new ButtonGroup();

		for (int i = 0; i < names.length; i++) {
			JRadioButton generatorTypes = new JRadioButton(names[i]);
			groupsButtons.add(generatorTypes);
			generatorTypes.addActionListener(new ActionCuadroDialogos());
			getBox.add(generatorTypes);
		}

	}

	private void getTypeMessage(String arg) {
		switch (arg) {
		case "ERROR_MESSAGE" -> message = JOptionPane.ERROR_MESSAGE;
		case "INFORMATION_MESSAGE" -> message = JOptionPane.INFORMATION_MESSAGE;
		case "WARNING_MESSAGE" -> message = JOptionPane.WARNING_MESSAGE;
		case "QUESTION_MESSAGE" -> message = JOptionPane.QUESTION_MESSAGE;
		case "PLAIN_MESSAGE" -> message = JOptionPane.PLAIN_MESSAGE;
		}

	}

	private void getTypeConfirm(String arg) {
		switch (arg) {
		case "DEFAULT_OPTION" -> confirm = JOptionPane.DEFAULT_OPTION;
		case "YES_NO_OPTION" -> confirm = JOptionPane.YES_NO_OPTION;
		case "YES_NO_CANCEL_OPTION" -> confirm = JOptionPane.YES_NO_CANCEL_OPTION;
		case "OK_CANCEL_OPTION" -> confirm = JOptionPane.OK_CANCEL_OPTION;
		}
	}

	private ArrayList<Object> getObjects() {
		ArrayList<Object> objetos = new ArrayList<Object>();
		String cadena = "Esto es una cadena de texto";
		ImageIcon imagen = new ImageIcon("src/images/paleta_de_color.png");
		JTextField componente_con_Color = new JTextField(10);
		componente_con_Color.setBackground(Color.YELLOW);
		LocalDateTime locaDate = LocalDateTime.now();
		JPanel objetosGrupo = new JPanel();
		objetosGrupo.setLayout(new GridLayout(4, 3));
		objetosGrupo.add(new JLabel(cadena));
		objetosGrupo.add(new JLabel(imagen));
		objetosGrupo.add(componente_con_Color);
		objetosGrupo.add(new JLabel(locaDate + ""));
		objetos.add(cadena);
		objetos.add(imagen);
		objetos.add(componente_con_Color);
		objetos.add(locaDate);
		objetos.add(objetosGrupo);
		return objetos;
	}

	private void getInputs(String args) {
		String[] opcionesLista = { "Primera opcion", "Segunda opcion", "Tercer Opcion" };
		switch (args) {
		case "Campo de texto" -> input = null;
		case "Combo" -> input = opcionesLista;

		}
	}

	private void getTypeObjectMessage(String arg) {
		switch (arg) {
		case "Cadena" -> objectMessage = getObjects().getFirst();
		case "Icono" -> objectMessage = getObjects().get(1);
		case "Componente" -> objectMessage = getObjects().get(2);
		case "Otros" -> objectMessage = getObjects().get(3);
		case "Object[]" -> objectMessage = getObjects().getLast();
		}

	}

	private void getType(String args) {
		switch (args) {
		case "Mensaje" -> types = "Mensaje";
		case "Confirmar" -> types = "Confirmar";
		case "Opción" -> types = "Opción";
		case "Entrada" -> types = "Entrada";
		}
	}

	private void getButton(String args) {
		switch (args) {
		case "Mensaje" -> JOptionPane.showMessageDialog(LaminaCuadroDialogos.this, objectMessage, TITLE, message);
		case "Confirmar" ->
			JOptionPane.showConfirmDialog(LaminaCuadroDialogos.this, objectMessage, TITLE, confirm, message);
		case "Opción" -> JOptionPane.showOptionDialog(LaminaCuadroDialogos.this, objectMessage, TITLE, confirm, message,
				null, options, options[0]);
		case "Entrada" -> JOptionPane.showInputDialog(LaminaCuadroDialogos.this, objectMessage, TITLE, message, null,
				input, "Elija la opcion");

		}

	}

	private void getTypeOption(String arg) {
		String numbers[] = { "Uno", "Dos", "Tres" };
		ImageIcon icons[] = { new ImageIcon("src/images/red.png"), new ImageIcon("src/images/cyan.png"),
				new ImageIcon("src/images/green.png") };
		Object[] arrayObjetos = { new ImageIcon("src/images/paleta_de_color.png"), new JTextField(10),
				"Esto es una cadena de texto" };
		switch (arg) {
		case "String[]": {
			for (int i = 0; i < options.length; i++) {
				options[i] = numbers[i];
			}
			break;
		}
		case "Icon[]": {
			for (int i = 0; i < options.length; i++) {
				options[i] = icons[i];
			}
			break;
		}
		case "Objects[]": {
			for (int i = 0; i < options.length; i++) {
				options[i] = arrayObjetos[i];
			}
			break;
		}
		}
	}

	private class ActionCuadroDialogos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getTypeMessage(e.getActionCommand());
			getTypeConfirm(e.getActionCommand());
			getTypeOption(e.getActionCommand());
			getTypeObjectMessage(e.getActionCommand());
			getType(e.getActionCommand());
			getInputs(e.getActionCommand());

		}

	}

	private class ActionBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getButton(types);

		}

	}

	private String[] input = new String[3];
	private String types = "";
	private final String TITLE = "Cuadro de Dialogo";
	private int message, confirm;
	private Object objectMessage;
	private Object[] options = { "Elije entre String", "Icon", "Object" };
	private ButtonGroup groupsButtons;
	private JButton showMe = new JButton("Muestrame");
}
