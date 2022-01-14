package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	@Autowired
	RecoveryRoomService recoverService;
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.name;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        Collection<RecoveryRoomType> recover =  this.recoverService.getAllRecoveryRoomTypes();
        for(RecoveryRoomType rc : recover) {
        	if(rc.getName().equals(text)) {
        		return rc;
        	}
        }
    	throw new ParseException("RecoveryRoomType not found: " + text, 0);

    }
    
}
