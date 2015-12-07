/**
 * GenericHibernateDAO.java
 *
 * Last Update $Id: GenericHibernateDAO.java,v 1.2 2008-08-12 16:46:00 rba Exp $
 *
 * History:
 * $Log: GenericHibernateDAO.java,v $
 * Revision 1.2  2008-08-12 16:46:00  rba
 * New package name changes to support partitioning of code to reduce unneeded code in mockdc.
 *
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 * Revision 1.1  2008-05-16 20:02:38  lgl
 * Initial checkin after split from lrit_ide project.
 *
 * Revision 1.3  2008-04-03 22:45:46  lgl
 * Remove references to Mutable interface.
 *
 * Revision 1.2  2008-04-03 22:34:43  lgl
 * Major refactoring of domain model, resulting in the addition of several new classes as well as changes to old.
 *
 * Revision 1.1  2008-03-24 18:14:51  lgl
 * Major refactoring of code to split into common, dcinterface, and ddpinterface main packages.
 *
 * Revision 1.2  2008-03-24 17:24:04  lgl
 * Return updated object from createOrUpdate() and added a log4j Logger.
 *
 * Revision 1.1  2008-03-24 16:58:25  lgl
 * Initial checkin
 *
 */
package org.imo.lrit.ide.test.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.imo.lrit.ide.common.model.Base;
import org.imo.lrit.ide.common.util.HibernateUtil;

/**
 * 
 */
public abstract class GenericHibernateDAO<T extends Base, ID extends Serializable>
        implements GenericDAO<T, ID> {

    protected Logger log = Logger.getLogger(getClass());
    private Class<T> persistentClass;

    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Make the passed object persistent (store it in the database).
     * 
     * This method updates the createdBy, dtgCreated, modifiedBy, and
     * dtgModified properties, as appropriate, prior to making the object
     * persistent.
     * 
     * @see org.imo.lrit.ide.common.dao.GenericDAO#create(java.lang.Object)
     */
    public T create(T object) {
        Calendar currDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        object.setDatabaseModifiedTime(currDate);
        object.setDatabaseModifiedBy("IDE");
        if (object.getDatabaseCreatedBy() == null) {
            object.setDatabaseCreatedBy("IDE");
            object.setDatabaseCreateTime(currDate);
        }
        getSession().save(object);
        return object;
    }

    /**
     * Deletes the associated object from the database.
     * 
     * @see org.imo.lrit.ide.common.dao.GenericDAO#delete(java.lang.Object)
     */
    public void delete(T object) {
        getSession().delete(object);
    }

    /**
     * Get all objects that match non-excluded properties of the example object.
     * 
     * @see org.imo.lrit.ide.common.dao.GenericDAO#findAll()
     */
    public List<T> findAll() {
        return findByCriteria();
    }

    /**
     * Gets the Object, of type T, associated with the specified id. If lock is
     * true, the associated database row is locked for update.
     * 
     * @see org.imo.lrit.ide.common.dao.GenericDAO#findByExample(java.lang.Object,
     *      boolean, java.lang.String[])
     */
    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleObject, boolean enableLike,
            String... excludeProperty) {
        Criteria crit = getSession().createCriteria(persistentClass);
        Example example = Example.create(exampleObject);
        if (enableLike) {
            example.enableLike();
        }
        for (String s : excludeProperty) {
            example.excludeProperty(s);
        }
        crit.add(example);
        return (List<T>) (crit.list());
    }

    /**
     * Gets the Object, of type T, associated with the specified id. If lock is
     * true, the associated database row is locked for update.
     * 
     * @return the retrieved object, or null if there is no object associated
     *         with id
     * 
     * @see org.imo.lrit.ide.common.dao.GenericDAO#findById(java.io.Serializable,
     *      boolean)
     */
    @SuppressWarnings("unchecked")
    public T findById(ID id, boolean lock) {
        log.debug("Finding object with id: " + id);
        T obj = null;
        if (lock) {
            obj = (T) getSession().get(persistentClass, id, LockMode.UPGRADE);
        } else {
            obj = (T) getSession().get(persistentClass, id);
        }
        log.debug("Returning: " + obj);
        return obj;
    }

    /**
     * Get the Session this DAO will use for database access.
     * 
     * @return the Session this DAO will use for database access
     */
    public Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     * Make the passed object persistent (store it in the database) if it has
     * not already been stored. If it has already been stored, make sure that it
     * is up to date with what is currently in the database.
     * 
     * This method updates the createdBy, dtgCreated, modifiedBy, and
     * dtgModified properties, as appropriate, prior to making the object
     * persistent.
     * 
     * @see org.imo.lrit.ide.common.dao.GenericDAO#createOrUpdate(java.lang.Object)
     */
    public T update(T object) {
        Calendar currDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        object.setDatabaseModifiedTime(currDate);
        object.setDatabaseModifiedBy("IDE");
        getSession().update(object);
        return object;
    }

    /**
     * Helper method for findBy.. methods.
     * 
     * @param creterion
     *            the search criterion
     * @return a list of objects that match the search criterion
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... creterion) {
        Criteria crit = getSession().createCriteria(persistentClass);
        for (Criterion c : creterion) {
            crit.add(c);
        }
        return (List<T>) crit.list();
    }
}
