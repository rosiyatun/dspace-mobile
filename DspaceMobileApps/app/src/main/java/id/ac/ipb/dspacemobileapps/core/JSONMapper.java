package id.ac.ipb.dspacemobileapps.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * Created by Hanif Affandi Hartanto on 7/17/2015.
 */
public class JSONMapper extends ObjectMapper {
    private static final long serialVersionUID = -8442793783918521285L;
    public JSONMapper() {
        registerModule(new JodaModule());
    }
}
