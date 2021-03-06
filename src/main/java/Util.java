import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;

class Util {
	static void addIcrisatLogo(JLabel label) {
		URL url = BMSConverterMain.class.getResource("/icrisat.png");
		ImageIcon icon = new ImageIcon(
				new ImageIcon(url).getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
		label.setIcon(icon);
		label.setBounds(433, 292, 150, 50);
	}

	static void addbmsLogo(JLabel label) {
		URL url = BMSConverterMain.class.getResource("/ibp_logo.jpg");
		ImageIcon icon = new ImageIcon(
				new ImageIcon(url).getImage().getScaledInstance(80, 50, Image.SCALE_DEFAULT));
		label.setIcon(icon);	
		label.setBounds(51, 13, 72, 61);
	}
	
	static void addFileChooser(ActionEvent evt, JTextField fileName, JFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			fileName.setText(fileChooser.getSelectedFile().getAbsolutePath());
		}
	}

	static void clearAll(CreateTemplatePanel templatePanel, CreateFieldScorerPanel fieldScorerPanel) {
		templatePanel.setFieldScorerFileName().setTemplateFileName();
		fieldScorerPanel.setInputFileName().setOutputFieldScorerFileName().setSiteName();
	}

	/*
	 * Read row and populate it into Row
	 */
	@SuppressWarnings("deprecation")
	static void processRow(Row nextRow, ArrayList<String> row) {
		for (Cell cell: nextRow) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				row.add(cell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				row.add(String.valueOf(cell.getBooleanCellValue()));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				row.add(String.valueOf(cell.getNumericCellValue()));
				break;
			case Cell.CELL_TYPE_BLANK:
				row.add(null);
				break;
			}
		}
	}

}
