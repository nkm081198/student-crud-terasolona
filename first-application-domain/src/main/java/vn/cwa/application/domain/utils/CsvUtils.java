package vn.cwa.application.domain.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;

import lombok.extern.slf4j.Slf4j;
import vn.cwa.application.domain.model.BaseModel;

@Component
@Slf4j
public class CsvUtils {
	 
	  final CsvPreference csvPref = new CsvPreference.Builder('"', ',', "\r\n").useQuoteMode(new AlwaysQuoteMode()).build();

	  public void write(OutputStream os, List<? extends BaseModel> objects, String[] header, String[] fieldMapping,
	      CellProcessor[] processors) {

	    try (Writer writer = new OutputStreamWriter(os, "SHIFT-JIS");
	        
	        ICsvBeanWriter beanWriter = new CsvBeanWriter(writer, csvPref)) {
	      beanWriter.writeHeader(header);

	      for (Object obj : objects) {
	        beanWriter.write(obj, fieldMapping, processors);
	      }
	      beanWriter.flush();
	    } catch (IOException ex) {
	      log.error("Error writing the CSV file: {}", ex);
	    }
	  }
}
