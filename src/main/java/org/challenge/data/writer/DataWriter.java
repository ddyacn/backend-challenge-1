package org.challenge.data.writer;

import java.util.List;
import java.util.Objects;
import org.challenge.report.Report;

public interface DataWriter {

  void write(Report report);

  default void write(List<Report> reports) {

    Objects.requireNonNull(reports);

    reports.stream()
        .filter(Objects::nonNull)
        .forEach(this::write);
  }
}
