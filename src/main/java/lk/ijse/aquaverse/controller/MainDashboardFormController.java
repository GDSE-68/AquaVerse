package lk.ijse.aquaverse.controller;

import com.fazecast.jSerialComm.SerialPort;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import lk.ijse.aquaverse.SerialConnection;
import lk.ijse.aquaverse.db.DB;
import lk.ijse.aquaverse.entity.Arduino;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class MainDashboardFormController implements Initializable {

    double conductivity;
    double pH;
    double turbidity;
    public  Label txtTubidity;
    public Label txtConductivity;
    public Label txtAddress;
    public Label txtPh;



    public void setValue(double p, double t, double c){

        String tub= String.valueOf(p);




    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            Thread thread2=new Thread(() -> {
                SerialPort[] ports = SerialPort.getCommPorts();

                if (ports.length == 0) {
                    System.out.println("No serial ports found.");
                    return;
                }

                SerialPort port = SerialPort.getCommPort("COM13"); // Choose the appropriate port

                if (port.openPort()) {
                    System.out.println("Port opened successfully.");
                    port.setBaudRate(115200); // Set the same baud rate as in your Arduino code

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
//                                    System.out.println("Turbulity: " + turbidity );
//                                    System.out.println("Ph: " + pH );
//                                    System.out.println("Conductivity: " + conductivity );

                                        Arduino arduino=new Arduino(
                                                String.valueOf(turbidity),
                                                String.valueOf(conductivity),
                                                String.valueOf(pH)


                                        );

                                        DB.db.put("A1",arduino);
                                        System.out.println("data save");


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
            });

            thread2.start();
            Thread thread=new Thread(() -> {
                while (true){
                    try {
                        System.out.println(DB.db.get("A1").getConductivity());

                    }catch (NullPointerException e){

                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();


    }

}
