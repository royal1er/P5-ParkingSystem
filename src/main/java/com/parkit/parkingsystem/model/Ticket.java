package com.parkit.parkingsystem.model;
import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Ticket {
    private int id;
    private ParkingSpot parkingSpot;
    private String vehicleRegNumber;
    private double price;
    private Date inTime;
    private Date outTime;
    private ParkingSpotDAO parkingSpotDAO;
    private TicketDAO ticketDAO;
    
	public DataBaseConfig dataBaseConfig = new DataBaseConfig();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }
    

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public long parkingDuration(Date intime, Date outime) {
		long duration = 0;
		try {
			long difference_In_Time = outTime.getTime() - inTime.getTime();
			long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time);
			System.out.println("Minutes :" + difference_In_Hours);
			duration = difference_In_Hours;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duration;
	}

    public long parkingDurationInMinutes(Date intime, Date outime) {
		long duration = 0;
		try {
			long difference_In_Time = outTime.getTime() - inTime.getTime();
			long difference_In_Hours = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time);
			System.out.println("Minutes :" + difference_In_Hours);
			duration = difference_In_Hours;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duration;
	}

    public void calculReduction(TicketDAO myTicketDao) {
		try {
			System.out.println("Occurence du véhicule : " + myTicketDao.getFrequencyOfVehicle(getVehicleRegNumber()));
			if (myTicketDao.getFrequencyOfVehicle(getVehicleRegNumber()) > 2) {
				System.out.println("En tant que client régulier vous avez droit à une réduction de 5%");
				double calcul = getPrice() * 5;
				double reduction = calcul / 100;
				double total = getPrice() - reduction;
				setPrice(total);
			} else {
				System.out.println("Vous n'avez pas droit à une réduction de 5%");
			}
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
