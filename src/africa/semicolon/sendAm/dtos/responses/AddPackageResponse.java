package africa.semicolon.sendAm.dtos.responses;

import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.Status;

public class AddPackageResponse {
    private int id;
    private String name;
    private int weightInGrammes;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightInGrammes() {
        return weightInGrammes;
    }

    public void setWeightInGrammes(int weightInGrammes) {
        this.weightInGrammes = weightInGrammes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}