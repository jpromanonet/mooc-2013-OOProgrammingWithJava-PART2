import java.util.*;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> regList;

    public VehicleRegister() {
        this.regList = new HashMap<RegistrationPlate, String>();
    }


    public boolean add(RegistrationPlate plate, String owner) {

        if (this.regList.containsKey(plate)) {
            if (this.regList.get(plate).equals(owner)) {
                return false;
            }
        }

        this.regList.put(plate, owner);
        return true;

    }


    public String get(RegistrationPlate plate) {
        if (this.regList.containsKey(plate)) {
            return this.regList.get(plate);     // return value of hashmap "regList" object "plate"
        }
        return null;
    }


    public boolean delete(RegistrationPlate plate) {
        if (this.regList.containsKey(plate)) {
            this.regList.remove(plate);
            return true;
        }
        return false;
    }


    public void printRegistrationPlates() {
        System.out.print("[");

        for (RegistrationPlate thisPlate : this.regList.keySet()) {
            System.out.println(thisPlate);		// print thisPlate
            System.out.print(", ");
        }

        System.out.println("]");
    }


    public void printOwners() {
        ArrayList<String> ownerList = new ArrayList<String>();			// create list of owners, outside of loop

        for (RegistrationPlate thisPlate : this.regList.keySet()) {		// cycle through all keys

            String currentOwner = this.regList.get(thisPlate);		// create string "currentOwner" from value associated to "thisPlate" key in hashmap "regList"

            if (ownerList.contains(currentOwner)) {
                // do nothing if it's already in the "ownerList" arraylist.
            } else {
                // add it to the arraylist if it does not exist, and print it.
                ownerList.add(currentOwner);
                System.out.println(this.regList.get(thisPlate));
            }
        }
    }
}