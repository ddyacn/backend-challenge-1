package org.challenge;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

public class StatisticsTest {

  @Test
  public void testThatMedianIsMiddlePointInUnorderedOddListOfNumbers() {
    Double median = Statistics.median(asList(1.0, 7.0, 3.0, 6.0, 9.0));
    Assert.assertThat(median, is(6.0));
  }

  @Test
  public void testThatMedianIsAverageOfTwoMiddleElementsOfUnorderedEvenListOfNumbers() {
    Double median = Statistics.median(asList(1.0, 4.0, 5.0, 6.0, 3.0, 9.0));
    Assert.assertThat(median, is(4.5));

  }

  @Test
  public void testThatFinds5thPercentile() {
    Double percentile = Statistics.percentile(5, asList(15.0, 40.0, 35.0, 20.0, 50.0));
    Assert.assertThat(percentile, is(15.0));
  }

  @Test
  public void testThatFinds30thPercentile() {
    Double percentile = Statistics.percentile(30, asList(15.0, 40.0, 35.0, 20.0, 50.0));
    Assert.assertThat(percentile, is(20.0));
  }

  @Test
  public void testThatFinds40thPercentile() {
    Double percentile = Statistics.percentile(40, asList(15.0, 40.0, 35.0, 20.0, 50.0));
    Assert.assertThat(percentile, is(20.0));
  }

  @Test
  public void testThatFinds50thPercentile() {
    Double percentile = Statistics.percentile(50, asList(15.0, 40.0, 35.0, 20.0, 50.0));
    Assert.assertThat(percentile, is(35.0));
  }

  @Test
  public void testThatFinds100thPercentile() {
    Double percentile = Statistics.percentile(100, asList(15.0, 40.0, 35.0, 20.0, 50.0));
    Assert.assertThat(percentile, is(50.0));
  }
}
