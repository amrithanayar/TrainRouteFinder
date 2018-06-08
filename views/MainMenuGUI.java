package views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import views.AdminMenuGUI;
/**
 * This is the class that contains methods that are called to create the admin menu
 * @author amrithanayar
 *
 */
public class MainMenuGUI {

	
		RailwayDatabase data = new RailwayDatabase();
		String[] TrainStations = data.AccessTrainStations();
		Journey TrainJourney = new Journey();
		protected JFrame frame = new JFrame();
		protected JPanel NorthPanel = new JPanel();	
		protected JComboBox<String> LeavingComboBox  = new JComboBox<String>();
		protected JComboBox<String> ArrivingComboBox  = new JComboBox<String>();
		protected JComboBox<Integer> DayComboBox = new JComboBox<Integer>();
		protected JComboBox<Integer> MonthComboBox = new JComboBox<Integer>();
		protected JComboBox<Integer> YearComboBox = new JComboBox<Integer>();
		protected JLabel label1 = new JLabel("to");
		protected JPanel NorthNorth = new JPanel();
		protected JPanel NorthSouthPanel = new JPanel();
		protected JButton Time = new JButton("Time");
		protected JButton Price = new JButton("Price");
		protected JButton Route = new JButton("Route");
		protected JButton Admin = new JButton("Admin");
		protected JButton Exit = new JButton("Go back to Main Menu");
		protected JButton Quit = new JButton("Exit");
		protected JPanel NorthNorthOnclick = new JPanel();
		protected JPanel NorthOnclick = new JPanel();
		protected JPanel NorthCenter = new JPanel();
		protected JRadioButton returnButton = new JRadioButton("Return Journey");
		protected JFrame adminFrame = new JFrame();
		protected JPanel South = new JPanel();	
		protected JRadioButton alpha = new JRadioButton("Alphabetically By Station Name");
		protected JRadioButton Byroute = new JRadioButton("By route");
		protected JPanel RouteOptions = new JPanel();
		protected JPanel NorthAlpha = new JPanel();
		protected JPanel NorthBeta = new JPanel();
		protected JLabel labelstops=new JLabel("The stops for this Journey are:");
		/**
		 * This is the method to create the new frame and add contents for the admin main menu
		 */
		public void CreateMainFrame(){
			frame.pack();
			frame.setLocation(150,250);
			frame.setTitle("Find a train");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setResizable(true);
			frame.setLayout(new BorderLayout());
			
			NorthPanel.setLayout(new BorderLayout());
			for( int i=0;i<5;i++){
				LeavingComboBox.addItem(TrainStations[i]);
			}
			for( int i=0;i<5;i++){
				ArrivingComboBox.addItem(TrainStations[i]);
			}
			for(int i = 1; i <= 31 ; i++){
				DayComboBox.addItem(i);
			}
			
			for(int i = 1; i <= 12 ; i++){
				MonthComboBox.addItem(i);
			}
			
			for(int i = 2017; i <= 2027 ; i++){
				YearComboBox.addItem(i);
			}
			
			
			NorthNorth.setLayout(new BorderLayout());;
			NorthNorth.add(LeavingComboBox, BorderLayout.WEST);
			NorthNorth.add(label1, BorderLayout.CENTER);
			NorthNorth.add(ArrivingComboBox, BorderLayout.EAST);
			
			
			NorthPanel.add(NorthNorth, BorderLayout.NORTH);
					
			
			NorthSouthPanel.setLayout(new BorderLayout());
			NorthSouthPanel.add(DayComboBox, BorderLayout.WEST);
			NorthSouthPanel.add(MonthComboBox,BorderLayout.CENTER);
			NorthSouthPanel.add(YearComboBox,BorderLayout.EAST);
			
			
			NorthSouthPanel.add(returnButton,BorderLayout.SOUTH);
			
			NorthPanel.add(NorthSouthPanel,BorderLayout.SOUTH);
			NorthPanel.setVisible(true);
			
			TitledBorder border = new TitledBorder("choose Journey");
			border.setTitleJustification(TitledBorder.CENTER);
			NorthNorth.setBorder(border);
			TitledBorder border1 = new TitledBorder("choose Journey date");
			border1.setTitleJustification(TitledBorder.CENTER);
			NorthSouthPanel.setBorder(border1);
			

			
			JPanel SouthWest = new JPanel();
			SouthWest.setLayout(new BorderLayout());
			SouthWest.add(Time, BorderLayout.NORTH);
			SouthWest.add(Price, BorderLayout.SOUTH);
			
			JPanel SouthCenter = new JPanel();
			SouthCenter.setLayout(new BorderLayout());
			SouthCenter.add(Admin, BorderLayout.CENTER);
			
			JPanel SouthEast = new JPanel();
			SouthEast.setLayout(new BorderLayout());
			SouthEast.add(Route, BorderLayout.NORTH);
			SouthEast.add(Quit, BorderLayout.SOUTH);
			
			ButtonGroup sort = new ButtonGroup();//
			South.setLayout(new BorderLayout());
			
			RouteOptions.setLayout(new BorderLayout());
			sort.add(alpha);
			sort.add(Byroute);
			RouteOptions.add(alpha, BorderLayout.WEST);
			RouteOptions.add(Byroute, BorderLayout.EAST);
			
			RouteOptions.setVisible(false);
			South.add(RouteOptions,BorderLayout.NORTH);
			South.add(SouthWest, BorderLayout.WEST);
			South.add(SouthCenter,BorderLayout.CENTER);
			South.add(SouthEast,BorderLayout.EAST);
			South.setVisible(true);
			
			frame.add(South, BorderLayout.SOUTH);
			frame.add(NorthPanel, BorderLayout.NORTH);
			
			frame.pack();
			
			thehandler handler = new thehandler();
			
			
			Time.addActionListener(handler);
			Price.addActionListener(handler);
			Route.addActionListener(handler);
			Admin.addActionListener(handler);
			Exit.addActionListener(handler);
			Quit.addActionListener(handler);
			alpha.addActionListener(handler);
			Byroute.addActionListener(handler);
			returnButton.addActionListener(handler);
			
		}
		/**
		 * this is another subclass created within this class to add functionality to the admin menu GUI
		 * @author amrithanayar
		 *
		 */
		private class thehandler implements ActionListener{
			/**
			 * This is the method used to add functionality to the buttons 
			 */
			public void actionPerformed(ActionEvent event){
				if(event.getSource()==Quit){
					frame.dispose();
					
				}
				Journey TrainJourney = new Journey();
				RailwayDatabase data = new RailwayDatabase();
				int LeavingStation = LeavingComboBox.getSelectedIndex();
				int ArrivingStation = ArrivingComboBox.getSelectedIndex();
				int Day = DayComboBox.getSelectedIndex();
				int Month = MonthComboBox.getSelectedIndex();
				int Year = YearComboBox.getItemAt(YearComboBox.getSelectedIndex());
				boolean returnJourney;
				if(!(TrainJourney.isValidDate(Day,Month,Year))){
					JOptionPane.showMessageDialog(frame,"Please enter a valid date","Inane error",JOptionPane.ERROR_MESSAGE);
				}
				
				ArrayList<String> route = null;
				
				
				if(LeavingStation==ArrivingStation){
					JOptionPane.showMessageDialog(frame,"Please choose different Station to leave from or arrive to","Inane error",JOptionPane.ERROR_MESSAGE);
				}
				if(event.getSource()==Byroute){
					RouteOptions.setVisible(false);
					route=data.AccessStops(LeavingStation, ArrivingStation);
					NorthOnclick.removeAll();
					NorthAlpha.removeAll();
					String RouteStops="";
					for(int i=0; i<route.size();i++){
					if(i==route.size()-1)	{
					RouteStops+=" and " + route.get(i);
					}
					else if (i==route.size()-2){
						RouteStops+=route.get(i);
					}
					else{
						RouteStops+=route.get(i) + ",";
						}
					}
					
					JLabel Byroute = new JLabel(RouteStops);
					NorthBeta.setLayout(new BorderLayout());
					NorthBeta.add(labelstops, BorderLayout.NORTH);
					NorthBeta.add(Byroute, BorderLayout.SOUTH);
					NorthOnclick.add(NorthBeta,BorderLayout.SOUTH);
					frame.add(NorthOnclick,BorderLayout.CENTER);
					frame.pack();
				}
				if(event.getSource()==alpha){
					
					NorthOnclick.removeAll();
					route=data.AccessStops(LeavingStation, ArrivingStation);
					
					NorthAlpha.removeAll();
					
					String Stops[]= new String[route.size()];
					for(int i = 0;i< route.size();i++){
						Stops[i]=route.get(i);
					}
					String temp;
					for(int i = 0;i< route.size();i++){
						for(int j =i+1;j<route.size();j++){
							if(Stops[i].compareTo(Stops[j])>0){
								temp = Stops[i];
								Stops[i] = Stops[j];
								Stops[j] = temp;
							}
						}
						

					}
					
					String RouteDisplay="";
					for(int i = 0; i<route.size();i++){
						if(i==route.size()-1){
							RouteDisplay+=" and "+Stops[i];
						}
						else if(i==0){
							RouteDisplay+=Stops[i];
						}
						else{
							RouteDisplay+=","+Stops[i];
						}
					}
					JLabel alpharoute = new JLabel(RouteDisplay);
					NorthAlpha.setLayout(new BorderLayout());
					NorthAlpha.add(labelstops, BorderLayout.NORTH);
					NorthAlpha.add(alpharoute, BorderLayout.SOUTH);
					NorthOnclick.add(NorthAlpha,BorderLayout.SOUTH);
					frame.add(NorthOnclick,BorderLayout.CENTER);
					frame.pack();
				}
		
				if(event.getSource()==Time){
					if(!(LeavingStation==ArrivingStation)){
			double Time = TrainJourney.GetTime(LeavingStation, ArrivingStation);
			this.TimePanel(Time);
			
					}
			}
			
			if(event.getSource()==Price){
				RouteOptions.setVisible(false);
				if(!(LeavingStation==ArrivingStation)){
			if(returnButton.isSelected()){
				returnJourney = true;
			}
			else{
				returnJourney = false;
			}
			boolean discount = TrainJourney.DiscountPrice(Day, Month);
			double Price = TrainJourney.GetPrice(LeavingStation, ArrivingStation, Day, Month, returnJourney);
			DecimalFormat df = new DecimalFormat("#.00");
			String PriceACTUAL =df.format(Price);
			this.PricePanel(PriceACTUAL, discount );	
			NorthOnclick.setVisible(true);
			frame.pack();
				
				
			}
			}
		
			if(event.getSource()==Route){
				RouteOptions.setVisible(false);
				NorthOnclick.removeAll();
				if(!(LeavingStation==ArrivingStation)){
				
				
				route=TrainJourney.GetRoute(LeavingStation, ArrivingStation);
				if(route.size()==0){
					NorthOnclick.removeAll();
					JLabel nostops = new JLabel("There are no stops on your journey");
					NorthOnclick.add(nostops, BorderLayout.CENTER);
					frame.add(NorthOnclick, BorderLayout.CENTER);
					frame.pack();
				}
				else if(route.size()==1){
					NorthOnclick.removeAll();
					String labelstops=route.get(0) + " is the only stop on this journey.";
					JLabel stops = new JLabel(labelstops);
					NorthOnclick.add(stops,BorderLayout.CENTER);
					frame.add(NorthOnclick, BorderLayout.CENTER);
					frame.pack();
				}
				else{
					RouteOptions.setVisible(true);
					
				}
				
				
				NorthOnclick.setVisible(true);
				frame.pack();
			}
			}
		
			
		
			if(event.getSource()==Admin){
				RouteOptions.setVisible(false);
				if(!(LeavingStation==ArrivingStation)){
				AdminMenuGUI getadminmenu = new AdminMenuGUI();
				getadminmenu.CreateAdminMenu();
			}
			}
			}
		/**
		 * function that is called when the time button is clicked to create a visible panel
		 * @param time refers to the time of the journey
		 */
			private void TimePanel(double time) {
				NorthOnclick.removeAll();
				NorthOnclick.setLayout(new BorderLayout());
				int hours=(int)(time/60);
				
				int minutes = (int)(time-(hours*60));
				String TimeString;
				if(hours==0){
				TimeString = "Your Journey will take " + minutes + " minutes";
				}
				else if(minutes==0){
				TimeString = "Your Journey will take " + hours + " hours";
				}
				else {
				TimeString = "Your Journey will take " + hours + " hours and " + minutes + " minutes";
				
				}
				JPanel centre = new JPanel();
				centre.setLayout(new BorderLayout());
				JLabel displayTime = new JLabel(TimeString);
				centre.add(displayTime, BorderLayout.CENTER);
				NorthOnclick.add(centre, BorderLayout.CENTER);
				frame.add(NorthOnclick, BorderLayout.CENTER);
				NorthOnclick.setVisible(true);
				frame.pack();
				
			}
			/**
			 * this method is called when the user clicks the price button to create appearing panel with information on it
			 * @param priceACTUAL refers to the price of the ticket
			 * @param discount boolean value determining if the user is eligible for a discounted price
			 */
			private void PricePanel(String priceACTUAL, boolean discount){
				NorthOnclick.removeAll();
				NorthOnclick.setLayout(new BorderLayout());
				 JPanel NorthPrice = new JPanel();
				String PriceString = "Your Journey will cost £ "+ priceACTUAL;
				JLabel displayPrice = new JLabel(PriceString);
				
				
				NorthPrice.add(displayPrice, BorderLayout.NORTH);
				if(discount==true){
					JLabel discountmessage = new JLabel("You are travelling on the last day of the month so your ticket price is discounted by 10%");
					NorthPrice.add(discountmessage, BorderLayout.SOUTH);
					}
				
				NorthOnclick.add(NorthPrice,BorderLayout.CENTER);
				frame.add(NorthOnclick, BorderLayout.CENTER);
				
				
				
			}
			/**
			 * this method is called when the user clicks the route panel
			 * @param route is the arraylist of the stops on that particular journey
			 */
			private void RoutePanel(ArrayList<String> route){
				
				NorthOnclick.removeAll();
				NorthCenter.setLayout(new BorderLayout());
				NorthOnclick.removeAll();
				
				
				
				if(alpha.isSelected()){
					
				}
				else if (Byroute.isSelected()){
					
				}
				}
			
				
			}
	
		
				
			
				
			}


