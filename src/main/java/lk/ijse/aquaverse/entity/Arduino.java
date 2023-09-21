package lk.ijse.aquaverse.entity;


public class Arduino {
     private String Turbidity;
     private String Conductivity;

    public Arduino(String turbidity, String conductivity, String ph) {
        Turbidity = turbidity;
        Conductivity = conductivity;
        Ph = ph;
    }

    public Arduino() {
    }

    private String Ph;

    public String getTurbidity() {
        return Turbidity;
    }

    public void setTurbidity(String turbidity) {
        Turbidity = turbidity;
    }

    public String getConductivity() {
        return Conductivity;
    }

    public void setConductivity(String conductivity) {
        Conductivity = conductivity;
    }

    public String getPh() {
        return Ph;
    }

    public void setPh(String ph) {
        Ph = ph;
    }
}
