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

    //==========================================================================
    public static HashMap createParameters(
            long id,
            String establishment_name,
            int[] category,
            String subcategory,
            String establishment_address,
            String country,
            String state,
            String city,
            String zipCode,
            String responsable_name,
            String responsable_lastName,
            String responsable_phone,
            String responsable_email,
            String responsable_password,
            String responsable_password2,
            long responsable_gender,
            String cashier_name,
            String cashier_lastName,
            String cashier_phone,
            String cashier_email,
            String cashier_password,
            String cashier_password2,
            long cashier_gender) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("affiliateId", id);
            hm.put("establishment.name", StringEscapeUtils.escapeHtml4(String.valueOf(establishment_name)));
            hm.put("establishment.address.all", StringEscapeUtils.escapeHtml4(String.valueOf(establishment_address)));
            hm.put("establishment.address.zipCode", Integer.parseInt(zipCode));
            hm.put("establishment.address.country", StringEscapeUtils.escapeHtml4(String.valueOf(country)));
            hm.put("establishment.address.city", StringEscapeUtils.escapeHtml4(String.valueOf(city)));
            hm.put("establishment.address.state", StringEscapeUtils.escapeHtml4(String.valueOf(state)));
            hm.put("establishment.responsable.password", StringEscapeUtils.escapeHtml4(String.valueOf(responsable_password)));
            hm.put("establishment.responsable.password2", StringEscapeUtils.escapeHtml4(String.valueOf(responsable_password2)));
            hm.put("establishment.responsable.person.name", StringEscapeUtils.escapeHtml4(String.valueOf(responsable_name)));
            hm.put("establishment.responsable.person.lastName", StringEscapeUtils.escapeHtml4(String.valueOf(responsable_lastName)));
            hm.put("establishment.responsable.person.email", StringEscapeUtils.escapeHtml4(String.valueOf(responsable_email)));
            hm.put("establishment.responsable.person.gender.id", StringEscapeUtils.escapeHtml4(String.valueOf(responsable_gender)));
            hm.put("establishment.responsable.person.phone", StringEscapeUtils.escapeHtml4(String.valueOf(responsable_phone)));
            hm.put("establishment.cashier[0].person.name", StringEscapeUtils.escapeHtml4(String.valueOf(cashier_name)));
            hm.put("establishment.cashier[0].person.lastName", StringEscapeUtils.escapeHtml4(String.valueOf(cashier_lastName)));
            hm.put("establishment.cashier[0].person.email", StringEscapeUtils.escapeHtml4(String.valueOf(cashier_email)));
            hm.put("establishment.cashier[0].person.gender.id", StringEscapeUtils.escapeHtml4(String.valueOf(cashier_gender)));
            hm.put("establishment.cashier[0].person.phone", StringEscapeUtils.escapeHtml4(String.valueOf(cashier_phone)));
            hm.put("establishment.cashier[0].password", StringEscapeUtils.escapeHtml4(String.valueOf(cashier_password)));
            hm.put("establishment.cashier[0].password2", StringEscapeUtils.escapeHtml4(String.valueOf(cashier_password2)));
            hm.put("establishment.subcategory", StringEscapeUtils.escapeHtml4(String.valueOf(subcategory)));

            for (int i = 0; i < category.length; i++) {
                hm.put("establishment.category[" + i + "].id", StringEscapeUtils.escapeHtml4(String.valueOf(category[i])));
            }

        } catch (Exception e) {
            throw e;
        }

        return hm;
    }

}
