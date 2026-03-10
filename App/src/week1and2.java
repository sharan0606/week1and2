import java.util.*;

public class week1and2 {

    static String[] parking = new String[10];

    static int hash(String plate){
        return Math.abs(plate.hashCode()) % parking.length;
    }

    static void park(String plate){

        int index = hash(plate);

        while(parking[index] != null){
            index = (index + 1) % parking.length;
        }

        parking[index] = plate;
        System.out.println(plate + " parked at spot " + index);
    }

    static void exit(String plate){

        for(int i=0;i<parking.length;i++){
            if(plate.equals(parking[i])){
                parking[i] = null;
                System.out.println(plate + " exited from spot " + i);
            }
        }
    }

    public static void main(String[] args){

        park("ABC123");
        park("XYZ999");
        park("CAR456");

        exit("XYZ999");
    }
}