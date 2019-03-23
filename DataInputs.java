package com.example.d_gille.teamproject;

import android.widget.Toast;

public class DataInputs
{
    protected float oilTemperature;
    protected float oilPressure;
    protected float fuelPressure;
    protected float fuelTemperature;
    protected float coolantTemperature;
    protected float engineRPM;
    protected int gear;
    protected float roomTemperature;





    public float getOilTemperature()
    {
        return oilTemperature;
    }

    public void setOilTemperature(float oilTemperature)
    {
        this.oilTemperature = oilTemperature;
    }

    public float getOilPressure()
    {
        return oilPressure;
    }

    public void setOilPressure(float oilPressure)
    {
        this.oilPressure = oilPressure;
    }

    public float getFuelPressure()
    {
        return fuelPressure;
    }

    public void setFuelPressure(float fuelPressure)
    {
        this.fuelPressure = fuelPressure;
    }

    public float getFuelTemperature()
    {
        return fuelTemperature;
    }

    public void setFuelTemperature(float fuelTemperature)
    {
        this.fuelTemperature = fuelTemperature;
    }

    public float getCoolantTemperature()
    {
        return coolantTemperature;
    }

    public void setCoolantTemperature(float coolantTemperature)
    {
        this.coolantTemperature = coolantTemperature;
    }

    public float getRoomTemperature()
    {
        return roomTemperature;
    }

    public void setRoomTemperature(float roomTemperature)
    {
        this.roomTemperature = roomTemperature;
    }

    public float getEngineRPM()
    {
        return engineRPM;
    }

    public void setEngineRPM(float engineRPM)
    {
        this.engineRPM = engineRPM;
    }

    public int getGear()
    {
        return gear;
    }

    public void setGear(int gear)
    {
        this.gear = gear;
    }

    public boolean rangeOilTemperature()
    {
        if (oilTemperature>=75.0f & oilTemperature<=120.0f)
        {
            System.out.println("The value is within the range!");
            return true;
        }


        else
        {
            System.out.println("The value is outside the range!");
            return false;
        }
    }

    public boolean rangeOilPressure()
    {
        if (oilPressure>=400.0f & oilPressure<=500.0f)
        {
            System.out.println("The value is within the range!");
            return true;
        }


        else
        {
            System.out.println("The value is outside the range!");
            return false;
        }

    }

    public boolean rangeFuelTemperature()
    {
        if (fuelTemperature>roomTemperature)
        {
            System.out.println("The value is within the range!");
            return true;
        }

        else
        {
            System.out.println("The value is outside the range!");
            return false;
        }

    }

    public boolean rangeFuelPressure()
    {
        if (fuelPressure>=380.0f & fuelPressure<=420.0f)
        {
            System.out.println("The value is within the range!");
            return true;
        }


        else
        {
            System.out.println("The value is outside the range!");
            return false;
        }

    }

    public boolean rangeCoolantTemperature()
    {
        if (coolantTemperature>=80.0f & coolantTemperature<=100.0f)
        {
            System.out.println("The value is within the range!");
            return true;
        }


        else
        {
            System.out.println("The value is outside the range!");
            return false;
        }


    }

    public boolean rangeEngineRPM()
    {
        if (engineRPM>=12500.0f)
        {
            System.out.println("The value is within the range!");
            return true;
        }


        else
        {
            System.out.println("The value is outside the range!");
            return false;
        }

    }

}
