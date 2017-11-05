package org.challenge;

import java.util.List;

public class Statistics {

  /**
   * The median is the value separating the higher half of a data sample,
   * a population, or a probability distribution, from the lower half.
   * For a data set, it may be thought of as the "middle" value. For example,
   * in the data set {1, 3, 3, 6, 7, 8, 9}, the median is 6, the fourth
   * largest, and also the fourth smallest, number in the sample. For a
   * continuous probability distribution, the median is the value such that
   * a number is equally likely to fall above or below it.
   *
   * @param numbers input data set
   * @return the "middle" value for a given data set
   */
  public static Double median(List<Double> numbers) {
    numbers.sort(Double::compareTo);

    int middle = numbers.size() / 2;

    if (isOdd(numbers.size())) {
      return numbers.get(middle);
    } else {
      return average(numbers.get(middle - 1), numbers.get(middle));
    }
  }

  /**
   * A percentile is a measure used in statistics indicating the value below
   * which a given percentage of observations in a group of observations fall.
   * For example, the 20th percentile is the value (or score) below which 20%
   * of the observations may be found.
   *
   * @param percentile Nth number
   * @param numbers    input data set
   * @return Nth percentile value
   */
  public static Double percentile(double percentile, List<Double> numbers) {

    numbers.sort(Double::compareTo);

    double index = percentile / 100 * numbers.size();

    if (isWholeNumber(index)) {
      return numbers.get((int) index - 1);
//      return average(numbers.get((int) index - 1), numbers.get((int) index));
    } else {
      return numbers.get((int) Math.ceil(index) - 1);
    }
  }

  private static boolean isWholeNumber(double number) {
    return number % 1 == 0;
  }

  private static boolean isOdd(int number) {
    return !isEven(number);
  }

  private static boolean isEven(int number) {
    return number % 2 == 0;
  }

  private static double average(double one, double two) {
    return (one + two) / 2.0;
  }
}
