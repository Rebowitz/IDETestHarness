/**
 * 
 */
package org.imo.lrit.ide.test.util;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * @author llawrenc
 * 
 */
public class JSFUtil {

    /**
     * Gets an attribute object from the ServletContext.
     * 
     * @param attrName
     *            the name of the attribute to retrieve.
     * @return the object associated with attrName, or null if there is no such
     *         object in the context.
     */
    public static Object getServletContextAttribute(String attrName) {
        // ServletContext sc =
        // (ServletContext)FacesContext.getCurrentInstance().getExternalContext();
        // return sc.getAttribute(attrName);
        return FacesContext.getCurrentInstance().getExternalContext()
                .getApplicationMap().get(attrName);
    }

    /**
     * Gets the ServletContext associated with the current FacesContext.
     * @return the ServletContext associated with the current FacesContext
     */
    public static ServletContext getServletContext() {
        return (ServletContext) FacesContext.getCurrentInstance()
                .getExternalContext().getContext();
    }

    /**
     * Gets the ManagedBean associated with the specified name. If the Class of
     * the ManagedBean is not the same as the reference to which the return
     * value is assigned, a ClassCastException will be thrown.
     * 
     * @param <T>
     *            the type of reference to which the return value will be
     *            assigned
     * @param name
     *            the name of the ManagedBean, as identified in the faces config
     *            file
     * @return the ManagedBean associated with name
     */
    @SuppressWarnings("unchecked")
    public static <T> T getManagedBean(String name) {
        FacesContext fc = FacesContext.getCurrentInstance();
        return (T) fc.getELContext().getELResolver()
                .getValue(fc.getELContext(), null, name);
    }

}
