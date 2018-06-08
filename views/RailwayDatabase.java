package views;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is the superclass containing all information about journey
 * @author amrithanayar
 *
 */
@SuppressWarnings({ "serial", "unused" })//supresses warmings about unused import
public class RailwayDatabase implements Serializable {
	protected String TrainStations[]={"Leicester","Loughborough","Nottingham","Derby","York"};//Array containing Stations
	protected double TrainInfo [][][] = new double[5][5][3];
	public static ArrayList<String> LeicestertoLeicester = new ArrayList<String>();
	public static ArrayList<String> LeicestertoLoughborough = new ArrayList<String>();
	public static ArrayList<String> LeicestertoNottingham = new ArrayList<String>();
	public static ArrayList<String> LeicestertoDerby = new ArrayList<String>();
	public static ArrayList<String> LeicestertoYork = new ArrayList<String>();

	public static ArrayList<String> LoughboroughtoLeicester = new ArrayList<String>();
	public static ArrayList<String> LoughboroughtoLoughborough = new ArrayList<String>();
	public static ArrayList<String> LoughboroughtoNottingham = new ArrayList<String>();
	public static ArrayList<String> LoughboroughtoDerby = new ArrayList<String>();
	public static ArrayList<String> LoughboroughtoYork = new ArrayList<String>();

	public static ArrayList<String> NottinghamtoLeicester = new ArrayList<String>();
	public static ArrayList<String> NottinghamtoLoughborough = new ArrayList<String>();
	public static ArrayList<String> NottinghamtoNottingham = new ArrayList<String>();
	public static ArrayList<String> NottinghamtoDerby = new ArrayList<String>();
	public static ArrayList<String> NottinghamtoYork = new ArrayList<String>();

	public static ArrayList<String> DerbytoLeicester = new ArrayList<String>();
	public static ArrayList<String> DerbytoLoughborough = new ArrayList<String>();
	public static ArrayList<String> DerbytoNottingham = new ArrayList<String>();
	public static ArrayList<String> DerbytoDerby = new ArrayList<String>();
	public static ArrayList<String> DerbytoYork = new ArrayList<String>();

	public static ArrayList<String> YorktoLeicester = new ArrayList<String>();
	public static ArrayList<String> YorktoLoughborough = new ArrayList<String>();
	public static ArrayList<String> YorktoNottingham = new ArrayList<String>();
	public static ArrayList<String> YorktoDerby = new ArrayList<String>();
	public static ArrayList<String> YorktoYork = new ArrayList<String>();

	public static ArrayList<ArrayList<String>> Leicester =new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> Loughborough =new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> Nottingham =new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> Derby =new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> York =new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<ArrayList<String>>> Stops = new ArrayList<ArrayList<ArrayList<String>>>();
	/**
	 * This reads the stops from the file chosen by the user
	 * @param selectedFile the name of the file that the user chooses using JFile chooser
	 */
	public void ReadStopsFromFile(File selectedFile){
		
		Stops.clear();
		
		File file = selectedFile;
		ArrayList<ArrayList<ArrayList<String>>> readObject=null;
		FileInputStream inFileStream = null;
		try {
			inFileStream = new FileInputStream(file);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(inFileStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			@SuppressWarnings("unchecked")// supresses unchecked warning due to conversion of file recieved object to arraylist
			ArrayList<ArrayList<ArrayList<String>>> readObject2 = (ArrayList<ArrayList<ArrayList<String>>>) in.readObject();
			readObject = readObject2;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//because I stored all the stops as ArrayLists with indexed according the station index below I could assign the stops to the journeys
		LeicestertoLoughborough=readObject.get(0).get(0);
		
		
		LeicestertoNottingham=readObject.get(0).get(1);
		LeicestertoDerby=readObject.get(0).get(2);
		LeicestertoYork=readObject.get(0).get(3);
		
		LoughboroughtoLeicester=readObject.get(1).get(0);
		
		LoughboroughtoNottingham=readObject.get(1).get(1);
		LoughboroughtoDerby=readObject.get(1).get(2);
		LoughboroughtoYork=readObject.get(1).get(3);
		
		NottinghamtoLeicester=readObject.get(2).get(0);
		NottinghamtoLoughborough=readObject.get(2).get(1);
		
		NottinghamtoDerby=readObject.get(2).get(2);
		NottinghamtoYork=readObject.get(2).get(3);
		
		DerbytoLeicester=readObject.get(3).get(0);
		DerbytoLoughborough=readObject.get(3).get(1);
		DerbytoNottingham=readObject.get(3).get(2);
		
		DerbytoYork=readObject.get(3).get(3);
		
		YorktoLeicester=readObject.get(4).get(0);
		YorktoLoughborough=readObject.get(4).get(1);
		YorktoNottingham=readObject.get(4).get(2);
		YorktoDerby=readObject.get(4).get(3);
		
		
		Stops=readObject;
		
	
	}
	/**
	 * This method is called by the AdminGUI class to save the user inputted stops to a file name of their choise
	 * @param FileName
	 */
	public void SaveStopsToFile(String FileName){
		Leicester.clear();
		Loughborough.clear();
		Nottingham.clear();
		Derby.clear();
		York.clear();
		Stops.clear();
		
		Leicester.add(LeicestertoLeicester);
		Leicester.add(LeicestertoLoughborough);
		Leicester.add(LeicestertoNottingham);
		Leicester.add(LeicestertoDerby);
		Leicester.add(LeicestertoYork);
		
		Loughborough.add(LoughboroughtoLeicester);
		Loughborough.add(LoughboroughtoLoughborough);
		Loughborough.add(LoughboroughtoNottingham);
		Loughborough.add(LoughboroughtoDerby);
		Loughborough.add(LoughboroughtoYork);
		
		Nottingham.add(NottinghamtoLeicester);
		Nottingham.add(NottinghamtoLoughborough);
		Nottingham.add(NottinghamtoNottingham);
		Nottingham.add(NottinghamtoDerby);
		Nottingham.add(NottinghamtoYork);
		
		Derby.add(DerbytoLeicester);
		Derby.add(DerbytoLoughborough);
		Derby.add(DerbytoNottingham);
		Derby.add(DerbytoDerby);
		Derby.add(DerbytoYork);
		
		York.add(YorktoLeicester);
		York.add(YorktoLoughborough);
		York.add(YorktoNottingham);
		York.add(YorktoDerby);
		York.add(YorktoYork);
		
		Stops.add(Leicester);
		Stops.add(Loughborough);
		Stops.add(Nottingham);
		Stops.add(Derby);
		Stops.add(York);
		
	
		String NameOfFile=FileName+".data";
		
		File outFile = new File(NameOfFile);
		FileOutputStream outFileStream = null;
		/**
		 * here an exception is thrown in case the file chosen by the user cannot be read
		 */
		try {
			outFileStream = new FileOutputStream(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(outFileStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.writeObject(Stops);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * This method simply clear information of journey stops, this is called when the user wants to retrieve a new file of stops so any previous data is overriden
	 * @param LeavingStationIndex is the index of the station the user has chosen to leave from
	 * @param ArrivingStationIndex is the index of the station the user has chosen to arrive to
	 */
	public void emptyarraylist(int LeavingStationIndex,int ArrivingStationIndex){
		
				LeicestertoLeicester.clear();
				
			
				LeicestertoLoughborough.clear();
				
			
				LeicestertoNottingham.clear();
				
			
				LeicestertoDerby.clear();
				
			
				LeicestertoYork.clear();
				
			
				LoughboroughtoLeicester.clear();
				
			
				LoughboroughtoLoughborough.clear();
				
			
				LoughboroughtoNottingham.clear();
				
			
				LoughboroughtoDerby.clear();
			
				LoughboroughtoYork.clear();
				
			
				NottinghamtoLeicester.clear();
				
			
				NottinghamtoLoughborough.clear();
				
			
				NottinghamtoNottingham.clear();
				
			
				NottinghamtoDerby.clear();
				
			
				NottinghamtoYork.clear();
				
			
				DerbytoLeicester.clear();
				
			
				DerbytoLoughborough.clear();
				
			
				DerbytoNottingham.clear();
				
			
				DerbytoDerby.clear();
				
			
			YorktoLeicester.clear();
				
			
				YorktoLoughborough.clear();
				
			
				YorktoNottingham.clear();
				
			
				YorktoDerby.clear();
				
			
				YorktoYork.clear();
				}
		
			
		/**
		 * This method allows all the other classes to access the varaibles containing the information on each journey's stop information
		 * @param LeavingStationIndex is the index of the station that the user chooses to leave from
		 * @param ArrivingStationIndex is the index of the station that the user chooses to arrive to
		 * @return
		 */
	public ArrayList<String> AccessStops(int LeavingStationIndex,int ArrivingStationIndex){
		ArrayList<String> route = new ArrayList<String>();
		if(Stops.size()==0){
			return route;
		}
		if(LeavingStationIndex==0){
			if(ArrivingStationIndex==0){
				route=Stops.get(0).get(0);
				
			}
			else if(ArrivingStationIndex==1){
				route=Stops.get(0).get(1);
				
			}
			else if(ArrivingStationIndex==2){
				route=Stops.get(0).get(2);
				
			}
			else if(ArrivingStationIndex==3){
				route=Stops.get(0).get(3);
				
			}
			else if(ArrivingStationIndex==4){
				route=Stops.get(0).get(4);
				
			}
			
		}
		else if(LeavingStationIndex==1){
			if(ArrivingStationIndex==0){
				route=Stops.get(1).get(0);
				
			}
			else if(ArrivingStationIndex==1){
				route=Stops.get(1).get(1);
				
			}
			else if(ArrivingStationIndex==2){
				route=Stops.get(1).get(2);
				
			}
			else if(ArrivingStationIndex==3){
				route=Stops.get(1).get(3);
			}
			else if(ArrivingStationIndex==4){
				route=Stops.get(1).get(4);
				
			}
		}
		else if(LeavingStationIndex==2){
			if(ArrivingStationIndex==0){
				route=Stops.get(2).get(0);
				
			}
			else if(ArrivingStationIndex==1){
				route=Stops.get(2).get(1);
				
			}
			else if(ArrivingStationIndex==2){
				route=Stops.get(2).get(2);
				
			}
			else if(ArrivingStationIndex==3){
				route=Stops.get(2).get(3);
				
			}
			else if(ArrivingStationIndex==4){
				route=Stops.get(2).get(4);
				
			}
		}
		else if(LeavingStationIndex==3){
			if(ArrivingStationIndex==0){
				route=Stops.get(3).get(0);
				
			}
			else if(ArrivingStationIndex==1){
				route=Stops.get(3).get(1);
				
			}
			else if(ArrivingStationIndex==2){
				route=Stops.get(3).get(2);
				
			}
			else if(ArrivingStationIndex==3){
				route=Stops.get(3).get(3);
				
			}
			else if(ArrivingStationIndex==4){
				route=Stops.get(3).get(4);
				
			}
		}
		else if(LeavingStationIndex==4){
			if(ArrivingStationIndex==0){
				route=Stops.get(4).get(0);
			}
			else if(ArrivingStationIndex==1){
				route=Stops.get(4).get(1);
			}
			else if(ArrivingStationIndex==2){
				route=Stops.get(4).get(2);
			}
			else if(ArrivingStationIndex==3){
				route=Stops.get(4).get(3);
			}
			else if(ArrivingStationIndex==4){
				route=Stops.get(4).get(4);
			}
		}
		
		return route;
			
		}
	/**
	 * this method is to give other classes acesss to the multi-dimensional array containing all information of journey times and prices
	 * @return returns multi-dimensional array
	 */
	
	public double[][][] AccessTrainInfo(){ //function allowing other classes to access the multidimensional array containing the prices and journey times
		this.adddata();
		return TrainInfo;
	}
	public String[] AccessTrainStations(){
		return TrainStations;
	}
	public  double[] gettimesandprices( double singlecost, double returncost, double journeytime){ //function used within this class to create the array for each journey's times and prices
		 double RouteInfo[]= {singlecost,returncost,journeytime};
		 return RouteInfo;
	}

	/**
	 * this method is used to create the multi-dimensional array
	 */
	public void adddata() { //method to create  the multidimensional array containing the prices and journey times, used within this class only
		
		TrainInfo[0][0]=this.gettimesandprices(0,0,0);
		TrainInfo[0][1]=this.gettimesandprices(2.50, 4.00, 10);
		TrainInfo[0][2]=this.gettimesandprices(3.50, 6.20, 30);
		TrainInfo[0][3]=this.gettimesandprices(3.70, 7.00, 48);
		TrainInfo[0][4]=this.gettimesandprices(23.50, 25.00, 65);
		TrainInfo[1][0]=this.gettimesandprices(2.50, 4.00, 10);
		TrainInfo[1][1]=this.gettimesandprices(0, 0, 0);
		TrainInfo[1][2]=this.gettimesandprices(1.50, 2.50, 15);
		TrainInfo[1][3]=this.gettimesandprices(1.25, 2.50, 23);
		TrainInfo[1][4]=this.gettimesandprices(11.50, 20.00, 60);
		TrainInfo[2][0]=this.gettimesandprices(3.50, 6.20,  30);
		TrainInfo[2][1]=this.gettimesandprices(1.50, 2.50, 15);
		TrainInfo[2][2]=this.gettimesandprices(0, 0, 0);
		TrainInfo[2][3]=this.gettimesandprices(2.50, 3.00, 12);
		TrainInfo[2][4]=this.gettimesandprices(11.50, 16.00, 40);
		TrainInfo[3][0]=this.gettimesandprices(3.70, 7.00, 48);
		TrainInfo[3][1]=this.gettimesandprices(2.00, 2.50, 25);
		TrainInfo[3][2]=this.gettimesandprices(1.50,3.00,10);
		TrainInfo[3][3]=this.gettimesandprices(0, 0, 0);
		TrainInfo[3][4]=this.gettimesandprices(7.20, 16.00, 85);
		TrainInfo[4][0]=this.gettimesandprices(12.50, 25.00, 70);
		TrainInfo[4][1]=this.gettimesandprices(12.20, 20.00, 60);
		TrainInfo[4][2]=this.gettimesandprices(8.20, 16.00, 40);
		TrainInfo[4][3]=this.gettimesandprices(11.20, 16.00, 75);
		TrainInfo[4][4]=this.gettimesandprices(0, 0, 0);
		
		}
	/**
	 * This method is called by the AdminMenuGUI class when the user chooses to add a stop to a particular journey
	 * @param stop this is a string of the name of the stop the user chooses to add
	 * @param LeavingStationIndex this is the index of the station user is leaving from
	 * @param ArrivingStationIndex this is the index of the station the user is arriving to
	 */
	public void addStops(String stop, int LeavingStationIndex, int ArrivingStationIndex){
		
		if(LeavingStationIndex==0){
			if(ArrivingStationIndex==0){
				LeicestertoLeicester.add(stop);
				
			}
			else if(ArrivingStationIndex==1){
				LeicestertoLoughborough.add(stop);
				
			}
			else if(ArrivingStationIndex==2){
				LeicestertoNottingham.add(stop);
			}
			else if(ArrivingStationIndex==3){
				LeicestertoDerby.add(stop);
			}
			else if(ArrivingStationIndex==4){
				LeicestertoYork.add(stop);
			}
			
		}
		else if(LeavingStationIndex==1){
			if(ArrivingStationIndex==0){
				LoughboroughtoLeicester.add(stop);
				
			}
			else if(ArrivingStationIndex==1){
				LoughboroughtoLoughborough.add(stop);
			}
			else if(ArrivingStationIndex==2){
				LoughboroughtoNottingham.add(stop);
			}
			else if(ArrivingStationIndex==3){
				LoughboroughtoDerby.add(stop);
			}
			else if(ArrivingStationIndex==4){
				LoughboroughtoYork.add(stop);
				
			}
		}
		else if(LeavingStationIndex==2){
			if(ArrivingStationIndex==0){
				NottinghamtoLeicester.add(stop);
			}
			else if(ArrivingStationIndex==1){
				NottinghamtoLoughborough.add(stop);
			}
			else if(ArrivingStationIndex==2){
				NottinghamtoNottingham.add(stop);
			}
			else if(ArrivingStationIndex==3){
				NottinghamtoDerby.add(stop);
			}
			else if(ArrivingStationIndex==4){
				NottinghamtoYork.add(stop);
			}
		}
		else if(LeavingStationIndex==3){
			if(ArrivingStationIndex==0){
				DerbytoLeicester.add(stop);
			}
			else if(ArrivingStationIndex==1){
				DerbytoLoughborough.add(stop);
			}
			else if(ArrivingStationIndex==2){
				DerbytoNottingham.add(stop);
			}
			else if(ArrivingStationIndex==3){
				DerbytoDerby.add(stop);
			}
			else if(ArrivingStationIndex==4){
				DerbytoYork.add(stop);
			}
		}
		else if(LeavingStationIndex==4){
			if(ArrivingStationIndex==0){
				YorktoLeicester.add(stop);
			}
			else if(ArrivingStationIndex==1){
				YorktoLoughborough.add(stop);
			}
			else if(ArrivingStationIndex==2){
				YorktoNottingham.add(stop);
			}
			else if(ArrivingStationIndex==3){
				YorktoDerby.add(stop);
			}
			else if(ArrivingStationIndex==4){
				YorktoYork.add(stop);
			}
		}
		
		}	
	
	

}
