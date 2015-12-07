/**
 * HibernateDAOFactory.java
 *
 * Last Update $Id: HibernateDAOFactory.java,v 1.1.1.1 2008-07-01 17:47:54 rba Exp $
 *
 * History:
 * $Log: HibernateDAOFactory.java,v $
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

import java.util.HashMap;
import java.util.Map;

/**
 * A DAO factory that returns Hibernate DAOs.  This factory keeps a Map of 
 * DAO instances, always returning the same instance of each type of DAO.
 * Because of this, each DAO must be coded to behave as a Singleton even though
 * it may have a package scope constructor that may be used for testing.
 */
public class HibernateDAOFactory extends DAOFactory {
    
    private static HibernateDAOFactory factory;
    @SuppressWarnings("unchecked")
    private Map<Class,GenericHibernateDAO> daos;
    
    @SuppressWarnings("unchecked")
    private HibernateDAOFactory() {
        daos = new HashMap<Class,GenericHibernateDAO>();
        daos.put(SprDAO.class, instantiateDAO(SprDAO.class));
        daos.put(TestMainDAO.class, instantiateDAO(TestMainDAO.class));
        daos.put(TestMetadataDAO.class, instantiateDAO(TestMetadataDAO.class));
    }
    
    public static HibernateDAOFactory getInstance() {
        if (factory == null) {
            factory = new HibernateDAOFactory();
        }
        return factory;
    }
    
    /**
     * @see org.imo.lrit.ide.test.dao.DAOFactory#getBufferedObjectDAO()
     */
    public SprDAO getSprDAO() {
        return (SprDAO)daos.get(SprDAO.class);
    }

    /**
     * @see org.imo.lrit.ide.test.dao.DAOFactory#getContactDAO()
     */
    public TestMainDAO getTestMainDAO() {
        return (TestMainDAO)daos.get(TestMainDAO.class);
    }
    
    /**
     * @see org.imo.lrit.ide.test.dao.DAOFactory#getDataCentreContactDAO()
     */
    public TestMetadataDAO getTestMetadataDAO() {
        return (TestMetadataDAO)daos.get(TestMetadataDAO.class);
    }



    @SuppressWarnings("unchecked")
    private static GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = 
                (GenericHibernateDAO)daoClass.newInstance();
            return dao;
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate DAO of class " +
                                       daoClass.getName(),
                                       e);
        }
    }

}
