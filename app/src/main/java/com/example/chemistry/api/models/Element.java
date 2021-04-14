package com.example.chemistry.api.models;

import java.io.Serializable;

public class Element implements Serializable{
    private String AtomicNumber;
    private String Element;
    private String Symbol;
    private String AtomicMass;
    private String NumberofNeutrons;
    private String NumberofProtons;
    private String NumberofElectrons;
    private String Period;
    private String Group;
    private String Phase;
    private boolean Radioactive;
    private boolean Natural;
    private boolean Metal;
    private boolean Nonmetal;
    private boolean Metalloid;
    private String Type;
    private String AtomicRadius;
    private String Electronegativity;
    private String FirstIonization;
    private String Density;
    private String MeltingPoint;
    private String BoilingPoint;
    private String NumberOfIsotopes;
    private String Discoverer;
    private String Year;
    private String SpecificHeat;
    private String NumberofShells;
    private String NumberofValence;


    // Getter Methods

    public String getAtomicNumber() {
        return AtomicNumber;
    }

    public String getElement() {
        return Element;
    }

    public String getSymbol() {
        return Symbol;
    }

    public String getAtomicMass() {
        return AtomicMass;
    }

    public String getNumberofNeutrons() {
        return NumberofNeutrons;
    }

    public String getNumberofProtons() {
        return NumberofProtons;
    }

    public String getNumberofElectrons() {
        return NumberofElectrons;
    }

    public String getPeriod() {
        return Period;
    }

    public String getGroup() {
        return Group;
    }

    public String getPhase() {
        return Phase;
    }

    public boolean getRadioactive() {
        return Radioactive;
    }

    public boolean getNatural() {
        return Natural;
    }

    public boolean getMetal() {
        return Metal;
    }

    public boolean getNonmetal() {
        return Nonmetal;
    }

    public boolean getMetalloid() {
        return Metalloid;
    }

    public String getType() {
        return Type;
    }

    public String getAtomicRadius() {
        return AtomicRadius;
    }

    public String getElectronegativity() {
        return Electronegativity;
    }

    public String getFirstIonization() {
        return FirstIonization;
    }

    public String getDensity() {
        return Density;
    }

    public String getMeltingPoint() {
        return MeltingPoint;
    }

    public String getBoilingPoint() {
        return BoilingPoint;
    }

    public String getNumberOfIsotopes() {
        return NumberOfIsotopes;
    }

    public String getDiscoverer() {
        return Discoverer;
    }

    public String getYear() {
        return Year;
    }

    public String getSpecificHeat() {
        return SpecificHeat;
    }

    public String getNumberofShells() {
        return NumberofShells;
    }

    public String getNumberofValence() {
        return NumberofValence;
    }

    // Setter Methods

    public void setAtomicNumber(String AtomicNumber) {
        this.AtomicNumber = AtomicNumber;
    }

    public void setElement(String Element) {
        this.Element = Element;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    public void setAtomicMass(String AtomicMass) {
        this.AtomicMass = AtomicMass;
    }

    public void setNumberofNeutrons(String NumberofNeutrons) {
        this.NumberofNeutrons = NumberofNeutrons;
    }

    public void setNumberofProtons(String NumberofProtons) {
        this.NumberofProtons = NumberofProtons;
    }

    public void setNumberofElectrons(String NumberofElectrons) {
        this.NumberofElectrons = NumberofElectrons;
    }

    public void setPeriod(String Period) {
        this.Period = Period;
    }

    public void setGroup(String Group) {
        this.Group = Group;
    }

    public void setPhase(String Phase) {
        this.Phase = Phase;
    }

    public void setRadioactive(boolean Radioactive) {
        this.Radioactive = Radioactive;
    }

    public void setNatural(boolean Natural) {
        this.Natural = Natural;
    }

    public void setMetal(boolean Metal) {
        this.Metal = Metal;
    }

    public void setNonmetal(boolean Nonmetal) {
        this.Nonmetal = Nonmetal;
    }

    public void setMetalloid(boolean Metalloid) {
        this.Metalloid = Metalloid;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setAtomicRadius(String AtomicRadius) {
        this.AtomicRadius = AtomicRadius;
    }

    public void setElectronegativity(String Electronegativity) {
        this.Electronegativity = Electronegativity;
    }

    public void setFirstIonization(String FirstIonization) {
        this.FirstIonization = FirstIonization;
    }

    public void setDensity(String Density) {
        this.Density = Density;
    }

    public void setMeltingPoint(String MeltingPoint) {
        this.MeltingPoint = MeltingPoint;
    }

    public void setBoilingPoint(String BoilingPoint) {
        this.BoilingPoint = BoilingPoint;
    }

    public void setNumberOfIsotopes(String NumberOfIsotopes) {
        this.NumberOfIsotopes = NumberOfIsotopes;
    }

    public void setDiscoverer(String Discoverer) {
        this.Discoverer = Discoverer;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public void setSpecificHeat(String SpecificHeat) {
        this.SpecificHeat = SpecificHeat;
    }

    public void setNumberofShells(String NumberofShells) {
        this.NumberofShells = NumberofShells;
    }

    public void setNumberofValence(String NumberofValence) {
        this.NumberofValence = NumberofValence;
    }

    @Override
    public String toString() {
        return "Element{" +
                "AtomicNumber=" + AtomicNumber +
                ", Element='" + Element + '\'' +
                ", Symbol='" + Symbol + '\'' +
                ", AtomicMass=" + AtomicMass +
                ", NumberofNeutrons=" + NumberofNeutrons +
                ", NumberofProtons=" + NumberofProtons +
                ", NumberofElectrons=" + NumberofElectrons +
                ", Period=" + Period +
                ", Group=" + Group +
                ", Phase='" + Phase + '\'' +
                ", Type='" + Type + '\'' +
                ", AtomicRadius=" + AtomicRadius +
                ", Electronegativity=" + Electronegativity +
                ", FirstIonization=" + FirstIonization +
                ", Density='" + Density + '\'' +
                ", MeltingPoint=" + MeltingPoint +
                ", BoilingPoint=" + BoilingPoint +
                ", NumberOfIsotopes=" + NumberOfIsotopes +
                ", Discoverer='" + Discoverer + '\'' +
                ", Year=" + Year +
                ", SpecificHeat=" + SpecificHeat +
                ", NumberofShells=" + NumberofShells +
                ", NumberofValence=" + NumberofValence +
                '}';
    }
}
