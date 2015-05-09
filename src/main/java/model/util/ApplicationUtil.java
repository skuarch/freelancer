package model.util;

import java.util.ArrayList;
import java.util.HashMap;
import model.beans.Category;

/**
 *
 * @author skuarch
 */
public class ApplicationUtil {

    //==========================================================================
    //company
    public static HashMap<String, Object> createParametersAffiliate(
            String personName,
            String personLastName,
            String personEmail,
            String personPhone,
            String personPassword,
            short personGenderId,
            String brand,
            String category,
            String description,
            String taxContactPersonName,
            String taxContactPersonLastName,
            String taxContactPersonEmail,
            int taxContactPersonGender,
            String taxId,
            String taxCompanyName,
            String taxContactPersonPhone,
            String address,
            String addressCountry,
            String addressState,
            String addressCity,
            String addressZipCode,
            String ownerAccountBank,
            String bank,
            String clabe,
            String emailNotifications,
            long creatorPersonId            
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags            
            hm.put("person.name", String.valueOf(personName));
            hm.put("person.lastName", String.valueOf(personLastName));
            hm.put("person.email", String.valueOf(personEmail));
            hm.put("person.phone", String.valueOf(personPhone));
            hm.put("password", String.valueOf(personPassword));
            hm.put("person.gender.id", personGenderId);
            hm.put("brand", brand);
            String[] cat = category.split(",");
            for (int i = 0; i < cat.length; i++) {
                hm.put("category[" + i + "].id", cat[i]);
            }
            hm.put("description", description);

            hm.put("contact.person.name", String.valueOf(taxContactPersonName));
            hm.put("contact.person.lastName", String.valueOf(taxContactPersonLastName));
            hm.put("contact.person.email", String.valueOf(taxContactPersonEmail));
            hm.put("contact.person.gender.id", taxContactPersonGender);
            hm.put("taxId", taxId);
            hm.put("taxCompanyName", taxCompanyName);
            hm.put("contact.person.phone", String.valueOf(taxContactPersonPhone));
            hm.put("address.all", String.valueOf(address));
            hm.put("address.country", String.valueOf(addressCountry));
            hm.put("address.city", String.valueOf(addressCity));
            hm.put("address.state", String.valueOf(addressState));
            hm.put("address.zipCode", Integer.parseInt(addressZipCode));

            hm.put("ownerAccountBank", ownerAccountBank);
            hm.put("bank", bank);
            hm.put("clabe", clabe);
            hm.put("emailNotifications", emailNotifications);

            hm.put("creatorId", creatorPersonId);            

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParametersCompany(
            String name,
            String brand,
            String personName,
            String personLastName,
            short personGenderId,
            String personPhone,
            String personEmail,
            String category,
            String password,
            String description,
            String taxContactPersonName,
            String taxContactPersonLastName,
            String taxContactPersonEmail,
            String taxContactPersonPhone,
            short taxContactPersonGender,
            String taxId,
            String taxCompanyName,
            String address,
            String addressCountry,
            String addressState,
            String addressCity,
            String addressZipCode,
            String ownerAccountBank,
            String bank,
            String clabe,
            String emailNotifications,
            long creatorPersonId
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            hm.put("name", name);
            hm.put("brand", brand);
            hm.put("person.name", personName);
            hm.put("person.lastName", personLastName);
            hm.put("person.gender.id", personGenderId);
            hm.put("person.phone", personPhone);
            hm.put("person.email", personEmail);
            String[] cat = category.split(",");
            for (int i = 0; i < cat.length; i++) {
                hm.put("category[" + i + "].id", cat[i]);
            }
            hm.put("password", String.valueOf(password));
            hm.put("description", description);
            
            hm.put("contact.person.name", taxContactPersonName);
            hm.put("contact.person.lastName", taxContactPersonLastName);
            hm.put("contact.person.email", taxContactPersonEmail);
            hm.put("contact.person.gender.id", taxContactPersonGender);
            hm.put("taxId", taxId);
            hm.put("taxCompanyName", taxCompanyName);
            hm.put("contact.person.phone", taxContactPersonPhone);
            hm.put("address.all", address);
            hm.put("address.country", addressCountry);
            hm.put("address.city", addressCity);
            hm.put("address.state", addressState);
            hm.put("address.zipCode", addressZipCode);

            hm.put("ownerAccountBank", ownerAccountBank);
            hm.put("bank", bank);
            hm.put("clabe", clabe);
            hm.put("emailNotifications", emailNotifications);

            hm.put("creatorId", creatorPersonId);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParametersTaxInformation(
            long id,
            String taxContactPersonName,
            String taxContactPersonLastName,
            String taxContactPersonEmail,
            String taxContactPersonPhone,
            short taxContactPersonGender,
            String taxId,
            String taxCompanyName,
            String address,
            String addressCountry,
            String addressState,
            String addressCity,
            String addressZipCode
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            hm.put("id", id);//company id
            hm.put("contact.person.name", taxContactPersonName);
            hm.put("contact.person.lastName", taxContactPersonLastName);
            hm.put("contact.person.email", taxContactPersonEmail);
            hm.put("contact.person.gender.id", taxContactPersonGender);
            hm.put("taxId", taxId);
            hm.put("taxCompanyName", taxCompanyName);
            hm.put("contact.person.phone", taxContactPersonPhone);
            hm.put("address.all", address);
            hm.put("address.country", addressCountry);
            hm.put("address.city", addressCity);
            hm.put("address.state", addressState);
            hm.put("address.zipCode", Integer.parseInt(addressZipCode));

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(
            long companyId,
            String name,
            String brand,
            String personName,
            String personLastName,
            short personGenderId,
            String personPhone,
            String personEmail,
            String category,            
            String description,
            long freelancerId
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            hm.put("companyId", companyId);
            hm.put("name", name);
            hm.put("brand", brand);
            hm.put("person.name", String.valueOf(personName));
            hm.put("person.lastName", String.valueOf(personLastName));
            hm.put("person.gender.id", personGenderId);
            hm.put("person.phone", String.valueOf(personPhone));
            hm.put("person.email", String.valueOf(personEmail));
            String[] cat = category.split(",");
            for (int i = 0; i < cat.length; i++) {
                hm.put("category[" + i + "].id", cat[i]);
            }            
            hm.put("description", description);
            
            hm.put("freelancer.id", freelancerId);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(String personEmail, String personName, String personLastName, String personPassword, String personPhone, short personGenderId, String brand, String address, String addressZipCode, String addressCountry, String addressCity, String addressState, long freelancerId, String ownerAccountBank, String bank, String clabe, String emailNotifications, String category, String taxCompanyName, String taxId) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags            
            hm.put("person.email", String.valueOf(personEmail));
            hm.put("person.name", String.valueOf(personName));
            hm.put("person.lastName", String.valueOf(personLastName));
            hm.put("password", MD5Util.getHash(String.valueOf(personPassword)));
            hm.put("person.phone", String.valueOf(personPhone));
            hm.put("person.gender.id", personGenderId);
            hm.put("brand", brand);
            hm.put("address.all", String.valueOf(address));
            hm.put("address.zipCode", Integer.parseInt(addressZipCode));
            hm.put("address.country", String.valueOf(addressCountry));
            hm.put("address.city", String.valueOf(addressCity));
            hm.put("address.state", String.valueOf(addressState));
            hm.put("freelancer.id", freelancerId);
            hm.put("taxId", taxId);
            hm.put("taxCompanyName", taxCompanyName);
            hm.put("ownerAccountBank", ownerAccountBank);
            hm.put("bank", bank);
            hm.put("clabe", clabe);
            hm.put("emailNotifications", emailNotifications);

            String[] cat = category.split(",");
            for (int i = 0; i < cat.length; i++) {
                hm.put("category[" + i + "].id", String.valueOf(cat[i]));
            }

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap createParametersEstablishment(
            long id,
            long type,
            String establishment_name,
            int[] category,
            String subcategory,
            String establishment_address,
            String country,
            String state,
            String city,
            String zipCode,
            String latitude,
            String longitude,
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
            long cashier_gender
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            if (type == 1) {
                hm.put("affiliateId", id);
            } else {
                hm.put("companyId", id);
            }

            hm.put("establishment.name", establishment_name);
            hm.put("establishment.address.all", establishment_address);
            hm.put("establishment.address.zipCode", Integer.parseInt(zipCode));
            hm.put("establishment.latitude", latitude);
            hm.put("establishment.longitude", longitude);
            hm.put("establishment.address.country", country);
            hm.put("establishment.address.city", city);
            hm.put("establishment.address.state", state);
            hm.put("establishment.responsable.password", responsable_password);
            hm.put("establishment.responsable.password2", responsable_password2);
            hm.put("establishment.responsable.person.name", responsable_name);
            hm.put("establishment.responsable.person.lastName", responsable_lastName);
            hm.put("establishment.responsable.person.email", responsable_email);
            hm.put("establishment.responsable.person.gender.id", responsable_gender);
            hm.put("establishment.responsable.person.phone", responsable_phone);
            hm.put("establishment.cashier[0].person.name", cashier_name);
            hm.put("establishment.cashier[0].person.lastName", cashier_lastName);
            hm.put("establishment.cashier[0].person.email", cashier_email);
            hm.put("establishment.cashier[0].person.gender.id", cashier_gender);
            hm.put("establishment.cashier[0].person.phone", cashier_phone);
            hm.put("establishment.cashier[0].password", cashier_password);
            hm.put("establishment.cashier[0].password2", cashier_password2);
            hm.put("establishment.subcategory", subcategory);

            for (int i = 0; i < category.length; i++) {
                hm.put("establishment.category[" + i + "].id", String.valueOf(category[i]));
            }

        } catch (Exception e) {
            throw e;
        }

        return hm;
    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(long id) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("id", id);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(
            long id,
            String personName,
            String personLastName,
            String personEmail,
            String personPhone,            
            short personGenderId,
            String brand,
            String category,
            String description
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("id", id);
            hm.put("person.name", personName);
            hm.put("person.lastName", personLastName);
            hm.put("person.email", personEmail);
            hm.put("person.phone", personPhone);            
            hm.put("person.gender.id", personGenderId);
            hm.put("brand", brand);

            String[] cat = category.split(",");
            for (int i = 0; i < cat.length; i++) {
                hm.put("category[" + i + "].id", cat[i]);
            }

            hm.put("description", description);
            
        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParametersUpdateEstablishment(
            long id,
            String name,
            int[] category,
            String subcategory,
            String address,
            String country,
            String state,
            String city,
            String zipCode,
            String latitude,
            String longitude
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("id", id);
            hm.put("name", name);
            hm.put("subcategory", subcategory);
            hm.put("address.all", address);
            hm.put("address.zipCode", zipCode);
            hm.put("address.country", country);
            hm.put("address.city", city);
            hm.put("address.state", state);
            hm.put("latitude", latitude);
            hm.put("longitude", longitude);

            for (int i = 0; i < category.length; i++) {
                hm.put("category[" + i + "].id", category[i]);
            }

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(
            long id,
            String name,
            String lastName,
            String phone,
            String email,
            int gender
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("id", id);
            hm.put("person.name", name);
            hm.put("person.lastName", lastName);
            hm.put("password", lastName);
            hm.put("person.phone", phone);
            hm.put("person.email", email);
            hm.put("person.gender.id", gender);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParametersUpdateResponsable(
            long id,
            String name,
            String lastName,
            String phone,
            String email,                        
            long gender
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags  
            hm.put("id", id);
            hm.put("person.name", name);
            hm.put("person.lastName", lastName);                        
            hm.put("person.phone", phone);
            hm.put("person.email", email);
            hm.put("person.gender.id", gender);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }
    
    //==========================================================================
    public static HashMap<String, Object> createParametersUpdateCashier(
            long id,
            String name,
            String lastName,
            String phone,
            String email, 
            String password,
            long gender
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags  
            hm.put("id", id);
            hm.put("person.name", name);
            hm.put("person.lastName", lastName);            
            hm.put("password", password);
            hm.put("person.phone", phone);
            hm.put("person.email", email);
            hm.put("person.gender.id", gender);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(
            long id,
            String password1,
            String password2
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags  
            hm.put("id", id);
            hm.put("password", password1);
            hm.put("password2", password2);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }
    
    //==========================================================================
    public static HashMap<String, Object> createParametersFreelancerUpdateAffiliatePassword(
            long id,
            String password1,
            String password2
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags  
            hm.put("id", id);
            hm.put("newPassword", password1);
            hm.put("newPassword2", password2);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }
    
    //==========================================================================
    public static HashMap<String, Object> createParametersFreelancerUpdateCompanyPassword(
            long id,
            String password1,
            String password2
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags  
            hm.put("id", id);
            hm.put("newPassword", password1);
            hm.put("newPassword2", password2);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(
            long affiliateId,
            String taxContactPersonName,
            String taxContactPersonLastName,
            String taxContactPersonEmail,
            short taxContactPersonGender,
            String taxId,
            String taxCompanyName,
            String taxContactPersonPhone,
            String address,
            String addressCountry,
            String addressState,
            String addressCity,
            String addressZipCode
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            hm.put("id", affiliateId);
            hm.put("contact.person.name", taxContactPersonName);
            hm.put("contact.person.lastName", taxContactPersonLastName);
            hm.put("contact.person.email", taxContactPersonEmail);
            hm.put("contact.person.gender.id", taxContactPersonGender);
            hm.put("taxId", taxId);
            hm.put("taxCompanyName", taxCompanyName);
            hm.put("contact.person.phone", taxContactPersonPhone);
            hm.put("address.all", address);
            hm.put("address.country", addressCountry);
            hm.put("address.city", addressCity);
            hm.put("address.state", addressState);
            hm.put("address.zipCode", Integer.parseInt(addressZipCode));

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static HashMap<String, Object> createParameters(
            long affiliateId,
            String ownerAccountBank,
            String bank,
            String clabe,
            String emailNotifications
    ) throws Exception {

        HashMap hm = new HashMap();

        try {

            hm.put("id", affiliateId);
            hm.put("ownerAccountBank", ownerAccountBank);
            hm.put("bank", bank);
            hm.put("clabe", clabe);
            hm.put("emailNotifications", emailNotifications);

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }

    //==========================================================================
    public static Category[] selectCategory(Category[] categories, ArrayList<Category> selectedCategories) throws Exception {

        try {

            for (Category categorie : categories) {
                selectedCategories.stream()
                        .filter(
                                (selectedCategory)
                                -> (categorie.getName().equalsIgnoreCase(selectedCategory.getName()))
                        )
                        .forEach((item) -> {
                            categorie.setIsSelected(true);
                        });
            }

        } catch (Exception e) {
            throw e;
        }

        return categories;

    }    

}
