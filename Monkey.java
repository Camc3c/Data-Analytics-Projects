// Author:  Cameron Chenault

// IT 145 Section X2115

// Assignment: 7-1 Project Two Submission

// 12/10/2023

// Creating Monkey Class
public class Monkey extends RescueAnimal {

    // Insatnce variable
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Constructors
    public Monkey(String name, String species, String gender, String age, String height,
    String weight, String bodyLength, String tailLength, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setBodyLength(bodyLength);
        setTailLength(tailLength);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);


    }

    // Tail Length Accessor Method
    public String getTailLength() {
        return tailLength;
    }

    // Tail Length Mutator Method
    public void setTailLength(String monkeyTailLength) {
        tailLength = monkeyTailLength;
    }

    // Height Accessor Method
    public String getHeight() {
        return height;
    }

    // Height Mutator Method
    public void setHeight(String monkeyHeight) {
        height = monkeyHeight;
    }

    // Body Length Accessor Method
    public String getBodyLength() {
        return bodyLength;
    }

    // Body Length Mutator Method
    public void setBodyLength(String monkeyBodyLength) {
        bodyLength = monkeyBodyLength;
    }

    // Species Accessor Method
    public String getSpecies() {
        return species;
    }

    // Species Mutator Method
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }









}