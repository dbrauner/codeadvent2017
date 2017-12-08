package checksum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by douglas on 05/12/2017.
 */
public class ChecksumCalculator {

    public String calculateDifferenceChecksum(String input) {
        Integer checksum = 0;
        String[] rows = input.split("\\n");

        for (String row : rows) {
            String[] stringList = row.split("\\s+");
            ArrayList<Integer> numberList = new ArrayList<Integer>();
            for (String number : stringList) {
                numberList.add(Integer.parseInt(number));
            }
            Collections.sort(numberList);
            checksum += Math.abs( numberList.get(numberList.size() - 1) - numberList.get(0));
        }
        return checksum.toString();
    }

    public String evenlyDivisible(String input){
        Integer checksum = 0;
        String[] rows = input.split("\\n");

        for (String row : rows) {
            String[] stringList = row.split("\\s+");
            ArrayList<Integer> numberList = new ArrayList<Integer>();
            for (String number : stringList) {
                numberList.add(Integer.parseInt(number));
            }
            for (int i = 0; i < numberList.size(); i++) {
                for (int j = 0; j < numberList.size(); j++) {
                    if (i != j) {
                        float notRounded = (float) numberList.get(i) / (float) numberList.get(j);
                        float rounded = Math.round((float) numberList.get(i) / (float) numberList.get(j));
                        if (notRounded == rounded)
                            checksum += (int) rounded;
                    }
                }
            }
        }
        return checksum.toString();
    }



}
