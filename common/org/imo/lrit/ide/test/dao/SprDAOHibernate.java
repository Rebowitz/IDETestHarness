/**
 * SprDAOHibernate.java
 *
 * Last Update $Id: SprDAOHibernate.java,v 1.1.1.1 2008-07-01 17:47:54 rba Exp $
 *
 * History:
 * $Log: SprDAOHibernate.java,v $
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 */
package org.imo.lrit.ide.test.dao;

/**
 * 
 */
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.imo.lrit.ide.test.model.Spr;

public class SprDAOHibernate extends GenericHibernateDAO<Spr, Long> implements SprDAO{

}
