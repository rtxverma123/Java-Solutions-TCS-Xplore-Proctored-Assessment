import java.util.*;
public class Solution{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        navalVessel[] shipss = new navalVessel[4];
        for(int i=0 ;i<shipss.length;i++){
            int vesselId = s.nextInt(); s.nextLine();
            String vesselName = s.nextLine();
            int noOfVoyagesPlanned = s.nextInt();
            int noOfVoyagesCompleted = s.nextInt();s.nextLine();
            String purpose = s.nextLine();
            shipss[i] = new navalVessel(vesselId, vesselName, noOfVoyagesPlanned, noOfVoyagesCompleted, purpose);
        }

        int per = s.nextInt(); s.nextLine();
        String pur = s.nextLine();
        int output1 = findAvgVoyagesByPct(shipss, per);
        if(output1>0){
            System.out.println(output1);
        } else {
            System.out.println("There are no voyages completed with this percentage");
        }

        navalVessel output2 = findVesselByGrade(pur,shipss);
        if(output2== null){
            System.out.println("No Naval Vessel is available with the specified purpose");
        } else {
            System.out.println(output2.getVesselName()+"%"+output2.getClassification());
        }


    }
    
public static int findAvgVoyagesByPct(navalVessel[] ship, int percentage){
    int avg =0;
    int count=0;
    for(int i=0; i<ship.length; i++){
        int percent = (ship[i].getNoOfVoyagesCompleted() * 100)/ship[i].getNoOfVoyagesPlanned();
        if(percent>=percentage){
            avg = avg + ship[i].getNoOfVoyagesCompleted();
            count++;
        }

    }
    return avg/count;
}

public static navalVessel findVesselByGrade(String purpose, navalVessel[] ships){
    navalVessel ship1 = null;
    for(int i=0; i<ships.length;i++){
        if(ships[i].getPurpose().equalsIgnoreCase(purpose)){
            int percentages = (ships[i].getNoOfVoyagesCompleted() * 100)/ships[i].getNoOfVoyagesPlanned();
            if(percentages==100){
                ships[i].setClassification("Star");
            } else if(percentages>80 && percentages<99){
                ships[i].setClassification("Leader");
            } else if(percentages>55 && percentages<79){
                ships[i].setClassification("Inspirer");
            } else{
                ships[i].setClassification("Striver");
            }
            ship1=ships[i];
        }
    }
    return ship1;
}
}

class navalVessel {
    private int vesselId;
    private String vesselName;
    private int noOfVoyagesPlanned;
    private int noOfVoyagesCompleted;
    private String purpose;
    private String classification;

    public navalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted,
            String purpose) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public int getNoOfVoyagesPlanned() {
        return noOfVoyagesPlanned;
    }

    public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
    }

    public int getNoOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }

    public void setNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}