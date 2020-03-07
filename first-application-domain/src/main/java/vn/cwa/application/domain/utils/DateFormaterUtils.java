package vn.cwa.application.domain.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DateFormaterUtils {

  static SimpleDateFormat YYYYMMDDHMS = new SimpleDateFormat("yyyyMMddHHmmss");
  
  public String formatCsvTimestamp(Date date) {
    return YYYYMMDDHMS.format(date);
  }
}
