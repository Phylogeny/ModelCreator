package com.mrcrayfish.modelcreator.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mrcrayfish.modelcreator.Exporter;
import com.mrcrayfish.modelcreator.Icons;
import com.mrcrayfish.modelcreator.element.Element;
import com.mrcrayfish.modelcreator.element.ElementManager;
import com.mrcrayfish.modelcreator.util.Parser;

public class PositionPanel extends JPanel implements IValueUpdater
{

	private static final long serialVersionUID = 1L;

	private ElementManager manager;

	private JButton btnPlusX;
	private JButton btnPlusY;
	private JButton btnPlusZ;
	private JTextField xPositionField;
	private JTextField yPositionField;
	private JTextField zPositionField;
	private JButton btnNegX;
	private JButton btnNegY;
	private JButton btnNegZ;

	public PositionPanel(ElementManager manager)
	{
		this.manager = manager;
		this.setLayout(new GridLayout(3, 3, 4, 4));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(221, 221, 228), 5), "<html><b>Position</b></html>"));
		this.setMaximumSize(new Dimension(186, 124));
		this.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		this.initComponents();
		this.initProperties();
		this.addComponents();
	}

	public void initComponents()
	{
		btnPlusX = new JButton(Icons.arrow_up);
		btnPlusY = new JButton(Icons.arrow_up);
		btnPlusZ = new JButton(Icons.arrow_up);
		xPositionField = new JTextField();
		yPositionField = new JTextField();
		zPositionField = new JTextField();
		btnNegX = new JButton(Icons.arrow_down);
		btnNegY = new JButton(Icons.arrow_down);
		btnNegZ = new JButton(Icons.arrow_down);
	}

	public void initProperties()
	{
		Font defaultFont = new Font("SansSerif", Font.BOLD, 20);
		xPositionField.setSize(new Dimension(62, 30));
		xPositionField.setFont(defaultFont);
		xPositionField.setHorizontalAlignment(JTextField.CENTER);
		xPositionField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					Element selectedElement = manager.getSelectedElement();
					if (selectedElement != null)
					{
						selectedElement.setStartX(Parser.parseDouble(xPositionField.getText(), selectedElement.getStartX()));
						selectedElement.updateEndUVs();
						manager.updateValues();
					}

				}
			}
		});
		xPositionField.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				Element selectedElement = manager.getSelectedElement();
				if (selectedElement != null)
				{
					selectedElement.setStartX(Parser.parseDouble(xPositionField.getText(), selectedElement.getStartX()));
					selectedElement.updateEndUVs();
					manager.updateValues();
				}
			}
		});

		yPositionField.setSize(new Dimension(62, 30));
		yPositionField.setFont(defaultFont);
		yPositionField.setHorizontalAlignment(JTextField.CENTER);
		yPositionField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					Element selectedElement = manager.getSelectedElement();
					if (selectedElement != null)
					{
						selectedElement.setStartY(Parser.parseDouble(yPositionField.getText(), selectedElement.getStartY()));
						selectedElement.updateEndUVs();
						manager.updateValues();
					}

				}
			}
		});
		yPositionField.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				Element selectedElement = manager.getSelectedElement();
				if (selectedElement != null)
				{
					selectedElement.setStartY(Parser.parseDouble(yPositionField.getText(), selectedElement.getStartY()));
					selectedElement.updateEndUVs();
					manager.updateValues();
				}
			}
		});

		zPositionField.setSize(new Dimension(62, 30));
		zPositionField.setFont(defaultFont);
		zPositionField.setHorizontalAlignment(JTextField.CENTER);
		zPositionField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					Element selectedElement = manager.getSelectedElement();
					if (selectedElement != null)
					{
						selectedElement.setStartZ(Parser.parseDouble(zPositionField.getText(), selectedElement.getStartZ()));
						selectedElement.updateEndUVs();
						manager.updateValues();
					}

				}
			}
		});
		zPositionField.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				Element selectedElement = manager.getSelectedElement();
				if (selectedElement != null)
				{
					selectedElement.setStartZ(Parser.parseDouble(zPositionField.getText(), selectedElement.getStartZ()));
					selectedElement.updateEndUVs();
					manager.updateValues();
				}
			}
		});

		btnPlusX.addActionListener(e ->
		{
			Element selectedElement = manager.getSelectedElement();
			if(selectedElement != null)
			{
				if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1)
				{
					selectedElement.addStartX(0.1F);
				}
				else
				{
					selectedElement.addStartX(1.0F);
				}
				xPositionField.setText(Exporter.FORMAT.format(selectedElement.getStartX()));
			}
		});
		btnPlusX.setPreferredSize(new Dimension(62, 30));
		btnPlusX.setFont(defaultFont);
		btnPlusX.setToolTipText("<html>Increases the X position.<br><b>Hold shift for decimals</b></html>");

		btnPlusY.addActionListener(e ->
		{
			Element selectedElement = manager.getSelectedElement();
			if(selectedElement != null)
			{
				if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1)
				{
					selectedElement.addStartY(0.1F);
				}
				else
				{
					selectedElement.addStartY(1.0F);
				}
				yPositionField.setText(Exporter.FORMAT.format(selectedElement.getStartY()));
			}
		});
		btnPlusY.setPreferredSize(new Dimension(62, 30));
		btnPlusY.setFont(defaultFont);
		btnPlusY.setToolTipText("<html>Increases the Y position.<br><b>Hold shift for decimals</b></html>");

		btnPlusZ.addActionListener(e ->
		{
			Element selectedElement = manager.getSelectedElement();
			if(selectedElement != null)
			{
				if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1)
				{
					selectedElement.addStartZ(0.1F);
				}
				else
				{
					selectedElement.addStartZ(1.0F);
				}
				zPositionField.setText(Exporter.FORMAT.format(selectedElement.getStartZ()));
			}
		});
		btnPlusZ.setPreferredSize(new Dimension(62, 30));
		btnPlusZ.setFont(defaultFont);
		btnPlusZ.setToolTipText("<html>Increases the Z position.<br><b>Hold shift for decimals</b></html>");

		btnNegX.addActionListener(e ->
		{
			Element selectedElement = manager.getSelectedElement();
			if(selectedElement != null)
			{
				if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1)
				{
					selectedElement.addStartX(-0.1F);
				}
				else
				{
					selectedElement.addStartX(-1.0F);
				}
				xPositionField.setText(Exporter.FORMAT.format(selectedElement.getStartX()));
			}
		});
		btnNegX.setPreferredSize(new Dimension(62, 30));
		btnNegX.setFont(defaultFont);
		btnNegX.setToolTipText("<html>Decreases the X position.<br><b>Hold shift for decimals</b></html>");

		btnNegY.addActionListener(e ->
		{
			Element selectedElement = manager.getSelectedElement();
			if(selectedElement != null)
			{
				if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1)
				{
					selectedElement.addStartY(-0.1F);
				}
				else
				{
					selectedElement.addStartY(-1.0F);
				}
				yPositionField.setText(Exporter.FORMAT.format(selectedElement.getStartY()));
			}
		});
		btnNegY.setPreferredSize(new Dimension(62, 30));
		btnNegY.setFont(defaultFont);
		btnNegY.setToolTipText("<html>Decreases the Y position.<br><b>Hold shift for decimals</b></html>");

		btnNegZ.addActionListener(e ->
		{
			Element selectedElement = manager.getSelectedElement();
			if(selectedElement != null)
			{
				if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == 1)
				{
					selectedElement.addStartZ(-0.1F);
				}
				else
				{
					selectedElement.addStartZ(-1.0F);
				}
				zPositionField.setText(Exporter.FORMAT.format(selectedElement.getStartZ()));
			}
		});
		btnNegZ.setPreferredSize(new Dimension(62, 30));
		btnNegZ.setFont(defaultFont);
		btnNegZ.setToolTipText("<html>Decreases the Z position.<br><b>Hold shift for decimals</b></html>");
	}

	public void addComponents()
	{
		this.add(btnPlusX);
		this.add(btnPlusY);
		this.add(btnPlusZ);
		this.add(xPositionField);
		this.add(yPositionField);
		this.add(zPositionField);
		this.add(btnNegX);
		this.add(btnNegY);
		this.add(btnNegZ);
	}

	@Override
	public void updateValues(Element cube)
	{
		if (cube != null)
		{
			xPositionField.setEnabled(true);
			yPositionField.setEnabled(true);
			zPositionField.setEnabled(true);
			xPositionField.setText(Exporter.FORMAT.format(cube.getStartX()));
			yPositionField.setText(Exporter.FORMAT.format(cube.getStartY()));
			zPositionField.setText(Exporter.FORMAT.format(cube.getStartZ()));
		}
		else
		{
			xPositionField.setEnabled(false);
			yPositionField.setEnabled(false);
			zPositionField.setEnabled(false);
			xPositionField.setText("");
			yPositionField.setText("");
			zPositionField.setText("");
		}
	}
}
