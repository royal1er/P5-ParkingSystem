package com.parkit.parkingsystem.model;

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
}
