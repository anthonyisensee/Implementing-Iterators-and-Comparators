package hw3_files;

/**
 * Test the comparators added to the MedalCount class.
 * 
 * @author rlsummerscales
 * @author Anthony Isensee
 */
public class TestMedalSort {
    /** 
     * Display the list of nations and their medal counts
     */
    public static void displayCountries(OlympicResults olympicResults) {
        System.out.format("%-15s %8s %8s %8s %8s\n", "Nation", "Gold", "Silver", "Bronze", "Total");

        // use our lovely, iterable data type and print  out some results
        for (MedalCount mc : olympicResults) {
            System.out.format("%-15s %8d %8d %8d %8d\n", mc.name, mc.goldMedals, mc.silverMedals, mc.bronzeMedals, mc.totalMedals);
        }
    }
    
    /**
     * Test the comparators from MedalCount.
     * 
     * @param args is an array of command line arguments
     */
    public static void main(String[] args){
        OlympicResults olympicResults = new OlympicResults();

        olympicResults.addNationResults("United States", 46, 29, 29);
        olympicResults.addNationResults("China", 38, 28, 22);
        olympicResults.addNationResults("Great Britain", 29, 17, 19);
        olympicResults.addNationResults("Russia", 24, 25, 32);
        olympicResults.addNationResults("South Korea", 13, 8, 7);
        olympicResults.addNationResults("Germany", 11, 19, 14);
        olympicResults.addNationResults("France", 11, 11, 12);
        olympicResults.addNationResults("Italy", 8, 9, 11);
        olympicResults.addNationResults("Hungary", 8, 4, 6);
        olympicResults.addNationResults("Australia", 7, 16, 12);

        // display list of nations and their medals
        displayCountries(olympicResults);
        
        // sort list by nation name
        olympicResults.sortByName();
        System.out.println("\nSorted by name:");
        displayCountries(olympicResults);
        
        // sort list by gold medals
        System.out.println("\nSorted by Gold medals:");
        olympicResults.sortByGoldMedals();
        displayCountries(olympicResults);

        // sort list by total medals
        System.out.println("\nSorted by Total Medals:");
        olympicResults.sortByTotalMetals();
        displayCountries(olympicResults);
               
    }
    
}
