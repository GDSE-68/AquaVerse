package lk.ijse.aquaverse;

import com.fazecast.jSerialComm.SerialPort;
import javafx.scene.control.Label;
import lk.ijse.aquaverse.controller.MainDashboardFormController;
import lk.ijse.aquaverse.db.DB;
import lk.ijse.aquaverse.entity.Arduino;

public class SerialConnection {
    static double conductivity;
    static double pH;
    static double turbidity;


    public static void getValuesFromSensors(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                getValues();
            }
        }).start();

    }

    public static void getValues() {

        SerialPort[] ports = SerialPort.getCommPorts();

        if (ports.length == 0) {
            System.out.println("No serial ports found.");
            return;
        }

        SerialPort port = SerialPort.getCommPort("COM12"); // Choose the appropriate port

        if (port.openPort()) {
            System.out.println("Port opened successfully.");
            port.setBaudRate(9600); // Set the same baud rate as in your Arduino code

            StringBuilder receivedData = new StringBuilder();

            while (true) {
                byte[] readBuffer = new byte[128];
                int numRead = port.readBytes(readBuffer, readBuffer.length);

                if (numRead > 0) {
                    String data = new String(readBuffer, 0, numRead);


                    // Append received data to the StringBuilder
                    receivedData.append(data);

                    // Check if we have received a complete line of data
                    if (receivedData.toString().contains("\n")) {
                        String[] values = receivedData.toString().trim().split(",");

                        if (values.length == 3) {
                            try {
                                turbidity = Double.parseDouble(values[0]);
                                pH = Double.parseDouble(values[1]);
                                conductivity = Double.parseDouble(values[2]);

                                // Now you have the temperature, humidity, and moisture values in your Java program
                                System.out.println("Turbulity: " + turbidity );
                                System.out.println("Ph: " + pH );
                                System.out.println("Conductivity: " + conductivity );

                                Arduino arduino=new Arduino(
                                        String.valueOf(turbidity),
                                        String.valueOf(pH),
                                        String.valueOf(conductivity)

                                );

                                DB.db.put("A1",arduino);


//                                MainDashboardFormController m1 = new MainDashboardFormController(turbidity,pH,conductivity);
//                                m1.setValue(turbidity,pH,conductivity);

                            } catch (NumberFormatException e) {
                                System.err.println("Error parsing values: " + e.getMessage());
                            }
                        }

                        // Clear the receivedData StringBuilder for the next set of data
                        receivedData.setLength(0);
                    }
                }
            }
        } else {
            System.err.println("Failed to open the port.");
        }
    }
}
