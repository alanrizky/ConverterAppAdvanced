package com.alan.converter.converter;

public class LengthConverter {
    public enum Unit {
        inci,
        sentimeter,
        kaki,
        meter,
        kilometer,
        mil;

        public static Unit fromString(String text) {
            if (text != null) {
                for (Unit unit : Unit.values()) {
                    if (text.equalsIgnoreCase(unit.toString())) {
                        return unit;
                    }
                }
            }
            return null;
        }
    }

    private double kali;

    public LengthConverter(Unit from, Unit to) {
        double k = 1;
        switch (from) {
            case inci:
                if (to == Unit.inci) {
                    k = 1;
                } else if (to == Unit.sentimeter) {
                    k = 2.54;
                } else if (to == Unit.kaki) {
                    k = 0.0833333;
                } else if (to == Unit.meter) {
                    k = 0.0254;
                } else if (to == Unit.kilometer) {
                    k = 2.54e-5;
                } else if (to == Unit.mil) {
                    k = 1.5783e-5;
                }
                break;

            case sentimeter:
                if (to == Unit.inci) {
                    k = 0.393701;
                } else if (to == Unit.sentimeter) {
                    k = 1;
                } else if (to == Unit.kaki) {
                    k = 0.0328084;
                } else if (to == Unit.meter) {
                    k = 0.01;
                } else if (to == Unit.kilometer) {
                    k = 1e-5;
                } else if (to == Unit.mil) {
                    k = 6.2137e-6;
                }
                break;

            case kaki:
                if (to == Unit.inci) {
                    k = 12;
                } else if (to == Unit.sentimeter) {
                    k = 30.48;
                } else if (to == Unit.kaki) {
                    k = 1;
                } else if (to == Unit.meter) {
                    k = 0.3048;
                } else if (to == Unit.kilometer) {
                    k = 0.0003048;
                } else if (to == Unit.mil) {
                    k = 0.000189394;
                }
                break;

            case meter:
                if (to == Unit.inci) {
                    k = 39.3701;
                } else if (to == Unit.sentimeter) {
                    k = 100;
                } else if (to == Unit.kaki) {
                    k = 3.28084;
                } else if (to == Unit.meter) {
                    k = 1;
                } else if (to == Unit.kilometer) {
                    k = 0.001;
                } else if (to == Unit.mil) {
                    k = 0.000621371;
                }
                break;

            case kilometer:
                if (to == Unit.inci) {
                    k = 39370.1;
                } else if (to == Unit.sentimeter) {
                    k = 100000;
                } else if (to == Unit.kaki) {
                    k = 3280.84;
                } else if (to == Unit.meter) {
                    k = 1000;
                } else if (to == Unit.kilometer) {
                    k = 1;
                } else if (to == Unit.mil) {
                    k = 0.621371;
                }
                break;

            case mil:
                if (to == Unit.inci) {
                    k = 63360;
                } else if (to == Unit.sentimeter) {
                    k = 160934;
                } else if (to == Unit.kaki) {
                    k = 5280;
                } else if (to == Unit.meter) {
                    k = 1609.34;
                } else if (to == Unit.kilometer) {
                    k = 1.60934;
                } else if (to == Unit.mil) {
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
