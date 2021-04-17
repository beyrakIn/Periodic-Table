package com.example.chemistry.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Element implements Serializable {
    private String name;
    private String appearance;
    private float atomic_mass;
    private float boil;
    private String category;
    private String color = null;
    private float density;
    private String discovered_by;
    private float melt;
    private float molar_heat;
    private String named_by = null;
    private float number;
    private float period;
    private String phase;
    private String source;
    private String spectral_img = null;
    private String summary;
    private String symbol;
    private float xpos;
    private float ypos;
    List<Integer> shells = new ArrayList<>();
    private String electron_configuration;
    private String electron_configuration_semantic;
    private float electron_affinity;
    private float electronegativity_pauling;
    List<Float> ionization_energies = new ArrayList<>();
    private String cpk_hex;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getAppearance() {
        return appearance;
    }

    public float getAtomic_mass() {
        return atomic_mass;
    }

    public float getBoil() {
        return boil;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public float getDensity() {
        return density;
    }

    public String getDiscovered_by() {
        return discovered_by;
    }

    public float getMelt() {
        return melt;
    }

    public float getMolar_heat() {
        return molar_heat;
    }

    public String getNamed_by() {
        return named_by;
    }

    public float getNumber() {
        return number;
    }

    public float getPeriod() {
        return period;
    }

    public String getPhase() {
        return phase;
    }

    public String getSource() {
        return source;
    }

    public String getSpectral_img() {
        return spectral_img;
    }

    public String getSummary() {
        return summary;
    }

    public String getSymbol() {
        return symbol;
    }

    public float getXpos() {
        return xpos;
    }

    public float getYpos() {
        return ypos;
    }

    public String getElectron_configuration() {
        return electron_configuration;
    }

    public String getElectron_configuration_semantic() {
        return electron_configuration_semantic;
    }

    public float getElectron_affinity() {
        return electron_affinity;
    }

    public float getElectronegativity_pauling() {
        return electronegativity_pauling;
    }

    public String getCpk_hex() {
        return cpk_hex;
    }

    public List<Integer> getShells() {
        return shells;
    }

    public List<Float> getIonization_energies() {
        return ionization_energies;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public void setAtomic_mass(float atomic_mass) {
        this.atomic_mass = atomic_mass;
    }

    public void setBoil(float boil) {
        this.boil = boil;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public void setDiscovered_by(String discovered_by) {
        this.discovered_by = discovered_by;
    }

    public void setMelt(float melt) {
        this.melt = melt;
    }

    public void setMolar_heat(float molar_heat) {
        this.molar_heat = molar_heat;
    }

    public void setNamed_by(String named_by) {
        this.named_by = named_by;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setSpectral_img(String spectral_img) {
        this.spectral_img = spectral_img;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setXpos(float xpos) {
        this.xpos = xpos;
    }

    public void setYpos(float ypos) {
        this.ypos = ypos;
    }

    public void setElectron_configuration(String electron_configuration) {
        this.electron_configuration = electron_configuration;
    }

    public void setElectron_configuration_semantic(String electron_configuration_semantic) {
        this.electron_configuration_semantic = electron_configuration_semantic;
    }

    public void setElectron_affinity(float electron_affinity) {
        this.electron_affinity = electron_affinity;
    }

    public void setElectronegativity_pauling(float electronegativity_pauling) {
        this.electronegativity_pauling = electronegativity_pauling;
    }

    public void setCpk_hex(String cpk_hex) {
        this.cpk_hex = cpk_hex;
    }

    public void setShells(List<Integer> shells) {
        this.shells = shells;
    }

    public void setIonization_energies(List<Float> ionization_energies) {
        this.ionization_energies = ionization_energies;
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", appearance='" + appearance + '\'' +
                ", atomic_mass=" + atomic_mass +
                ", boil=" + boil +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", density=" + density +
                ", discovered_by='" + discovered_by + '\'' +
                ", melt=" + melt +
                ", molar_heat=" + molar_heat +
                ", named_by='" + named_by + '\'' +
                ", number=" + number +
                ", period=" + period +
                ", phase='" + phase + '\'' +
                ", source='" + source + '\'' +
                ", spectral_img='" + spectral_img + '\'' +
                ", summary='" + summary + '\'' +
                ", symbol='" + symbol + '\'' +
                ", xpos=" + xpos +
                ", ypos=" + ypos +
                ", shells=" + shells +
                ", electron_configuration='" + electron_configuration + '\'' +
                ", electron_configuration_semantic='" + electron_configuration_semantic + '\'' +
                ", electron_affinity=" + electron_affinity +
                ", electronegativity_pauling=" + electronegativity_pauling +
                ", ionization_energies=" + ionization_energies +
                ", cpk_hex='" + cpk_hex + '\'' +
                '}';
    }
}