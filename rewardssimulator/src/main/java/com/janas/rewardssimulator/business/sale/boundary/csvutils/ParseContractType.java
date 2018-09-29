package com.janas.rewardssimulator.business.sale.boundary.csvutils;



import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

import com.janas.rewardssimulator.business.sale.boundary.ContractType;

public class ParseContractType extends CellProcessorAdaptor {
    
    public ParseContractType() {
            super();
    }
    
    public ParseContractType(CellProcessor next) {
            // this constructor allows other processors to be chained after ParseDay
            super(next);
    }
    
    public Object execute(Object value, CsvContext context) {
            
            validateInputNotNull(value, context);  // throws an Exception if the input is null
            
            for (ContractType contractType : ContractType.values()){
                    if (contractType.name().equalsIgnoreCase(value.toString())){
                           
                            return next.execute(contractType, context);
                    }
            }
            
            throw new SuperCsvCellProcessorException(
                    String.format("Could not parse '%s' as a partnerLevel", value), context, this);
    }
}