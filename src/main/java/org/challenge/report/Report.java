package org.challenge.report;

import java.util.List;
import java.util.Map;

public interface Report {

  String getName();

  List<String> getColumns();

  Map<String, Double> getRows();
}
