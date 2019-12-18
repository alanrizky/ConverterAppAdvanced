package com.alan.converter.converter;

public class SpeedConverter {
    public enum Speed {
        kmh,
        mph,
        knot,
        mmh,
        fph;

        public static Speed fromString(String text) {
            if (text != null) {
                for (Speed speed : Speed.values()) {
                    if (text.equalsIgnoreCase(speed.toString())) {
                        return speed;
                    }
                }
            }
            return null;
        }
    }

    private double kali;

    public SpeedConverter(Speed from, Speed to) {
        double k = 1;
        switch (from) {
            case kmh:
                if (to == Speed.kmh) {
                    k = 1;
                } else if (to == Speed.mph) {
                    k = 0.621371;
                } else if (to == Speed.knot) {
                    k = 0.539957;
                } else if (to == Speed.mmh) {
                    k = 0.277778;
                } else if (to == Speed.fph) {
                    k = 0.911344;
                }
                break;

            case mph:
                if (to == Speed.kmh) {
                    k = 1.60934;
                } else if (to == Speed.mph) {
                    k = 1;
                } else if (to == Speed.knot) {
                    k = 0.868976;
                } else if (to == Speed.mmh) {
                    k = 0.44704;
                } else if (to == Speed.fph) {
                    k = 1.46667;
                }
                break;

            case knot:
                if (to == Speed.kmh) {
                    k = 1.852;
                } else if (to == Speed.mph) {
                    k = 1.15078;
                } else if (to == Speed.knot) {
                    k = 1;
                } else if (to == Speed.mmh) {
                    k = 0.514444;
                } else if (to == Speed.fph) {
                    k = 1.68781;
                }
                break;

            case mmh:
                if (to == Speed.kmh) {
                    k = 3.6;
                } else if (to == Speed.mph) {
                    k = 2.23694;
                } else if (to == Speed.knot) {
                    k = 1.94384;
                } else if (to == Speed.mmh) {
                    k = 1;
                } else if (to == Speed.fph) {
                    k = 3.28084;
                }
                break;

            case fph:
                if (to == Speed.kmh) {
                    k = 1.09728;
                } else if (to == Speed.mph) {
                    k = 0.681818;
                } else if (to == Speed.knot) {
                    k = 0.592484;
                } else if (to == Speed.mmh) {
                    k = 0.3048;
                } else if (to == Speed.fph) {
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
