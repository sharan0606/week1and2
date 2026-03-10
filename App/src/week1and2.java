import java.util.*;

public class week1and2 {

    static void findTwoSum(int[] arr, int target){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){

            int complement = target - arr[i];

            if(map.containsKey(complement)){
                System.out.println("Pair: "+complement+" + "+arr[i]+" = "+target);
                return;
            }

            map.put(arr[i],i);
        }

        System.out.println("No pair found");
    }

    public static void main(String[] args){

        int[] transactions = {500,300,200,700};

        findTwoSum(transactions,500);
    }
}