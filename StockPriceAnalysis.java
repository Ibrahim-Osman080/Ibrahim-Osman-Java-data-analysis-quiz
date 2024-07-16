import java.util.ArrayList;

public class StockPriceAnalysis {

    // Method to calculate the average stock price
    public static float calculateAveragePrice(float[] stockPrices) {
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
        }
        return sum / stockPrices.length;
    }

    // Method to find the maximum stock price
    public static float findMaximumPrice(float[] stockPrices) {
        float maxPrice = stockPrices[0];
        for (float price : stockPrices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Method to count occurrences of a specific price
    public static int countOccurrences(float[] stockPrices, float targetPrice) {
        int count = 0;
        for (float price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method to compute the cumulative sum of stock prices
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPrices) {
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;
        for (float price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    // Main method to test the above methods
    public static void main(String[] args) {
        // Sample array of stock prices for 10 days
        float[] stockPricesArray = {23.5f, 24.0f, 22.8f, 25.1f, 24.5f, 23.9f, 25.3f, 24.8f, 22.7f, 23.4f};
        // Sample ArrayList of stock prices for 10 days
        ArrayList<Float> stockPricesList = new ArrayList<>();
        for (float price : stockPricesArray) {
            stockPricesList.add(price);
        }

        // Calculate the average stock price
        float averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + averagePrice);

        // Find the maximum stock price
        float maxPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + maxPrice);

        // Count the occurrences of a specific price (e.g., 24.0f)
        float targetPrice = 24.0f;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        // Compute the cumulative sum of stock prices
        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSum);
    }
}
