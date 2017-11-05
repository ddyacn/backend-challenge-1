package org.challenge.data.mapper;

public interface CsvLineMapper<V> {

  V map(String line);
}
