/*
@author Jéssica Lopes
x21147477
AAP CA1
 */

package aap_21_ca_1;

public enum ModesOfTransport {
    BUS("BUS"),
    TRAIN ("TRAIN"),
    CAR ("CAR"),
    MOTORBIKE ("MOTOR BIKE"),
    BIKE("BIKE"),
    WALK("WALK");

    private final String modeOfTransport;

    //constructor
    ModesOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }
}
