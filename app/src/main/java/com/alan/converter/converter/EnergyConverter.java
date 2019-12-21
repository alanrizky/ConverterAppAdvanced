package com.alan.converter.converter;

public class EnergyConverter {
    public enum Binary {
        JOULE,
        KILOJOULE,
        KILOCALORIES,
        ELECTROVOLT,
        FOOTPOUND;

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

    public EnergyConverter(Binary from, Binary to) {
        double k = 1;
        switch (from) {
            case JOULE:
                if (to == Binary.JOULE) {
                    k = 1;
                } else if (to == Binary.KILOJOULE) {
                    k = 0.001;
                } else if (to == Binary.KILOCALORIES) {
                    k = 0.000239006;
                } else if (to == Binary.ELECTROVOLT) {
                    k = 6.24151623389e+18;
                } else if (to == Binary.FOOTPOUND) {
                    k = 0.73756296354629247158;
                }
                break;

            case KILOJOULE:
                if (to == Binary.JOULE) {
                    k = 1000.0011040005616678;
                } else if (to == Binary.KILOJOULE) {
                    k = 1;
                } else if (to == Binary.KILOCALORIES) {
                    k = 0.23900600000013424995;
                } else if (to == Binary.ELECTROVOLT) {
                    k = 66.24151623389000027e+21;
                } else if (to == Binary.FOOTPOUND) {
                    k = 737.56296354629262169;
                }
                break;

            case KILOCALORIES:
                if (to == Binary.JOULE) {
                    k = 4184.0046191383507903;
                } else if (to == Binary.KILOJOULE) {
                    k = 4.1840046191383510887;
                } else if (to == Binary.KILOCALORIES) {
                    k = 1;
                } else if (to == Binary.ELECTROVOLT) {
                    k = 2.61145039225957625e+22;
                } else if (to == Binary.FOOTPOUND) {
                    k = 3085.9634394776880981;
                }
                break;

            case FOOTPOUND:
                if (to == Binary.JOULE) {
                    k = 1.3558194451551770499;
                } else if (to == Binary.KILOJOULE) {
                    k = 0.001355819445155177121;
                } else if (to == Binary.KILOCALORIES) {
                    k = 0.00032404862455907672281;
                } else if (to == Binary.ELECTROVOLT) {
                    k = 846235978;
                } else if (to == Binary.FOOTPOUND) {
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
