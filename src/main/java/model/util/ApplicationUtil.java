package model.util;

import java.util.HashMap;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author skuarch
 */
public class ApplicationUtil {
    
    //==========================================================================
    public static HashMap<String, Object> createParameters(String personEmail, String personName, String personLastName, String personPassword, String personPhone, short personGenderId, String address, String addressZipCode, String addressCountry, String addressCity, String addressState, long freelancerId) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("person.email", StringEscapeUtils.escapeHtml4(String.valueOf(personEmail)));
            hm.put("person.name", StringEscapeUtils.escapeHtml4(String.valueOf(personName)));
            hm.put("person.lastName", StringEscapeUtils.escapeHtml4(String.valueOf(personLastName)));
            hm.put("password", MD5Util.getHash(StringEscapeUtils.escapeHtml4(String.valueOf(personPassword))));
            hm.put("person.phone", StringEscapeUtils.escapeHtml4(String.valueOf(personPhone)));
            hm.put("person.gender.id", personGenderId);
            hm.put("address.all", StringEscapeUtils.escapeHtml4(String.valueOf(address)));
            hm.put("address.zipCode", Integer.parseInt(addressZipCode));
            hm.put("address.country", StringEscapeUtils.escapeHtml4(String.valueOf(addressCountry)));
            hm.put("address.city", StringEscapeUtils.escapeHtml4(String.valueOf(addressCity)));
            hm.put("address.state", StringEscapeUtils.escapeHtml4(String.valueOf(addressState)));
            hm.put("freelancer.id", freelancerId);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }
    
}
