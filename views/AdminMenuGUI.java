package views;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class AdminMenuGUI {

	RailwayDatabase data = new RailwayDatabase();
	protected String Stops[]= data.AccessTrainStations();
	protected JFrame Adminframe = new JFrame();
	protected JPanel SouthAdmin = new JPanel();
	protected JButton ExitAdmin = new JButton("Exit Admin Menu");
	protected JPanel NorthInputAdmin = new JPanel();
	protected JTextArea InputStop = new JTextArea("Add the name of a new stop here...");
	protected JLabel NorthInfo = new JLabel("Add Stops one by one by inputing stop name");
	protected JButton AddStop = new JButton("Add Stop");
	protected JButton SaveRoute = new JButton("Save this route");
	protected JPanel CenterButtons = new JPanel();
	protected JButton RetrieveRoute = new JButton("Retrieve Route");
	protected JPanel MiddleSaveAdmin = new JPanel();
	protected JPanel DissapearSave = new JPanel();
	protected JPanel AppearSave = new JPanel();
	protected JButton SaveAs = new JButton("Save as...");
	protected JLabel SaveInfo = new JLabel("Once you have added all the stops you want");
	protected JLabel SaveInfo2 = new JLabel(" save your route to a file name of your choice");
	protected JTextArea InputFileName = new JTextArea("choose a file name...");
	protected JPanel MiddleSaveAdminInfo = new JPanel();
	protected JPanel NorthSouthInputAdmin = new JPanel();
	protected JComboBox<String> LeavingStation= new JComboBox<String>();
	protected JComboBox<String> ArrivingStation = new JComboBox<String>();
	protected int LeavingStationIndex;
	protected int ArrivingStationIndex;
	/**
	 * This is the main method that creates the graphical user interface for the admin main menu
	 */
	public void CreateAdminMenu(){
		RailwayDatabase data = new RailwayDatabase();
		String[] TrainStations = data.AccessTrainStations();
		
		for( int i=0;i<5;i++){
			LeavingStation.addItem(TrainStations[i]);
		}
		for( int i=0;i<5;i++){
			ArrivingStation.addItem(TrainStations[i]);
		}
		TitledBorder border = new TitledBorder("choose Journey");
		border.setTitleJustification(TitledBorder.CENTER);
		InputStop.setEditable(true);
		NorthSouthInputAdmin.setLayout(new BorderLayout());
		NorthSouthInputAdmin.add(NorthInfo, BorderLayout.NORTH);
		NorthSouthInputAdmin.add(InputStop, BorderLayout.WEST);
		NorthSouthInputAdmin.add(AddStop, BorderLayout.CENTER);
		JPanel NorthNorthInputAdmin = new JPanel();
		NorthNorthInputAdmin.setBorder(border);
		NorthNorthInputAdmin.setLayout(new BorderLayout());
		NorthNorthInputAdmin.add(ArrivingStation, BorderLayout.CENTER);
		NorthNorthInputAdmin.add(LeavingStation, BorderLayout.WEST);
		NorthInputAdmin.setLayout(new BorderLayout());
		
		NorthInputAdmin.add(NorthSouthInputAdmin, BorderLayout.SOUTH);
		NorthInputAdmin.add(NorthNorthInputAdmin, BorderLayout.NORTH);
		
		
		AppearSave.setLayout(new BorderLayout());
		AppearSave.add(SaveAs, BorderLayout.WEST);
		AppearSave.add(InputFileName, BorderLayout.CENTER);
		AppearSave.setVisible(false);
		
		DissapearSave.setLayout(new BorderLayout());
		DissapearSave.add(SaveRoute, BorderLayout.CENTER);
		DissapearSave.setVisible(true);
		
		MiddleSaveAdminInfo.setLayout(new BorderLayout());
		MiddleSaveAdminInfo.add(SaveInfo, BorderLayout.NORTH);
		MiddleSaveAdminInfo.add(SaveInfo2,BorderLayout.SOUTH);
		MiddleSaveAdmin.setLayout(new BorderLayout());
		MiddleSaveAdmin.add(MiddleSaveAdminInfo, BorderLayout.NORTH);
		MiddleSaveAdmin.add(DissapearSave, BorderLayout.SOUTH);
		MiddleSaveAdmin.add(AppearSave, BorderLayout.CENTER);
		
		String TitleString = "Route: " + LeavingStationIndex + " to " + ArrivingStationIndex;
		NorthInputAdmin.setVisible(true);
		Adminframe.setLocation(150,250);
		Adminframe.setTitle(TitleString);
		Adminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Adminframe.setVisible(true);
		Adminframe.setResizable(true);
		Adminframe.setLayout(new BorderLayout());
		SouthAdmin.setLayout(new BorderLayout());;
		
		SouthAdmin.add(RetrieveRoute, BorderLayout.CENTER);
		SouthAdmin.add(ExitAdmin, BorderLayout.EAST);
		SouthAdmin.setVisible(true);
		
		
		Adminframe.add(NorthInputAdmin, BorderLayout.NORTH);
		Adminframe.add(MiddleSaveAdmin,BorderLayout.CENTER);
		Adminframe.add(SouthAdmin,BorderLayout.SOUTH);
		Adminframe.pack();
		
		addfunctionality onclick= new addfunctionality();
		ExitAdmin.addActionListener(onclick);
		AddStop.addActionListener(onclick);
		SaveRoute.addActionListener(onclick);
		RetrieveRoute.addActionListener(onclick);
		SaveAs.addActionListener(onclick);
		
		
	}
	/**
	 * This is a subclass that adds the functionality to the GUI created in the method above
	 * @author amrithanayar
	 *
	 */
	private class addfunctionality implements ActionListener{
		/**
		 * This is the method that implements the functionality by calling methods from the Journey class and altering the GUI to diplay this information
		 */
		public void actionPerformed(ActionEvent event){
			JPanel CenterPanel = new JPanel();
			String StopName = InputStop.getText();
			Journey journey = new Journey();
			String FileName = InputFileName.getText();
			LeavingStationIndex=LeavingStation.getSelectedIndex();
			ArrivingStationIndex=ArrivingStation.getSelectedIndex();
			if(LeavingStation==ArrivingStation){
				JOptionPane.showMessageDialog(Adminframe,"Please choose different Station to leave from or arrive to","Inane error",JOptionPane.ERROR_MESSAGE);
			}
			if (event.getSource()==ExitAdmin){
				Adminframe.dispose();
				
		}
			if(event.getSource()==AddStop){
			data.addStops(StopName, LeavingStationIndex, ArrivingStationIndex);
			}
			if(event.getSource()==SaveRoute){
				DissapearSave.setVisible(false);
				AppearSave.setVisible(true);
				
				
			}
			
			if(event.getSource()==RetrieveRoute){
				File file = new File(FileName);
				
			JFileChooser chooser = new JFileChooser(file.getAbsoluteFile().getParentFile());
			
			int status = chooser.showOpenDialog(null);
			if(status==JFileChooser.APPROVE_OPTION){
				File SelectedFile = chooser.getSelectedFile();
				
				data.emptyarraylist(LeavingStationIndex, ArrivingStationIndex);
				data.ReadStopsFromFile(SelectedFile);
				
				
			}
			else{
				if(LeavingStation==ArrivingStation){
					JOptionPane.showMessageDialog(Adminframe,"An error occured opening this file","Inane error",JOptionPane.ERROR_MESSAGE);
				}
			}
			}
			if(event.getSource()==SaveAs){
				File file = new File(FileName);
				try {
					file.createNewFile();
					data.SaveStopsToFile(FileName);
					data.emptyarraylist(LeavingStationIndex, ArrivingStationIndex);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	

	
}
}
