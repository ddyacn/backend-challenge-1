package org.challenge.data.reader;

import java.util.List;

public interface DataReader<T> {

  List<T> read();
}
