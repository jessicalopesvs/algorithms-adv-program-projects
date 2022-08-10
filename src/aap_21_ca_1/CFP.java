/*
@author Jéssica Lopes
x21147477
AAP CA1
 */
package aap_21_ca_1;

import java.util.Arrays;

/**
 *
 * @author yalemisew
 */
class CFP extends Functions implements Comparable<Object> {

    private int StudentCode;
    private String StudentName;
    private String ModeOfTransport;
    private int Distance;
    private float Emission;

    public CFP() {
    }

    public CFP(int studentCode, String studentName, String modeOfTransport, int distance, float emission) {
        this.StudentCode = studentCode;
        this.StudentName = studentName;
        this.ModeOfTransport = modeOfTransport;
        this.Distance = distance;
        this.Emission = emission;
    }

    public int getStudentCode() {
        return StudentCode;
    }

    public void setStudentCode(int StudentCode) {
        this.StudentCode = StudentCode;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getModeOfTransport() {
        return ModeOfTransport;
    }

    public void setModeOfTransport(String ModeOfTransport) throws UnsupportedModeOfTransportException {

        //MODE OF TRANSPORTATION EXCEPTION
        try {
//            System.out.println(ModeOfTransport.toUpperCase());
            ModesOfTransport.valueOf(ModeOfTransport.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedModeOfTransportException("Unsupported mode of transport. Please correct the transportation mode by choosing " +
                    "from (Bus, Train, Car, Motor Bike, Bike, Walk)");
        }
        this.ModeOfTransport = ModeOfTransport;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public int getDistance() {
        return Distance;
    }

    public void setEmission(float Emission) {
        this.Emission = Emission;
    }

    public float getEmission() {
        return Emission;
    }

    // so the CFP objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the StudentName
    @Override
    public int compareTo(Object obj) {
        CFP prod = (CFP) obj;
        return StudentName.compareTo(prod.getStudentName());
    }

    // return a String containing the CFP details
    @Override
    public String toString() {
        return StudentCode + " " + StudentName + " " + ModeOfTransport + " " + Distance + " " + Emission;
    }

}


