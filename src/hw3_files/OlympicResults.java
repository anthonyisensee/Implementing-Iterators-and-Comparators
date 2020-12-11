package hw3_files;

import java.util.*;

/**
 * Manage collection of Olympic medal results for each nation.
 * 
 * @author rlsummerscales
 * @author Anthony Isensee
 */
public class OlympicResults implements Iterable<MedalCount>{
    /** List of medal counts for each nation */
    private ArrayList<MedalCount> mMedalCountList = new ArrayList<MedalCount>();
    
    /**
     * Add a medal country entry for a nation.
     * @param countryName is the name of the nation
     * @param nGoldMedals is the number of gold medals
     * @param nSilverMedals is the number of silver medals
     * @param nBronzeMedals is the number of bronze medals
     */
    public void addNationResults(String countryName, int nGoldMedals, 
                                 int nSilverMedals, int nBronzeMedals) {
        MedalCount mc = new MedalCount(countryName, nGoldMedals, 
                                       nSilverMedals, nBronzeMedals);
        mMedalCountList.add(mc);
    }

    /* A reminder of what our two interfaces look like
    public interface Iterable<Item> {
        Iterator<Item> iterator();
    }
    public interface Iterator<Item> {
        boolean hasNext();
        Item next();
        void remove();
    }
    */

    public Iterator<MedalCount> iterator() {
        return new MedalCountArrayIterator();
    }

    private class MedalCountArrayIterator implements Iterator<MedalCount> {

        // to keep track of our current position in the iterator
        private int i = 0;

        @Override
        public boolean hasNext() {
            // if i is smaller than the size of the arraylist, it does indeed have next
            return i < mMedalCountList.size();
        }

        @Override
        public MedalCount next() {
            // return the next item in the array list while advancing i
            return mMedalCountList.get(i++);
        }

        @Override
        public void remove() {
            // not supported
        }
    }

    /**
     * Sorts the information in this class by total medal count.
     */
    public void sortByTotalMetals() {
        // sort mMedalCountList array list
        Collections.sort(mMedalCountList);
    }

    /**
     * Sorts the information in this class by country name.
     */
    public void sortByName() {
        Collections.sort(mMedalCountList, new MedalCount.ByName());
    }

    /**
     * Sorts the information in this class by number of gold medals.
     */
    public void sortByGoldMedals() {
        Collections.sort(mMedalCountList, new MedalCount.ByGoldMedals());

    }

    /*
     * Test the iterator over the medal count list.
     * 
     * @param args is an array of command line arguments

    public static void main(String[] args) {
        OlympicResults olympicResults = new OlympicResults();
        olympicResults.addNationResults("China", 26, 23, 67);
        olympicResults.addNationResults("Great Britain", 27, 23, 17);
        olympicResults.addNationResults("USA", 46, 37, 38);

        for (MedalCount mc : olympicResults) {
            System.out.format("%-15s %8d %8d %8d %8d\n", mc.name, mc.goldMedals,
                              mc.silverMedals, mc.bronzeMedals, mc.totalMedals);
        }
    }

    */

}