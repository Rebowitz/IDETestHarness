/**
 * DAOFactory.java
 *
 * Last Update $Id: DAOFactory.java,v 1.1.1.1 2008-07-01 17:47:54 rba Exp $
 *
 * History:
 * $Log: DAOFactory.java,v $
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 * Revision 1.3  2008-05-20 21:14:59  lgl
 * Restored all the DDPVersionInfo stuff.
 *
 * Revision 1.1  2008-05-16 20:02:38  lgl
 * Initial checkin after split from lrit_ide project.
 *
 * Revision 1.4  2008-05-14 20:58:16  lgl
 * Modified to accommodate the IDE and IDE_CONTACTS tables.
 *
 * Revision 1.3  2008-04-10 18:31:53  lgl
 * Modified to support DDPVersionInfo
 *
 * Revision 1.2  2008-04-03 22:34:43  lgl
 * Major refactoring of domain model, resulting in the addition of several new classes as well as changes to old.
 *
 * Revision 1.1  2008-03-24 18:14:51  lgl
 * Major refactoring of code to split into common, dcinterface, and ddpinterface main packages.
 *
 * Revision 1.1  2008-03-24 16:58:25  lgl
 * Initial checkin
 *
 */
package org.imo.lrit.ide.test.dao;

/**
 * Abstract class which all DAO factories must extend.
 * 
 * An implementation class must implement all getXXXDAO() methods. All DAO
 * factories should be thread safe Singletons, with a static getInstance()
 * method for obtaining the single instance.
 */
public abstract class DAOFactory {
    private static DAOFactory daofactory;

    static {
        // default to HibernateDAOFactory
        daofactory = HibernateDAOFactory.getInstance();
    }

    /**
     * Gets the DAOFactory instance for this application.
     * 
     * @return the DAOFactory instance for this application
     */
    public static DAOFactory getInstance() {
        return daofactory;
    }

    protected DAOFactory() {
    }

    public abstract SprDAO getSprDAO();

    public abstract TestMainDAO getTestMainDAO();

    public abstract TestMetadataDAO getTestMetadataDAO();


    public void setDAOFactoryClass(Class<DAOFactory> clazz) {
        try {
            daofactory = (DAOFactory) clazz.getDeclaredMethod("getInstance")
                .invoke(null);
        } catch (Exception e) {
            // could be InstantiationException or IllegalAccessException
            throw new RuntimeException(
                "Unable to instantiate DAOFactory of class " + clazz.getName(),
                e);
        }
    }
}
