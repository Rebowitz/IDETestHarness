/**
 * GenericDAO.java
 *
 * Last Update $Id: GenericDAO.java,v 1.2 2008-08-12 16:46:00 rba Exp $
 *
 * History:
 * $Log: GenericDAO.java,v $
 * Revision 1.2  2008-08-12 16:46:00  rba
 * New package name changes to support partitioning of code to reduce unneeded code in mockdc.
 *
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 * Revision 1.1  2008-05-16 20:02:39  lgl
 * Initial checkin after split from lrit_ide project.
 *
 * Revision 1.2  2008-04-03 22:34:43  lgl
 * Major refactoring of domain model, resulting in the addition of several new classes as well as changes to old.
 *
 * Revision 1.1  2008-03-24 18:14:51  lgl
 * Major refactoring of code to split into common, dcinterface, and ddpinterface main packages.
 *
 * Revision 1.2  2008-03-24 17:23:45  lgl
 * Return updated object from createOrUpdate().
 *
 * Revision 1.1  2008-03-24 16:58:25  lgl
 * Initial checkin
 *
 */
package org.imo.lrit.ide.test.dao;

import java.io.Serializable;
import java.util.List;

import org.imo.lrit.ide.common.model.Base;

/**
 * Interface defining common methods all IDE DAOs will implement. Any database
 * IO problems will result in RuntimeExceptions which must be managed by the
 * caller.
 */
public interface GenericDAO<T extends Base, ID extends Serializable> {

    /**
     * Make the passed object persistent (store it in the database).
     * 
     * This method updates the createdBy, dtgCreated, modifiedBy, and
     * dtgModified properties, as appropriate, prior to making the object
     * persistent.
     * 
     * @see org.imo.lrit.ide.common.dao.GenericDAO#create(java.lang.Object)
     */
    public T create(T object);

    /**
     * Deletes the associated object from the database.
     * 
     * @param object
     *            the object to be deleted
     */
    public void delete(T object);

    /**
     * Get all objects of the type associated with this DAO.
     * 
     * @return A list of all objects associated with this DAO.
     */
    public List<T> findAll();

    /**
     * Get all objects that match non-excluded properties of the example object.
     * The primary key field of the example is ignored during the search - only
     * the other fields that are non-null are used as part of the where clause.
     * @param example
     *            the example object
     * @param excludeProperty
     *            the name of a property to be ignored
     * @param enableLike
     *            enable query that uses LIKE. Example can then HQL wildcard
     *            symbols (% and _).
     * @return a List of Objects that match the example
     */
    public List<T> findByExample(T example, boolean enableLike,
            String... excludeProperty);

    /**
     * Gets the Object, of type T, associated with the specified id. If lock is
     * true, the associated database row is locked for update.
     * 
     * @param id
     *            the id to find
     * @param lock
     *            true = lock for update, false = no lock
     * @return the object found, or null if there is no such object associated
     *         with the specified id
     */
    public T findById(ID id, boolean lock);

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
    public T update(T object);
}
