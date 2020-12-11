package hw3_files;

import java.util.Comparator;

/**
 * Keeps track of the number of Olympic medals for a nation.
 * 
 * @author rlsummerscales
 * @author Anthony Isensee
 */
public class MedalCount implements Comparable<MedalCount>{
    String name;
    int goldMedals;
    int silverMedals;
    int bronzeMedals;
    int totalMedals;
    
    /** 
     * Creates a new MedalCount instance.
     * @param name is the name of the nation
     * @param nGoldMedals is the number of gold medals
     * @param nSilverMedals is the number of silver medals
     * @param nBronzeMedals is the number of bronze medals
     */
    public MedalCount(String name, int nGoldMedals, int nSilverMedals,
                      int nBronzeMedals) {
        this.name = name;
        this.goldMedals = nGoldMedals;
        this.silverMedals = nSilverMedals;
        this.bronzeMedals = nBronzeMedals;
        totalMedals = nGoldMedals + nSilverMedals + nBronzeMedals;
    }
    
    /** Return a string describing the medal count information for the country */
    public String toString() {
        return name + ":\t" + goldMedals + ",\t" + silverMedals + ",\t" 
            + bronzeMedals + ",\t"+ totalMedals;
    }
    
    /** 
     * Compare instance of medal count with another. 
     * Nations compared based on number of total medals (descending order).
     */
    // TODO: create comparator
    public int compareTo(MedalCount that) {

        // if that should come before this
        if (that.totalMedals < this.totalMedals) return -1;
        // if this should come before that
        if (that.totalMedals > this.totalMedals) return +1;
        // if same
        return 0;

    }

    /**
     * Comparator for sorting by nation name alphabetically
     */
    public static class ByName implements Comparator<MedalCount> {

        @Override
        public int compare(MedalCount object1, MedalCount object2) {
            return object1.name.compareTo(object2.name);
        }

    }
    
    
    /** Comparator for sorting by gold medal count (descending order) */
    public static class ByGoldMedals implements Comparator<MedalCount> {

        @Override
        public int compare(MedalCount object1, MedalCount object2) {
            if(object1.goldMedals > object2.goldMedals) return -1;
            if(object1.goldMedals < object2.goldMedals) return +1;
            return 0;
        }
    }
    
}
