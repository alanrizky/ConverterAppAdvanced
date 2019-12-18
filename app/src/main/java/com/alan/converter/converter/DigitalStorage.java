package com.alan.converter.converter;

public class DigitalStorage {
    public enum Binary {
        BYTE,
        KILOBYTE,
        MEGABYTE,
        GIGABYTE,
        TERABYTE,
        PETABYTE;

        public static Binary fromString(String text) {
            if (text != null) {
                for (Binary binary : Binary.values()) {
                    if (text.equalsIgnoreCase(binary.toString())) {
                        return binary;
                    }
                }
            }
            return null;
        }
    }
    private double kali;

    public DigitalStorage(Binary from, Binary to) {
        double k = 1;
        switch (from) {
            case BYTE:
                if (to == Binary.BYTE) {
                    k = 1;
                }
                else if (to == Binary.KILOBYTE){
                    k = 0.001;
                }
                else if (to == Binary.MEGABYTE){
                    k = 1e-6;
                }
                else if (to == Binary.GIGABYTE){
                    k = 1e-9;
                }
                else if (to == Binary.TERABYTE){
                    k = 1e-12;
                }
                else if (to == Binary.PETABYTE){
                    k = 1e-15;
                }
                break;

            case KILOBYTE:
                if (to == Binary.BYTE) {
                    k = 1000;
                }
                else if (to == Binary.KILOBYTE){
                    k = 1;
                }
                else if (to == Binary.MEGABYTE){
                    k = 0.001;
                }
                else if (to == Binary.GIGABYTE){
                    k = 1e-6;
                }
                else if (to == Binary.TERABYTE){
                    k = 1e-9;
                }
                else if (to == Binary.PETABYTE){
                    k = 1e-12;
                }
                break;

            case MEGABYTE:
                if (to == Binary.BYTE) {
                    k = 1e+6;
                }
                else if (to == Binary.KILOBYTE){
                    k = 1000;
                }
                else if (to == Binary.MEGABYTE){
                    k = 1;
                }
                else if (to == Binary.GIGABYTE){
                    k = 0.001;
                }
                else if (to == Binary.TERABYTE){
                    k = 1e-6;
                }
                else if (to == Binary.PETABYTE){
                    k = 1e-9;
                }
                break;

            case GIGABYTE:
                if (to == Binary.BYTE) {
                    k = 1e+9;
                }
                else if (to == Binary.KILOBYTE){
                    k = 1e+6;
                }
                else if (to == Binary.MEGABYTE){
                    k = 1000;
                }
                else if (to == Binary.GIGABYTE){
                    k = 1;
                }
                else if (to == Binary.TERABYTE){
                    k = 0.001;
                }
                else if (to == Binary.PETABYTE){
                    k = 1e-6;
                }
                break;

            case TERABYTE:
                if (to == Binary.BYTE) {
                    k = 1e+12;
                }
                else if (to == Binary.KILOBYTE){
                    k = 1e+9;
                }
                else if (to == Binary.MEGABYTE){
                    k = 1e+6;
                }
                else if (to == Binary.GIGABYTE){
                    k = 1000;
                }
                else if (to == Binary.TERABYTE){
                    k = 1;
                }
                else if (to == Binary.PETABYTE){
                    k = 0.001;
                }
                break;

            case PETABYTE:
                if (to == Binary.BYTE) {
                    k = 1e+15;
                }
                else if (to == Binary.KILOBYTE){
                    k = 1e+12;
                }
                else if (to == Binary.MEGABYTE){
                    k = 1e+9;
                }
                else if (to == Binary.GIGABYTE){
                    k = 1e+6;
                }
                else if (to == Binary.TERABYTE){
                    k = 1000;
                }
                else if (to == Binary.PETABYTE){
                    k = 1;
                }
                break;
        }
        kali = k;
    }
    public double converted(double input) {
        return input * kali;
    }
}
