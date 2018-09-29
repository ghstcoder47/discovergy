package com.janas.rewardssimulator.business.partner.boundary.csvutils;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

import com.janas.rewardssimulator.business.partner.boundary.PartnerLevel;

public class ParsePartnerLevel extends CellProcessorAdaptor {
    
    public ParsePartnerLevel() {
            super();
    }
    
    public ParsePartnerLevel(CellProcessor next) {
            // this constructor allows other processors to be chained after ParseDay
            super(next);
    }
    
    public Object execute(Object value, CsvContext context) {
            
            validateInputNotNull(value, context);  // throws an Exception if the input is null
            
            for (PartnerLevel partnerLevel : PartnerLevel.values()){
                    if (partnerLevel.name().equalsIgnoreCase(value.toString())){
                           
                            return next.execute(partnerLevel, context);
                    }
            }
            
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a partnerLevel", value), context, this);
    }
}