import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CreateTemplatePanel {

	private JTextField templateFileName, fieldScorerFileName;

	void setTemplateFileName() {
		this.templateFileName.setText(null);
	}

	CreateTemplatePanel setFieldScorerFileName() {
		this.fieldScorerFileName.setText(null);
		return this;
	}

	/**
	 * Created panel.
	 */
	void setToTemplatePanel(JPanel toTemplate, final JFrame frame) {
		JLabel icrisatLogoLabel = new JLabel("");
		toTemplate.add(icrisatLogoLabel);
		Util.addIcrisatLogo(icrisatLogoLabel);

		JLabel ibpLogoLabel = new JLabel("");
		toTemplate.add(ibpLogoLabel);
		Util.addbmsLogo(ibpLogoLabel);

		JLabel lblFileConverter = new JLabel("FieldScorer to Template");
		lblFileConverter.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblFileConverter.setForeground(Color.BLUE);
		lblFileConverter.setBounds(135, 25, 313, 44);
		toTemplate.add(lblFileConverter);

		JLabel lblTemplateFile = new JLabel("Template File");
		lblTemplateFile.setFont(new Font("Arial", Font.BOLD, 15));
		lblTemplateFile.setBounds(12, 124, 98, 20);
		toTemplate.add(lblTemplateFile);

		templateFileName = new JTextField();
		templateFileName.setBounds(109, 124, 366, 20);
		toTemplate.add(templateFileName);
		templateFileName.setColumns(10);

		JLabel lblFieldScorerFile = new JLabel("Field Scorer");
		lblFieldScorerFile.setFont(new Font("Arial", Font.BOLD, 15));
		lblFieldScorerFile.setBounds(12, 157, 98, 16);
		toTemplate.add(lblFieldScorerFile);

		fieldScorerFileName = new JTextField();
		fieldScorerFileName.setBounds(109, 157, 366, 22);
		toTemplate.add(fieldScorerFileName);
		fieldScorerFileName.setColumns(10);

		JButton btnTemplateFileBrowse= new JButton("Browse");
		btnTemplateFileBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Util.addFileChooser(arg0,templateFileName, frame);
			}
		});
		btnTemplateFileBrowse.setBounds(485, 120, 89, 23);
		toTemplate.add(btnTemplateFileBrowse);
		
		JButton btnFieldScorerFileBrowse= new JButton("Browse");
		btnFieldScorerFileBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Util.addFileChooser(arg0,fieldScorerFileName, frame);
			}
		});
		btnFieldScorerFileBrowse.setBounds(485, 155, 89, 23);
		toTemplate.add(btnFieldScorerFileBrowse);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// checkOutputFileName();
				String status = FieldScorerToTemplateConverter.convert(templateFileName.getText(), fieldScorerFileName.getText());
				JOptionPane.showMessageDialog(frame, status);
			}
		});
		btnSubmit.setBounds(257, 269, 89, 23);
		toTemplate.add(btnSubmit);
	}
}
