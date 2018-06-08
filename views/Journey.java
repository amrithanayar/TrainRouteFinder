package views;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * This class contains the methods to implement the GUI's functionality
 * @author amrithanayar
 *
 */
public class Journey extends RailwayDatabase {
	RailwayDatabase data = new RailwayDatabase();
	protected double TrainInfo[][][]=data.AccessTrainInfo();
	protected ArrayList<String> adminaddedstops = new ArrayList<String>();
	
	
	/**
	 * This method returns the price of the journey chosen by the user
	 * @param LeavingStationIndex is the index of the station the user is leaving from
	 * @param ArrivingStationIndex is the index of the station the user is arriving to
	 * @param Day is the day of travel
	 * @param Month is the month of travel
	 * @param ReturnTicket is a boolean value refering to whether the user wants the return price or not
	 * @return
	 */
	public double GetPrice(int LeavingStationIndex, int ArrivingStationIndex, int Day, int Month, boolean ReturnTicket){
		boolean DiscountPrice = this.DiscountPrice(Day, Month);
		double Price;
		if(ReturnTicket==true){
			if(DiscountPrice==true){
				Price=(TrainInfo[LeavingStationIndex][ArrivingStationIndex][1])*0.9;
			}
			else{
				Price = TrainInfo[LeavingStationIndex][ArrivingStationIndex][1];
				
			}
		}
		else{
			if(DiscountPrice==true){
				 Price=(TrainInfo[LeavingStationIndex][ArrivingStationIndex][0])*0.9;
				  }
			 else{
				 Price=TrainInfo[LeavingStationIndex][ArrivingStationIndex][0];
				 }
		}
		return Price;
	}
	/**
	 * This method is used within the first method GetPrice to determine whether, given the day and month of travel, the user is entitled to a discounted price
	 * @param Day is the integer value of the day of travel
	 * @param Month is the integer value of the month of travel
	 * @return
	 */
	public boolean DiscountPrice(int Day, int Month){
		boolean answer=false;
		if(Month==1 || Month==3 || Month==5 || Month==7 || Month==8 || Month==10 || Month==12){
			if(Day==31){
				answer=true;
			}
		}
		else if(Month==2){
			if(Day==28){
				answer=true;
			}
			
		}
		
		else if(Month==4 || Month==6 || Month==9 || Month==11){
			if(Day==30){
				answer=true;
			}
			
		}
		return answer;
		
	}
	/**
	 * this method returns the time of the journey the user has chosen
	 * @param LeavingStationIndex is the index of the station the user chose to leave from
	 * @param ArrivingStationIndex is the index of the station the user chose to arrive to
	 * @return returns the journey time
	 */
	public double GetTime(int LeavingStationIndex, int ArrivingStationIndex){
		return TrainInfo[LeavingStationIndex][ArrivingStationIndex][2];
	}
	/**
	 * This method returns the route of a specified journey
	 * @param LeavingStationIndex is the index of the station the  user is leaving from
	 * @param ArrivingStationIndex is the index of the station the user is arriving to
	 * @return
	 */
	public ArrayList<String> GetRoute(int LeavingStationIndex, int ArrivingStationIndex){
		
		return data.AccessStops(LeavingStationIndex, ArrivingStationIndex);
	}
	public static boolean isValidDate(int Day, int Month, int Year){
		boolean isitadate = false;
		boolean isitaleapyear=false;
		int actualYear = (int)Year;
		actualYear=actualYear+2017;
		if((actualYear % 400 ==0)||((actualYear % 4 ==0)&&(Year%100 !=0))){
			isitaleapyear=true;
		}
		if(Day<31&&(((Month==0||Month==2)||(Month==4||Month==6))||((Month==7||Month==9)||Month==11))){
			isitadate=true;
		}
		else if(Day<20&&((Month==3||Month==5)||(Month==8||Month==10))){
			isitadate=true;
		}
		else if(Day<=28&Month==1){
			isitadate=true;
		}
		else if((Day<=29&Month==1)&&isitaleapyear){
			isitadate=true;
		}
		
		
		return isitadate;
		
	}
}
