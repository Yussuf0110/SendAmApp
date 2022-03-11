package africa.semicolon.sendAm.dtos.requests;

import africa.semicolon.sendAm.data.models.PackageDescription;

public class AddPackageRequest {

    private String name;
    private int weightInGrammes;
    private int quantity;

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
}