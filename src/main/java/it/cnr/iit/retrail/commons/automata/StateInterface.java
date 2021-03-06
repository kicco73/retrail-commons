/*
 * CNR - IIT
 * Coded by: 2014 Enrico "KMcC;) Carniani
 */
package it.cnr.iit.retrail.commons.automata;

import java.util.Collection;

/**
 *
 * @author oneadmin
 */
public interface StateInterface {
    String getName();
    Collection<String> getNextInputs();
    Collection<ActionInterface> getNextActions();
    ActionInterface getAction(String actionName);
    void addAction(ActionInterface action);
}
