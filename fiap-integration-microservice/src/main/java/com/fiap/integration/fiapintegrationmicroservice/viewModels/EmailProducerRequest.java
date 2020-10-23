package com.fiap.integration.fiapintegrationmicroservice.viewModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailProducerRequest 
{
    @JsonProperty("DroneID") 
    public long droneID;
    public String droneTemperatureReading;
    public String droneHumidityReading;

    public EmailProducerRequest(long droneID, String droneTemperatureReading, String droneHumidityReading) {
        this.droneID = droneID;
        this.droneTemperatureReading = droneTemperatureReading;
        this.droneHumidityReading = droneHumidityReading;
    }
}