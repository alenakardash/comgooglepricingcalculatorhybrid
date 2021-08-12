package com.google.hybrid.service;

import com.google.hybrid.model.ComputeEngine;

public class ComputeEngineCreator {
    private static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    private static final String TESTDATA_OPERATING_SYSTEM = "testdata.operatingSystem";
    private static final String TESTDATA_MACHINE_CLASS = "testdata.machineClass";
    private static final String TESTDATA_SERIES = "testdata.series";
    private static final String TESTDATA_INSTANCE_TYPE = "testdata.instanceType";
    private static final String TESTDATA_NUMBER_OF_GPU = "testdata.numberOfGPU";
    private static final String TESTDATA_GPU_TYPE = "testdata.GPUType";
    private static final String TESTDATA_LOCAL_SSD = "testdata.localSSD";
    private static final String TESTDATA_DATACENTER_LOCATION = "testdata.dataCenterLocation";
    private static final String TESTDATA_COMMITED_USAGE = "testdata.commitedUsage";
    private static final String TESTDATA_PRICE = "testdata.price";

    public static ComputeEngine withParamertersFromProperty() {
        return new ComputeEngine(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES), TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM), TestDataReader.getTestData(TESTDATA_MACHINE_CLASS), TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE), TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPU), TestDataReader.getTestData(TESTDATA_GPU_TYPE), TestDataReader.getTestData(TESTDATA_LOCAL_SSD), TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITED_USAGE), TestDataReader.getTestData(TESTDATA_PRICE));
    }
}
