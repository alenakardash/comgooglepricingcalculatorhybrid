package com.google.hybrid.model;

import java.util.Objects;

public class ComputeEngine {
    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String series;
    private String instanceType;
    private String numberOfGPU;
    private String GPUType;
    private String localSSD;
    private String dataCenterLocation;
    private String committedUsage;
    private String price;

    public ComputeEngine(String numberOfInstances, String operatingSystem, String machineClass, String series,
    String instanceType, String numberOfGPU, String GPUType, String localSSD, String dataCenterLocation,
      String committedUsage, String price) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.series = series;
        this.instanceType = instanceType;
        this.numberOfGPU = numberOfGPU;
        this.GPUType = GPUType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.committedUsage = committedUsage;
        this.price = price;

    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getGPUType() {
        return GPUType;
    }

    public void setGPUType(String GPUType) {
        this.GPUType = GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setDataCenterLocation(String dataCenterLocation) {
        this.dataCenterLocation = dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", series='" + series + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", numberOfGPU='" + numberOfGPU + '\'' +
                ", GPUType='" + GPUType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return getNumberOfInstances().equals(that.getNumberOfInstances()) &&
                getOperatingSystem().equals(that.getOperatingSystem()) &&
                getMachineClass().equals(that.getMachineClass()) &&
                getSeries().equals(that.getSeries()) &&
                getInstanceType().equals(that.getInstanceType()) &&
                getNumberOfGPU().equals(that.getNumberOfGPU()) &&
                getGPUType().equals(that.getGPUType()) &&
                getLocalSSD().equals(that.getLocalSSD()) &&
                getDataCenterLocation().equals(that.getDataCenterLocation()) &&
                getCommittedUsage().equals(that.getCommittedUsage()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(), getOperatingSystem(), getMachineClass(), getSeries(), getInstanceType(), getNumberOfGPU(), getGPUType(), getLocalSSD(), getDataCenterLocation(), getCommittedUsage(), getPrice());
    }
}
