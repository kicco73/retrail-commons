/*
 * CNR - IIT
 * Coded by: 2014 Enrico "KMcC;) Carniani
 */
package it.cnr.iit.retrail.commons;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author oneadmin
 */
public interface PepAttributeInterface extends Serializable {

    String getCategory();

    Date getExpires();

    String getFactory();

    String getId();

    String getIssuer();

    PepAttributeInterface getParent();

    String getType();

    String getValue();

    void setExpires(Date expires);

    void setParent(PepAttributeInterface parent);

    void setValue(String value);
    
}