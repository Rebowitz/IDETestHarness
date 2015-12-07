package org.imo.lrit.ide.test.model;


import org.imo.lrit.ide.common.model.Base;

@SuppressWarnings("serial")
public class TestMetadata extends Base
{
    /** 
     * This attribute maps to the column TEST_ID_FK2 in the TEST_METADATA table.
     */
    protected long testid;    
	/** 
	 * This attribute maps to the column RESPMSGTYPE in the TEST_METADATA table.
	 */
	protected long respmsgtype;

	/** 
	 * This attribute represents whether the primitive attribute respmsgtype is null.
	 */
	protected boolean respmsgtypeNull = true;

	/** 
	 * This attribute maps to the column QUANTITY in the TEST_METADATA table.
	 */
	protected long quantity;

	/** 
	 * This attribute represents whether the primitive attribute quantity is null.
	 */
	protected boolean quantityNull = true;

	/** 
	 * This attribute maps to the column LOCATION in the TEST_METADATA table.
	 */
	protected String location;
	/** 
	 * This attribute represents the foreign key relationship to the TEST_MAIN table.
	 */
	protected TestMain testMain;

	/**
	 * Method 'TestMetadataDAO'
	 * 
	 */
	public TestMetadata()
	{
	}
	/**
	 * Method 'getTestIdFk2
	 */
	public long gettestid()
	{
	    return testid;
	}
	/**
	 * Method 'setTestIdFk2
	 */
	public void settestid(long testid)
	{
	    this.testid = testid;
	}
	
	/**
	 * Method 'getRespmsgtype'
	 * 
	 * @return long
	 */
	public long getRespmsgtype()
	{
		return respmsgtype;
	}

	/**
	 * Method 'setRespmsgtype'
	 * 
	 * @param respmsgtype
	 */
	public void setRespmsgtype(long respmsgtype)
	{
		this.respmsgtype = respmsgtype;
		this.respmsgtypeNull = false;
	}

	/** 
	 * Sets the value of respmsgtypeNull
	 */
	public void setRespmsgtypeNull(boolean respmsgtypeNull)
	{
		this.respmsgtypeNull = respmsgtypeNull;
	}

	/** 
	 * Gets the value of respmsgtypeNull
	 */
	public boolean isRespmsgtypeNull()
	{
		return respmsgtypeNull;
	}

	/**
	 * Method 'getQuantity'
	 * 
	 * @return long
	 */
	public long getQuantity()
	{
		return quantity;
	}

	/**
	 * Method 'setQuantity'
	 * 
	 * @param quantity
	 */
	public void setQuantity(long quantity)
	{
		this.quantity = quantity;
		this.quantityNull = false;
	}

	/** 
	 * Sets the value of quantityNull
	 */
	public void setQuantityNull(boolean quantityNull)
	{
		this.quantityNull = quantityNull;
	}

	/** 
	 * Gets the value of quantityNull
	 */
	public boolean isQuantityNull()
	{
		return quantityNull;
	}

	public String getLocation()
	{
		return location;
	}

	/**
	 * Method 'setQuantity'
	 * 
	 * @param quantity
	 */
	public void setLocation(String location)
	{
		this.location = location;
	}	
	
	/**
	 * Method 'getTestMain'
	 * 
	 * @return TestMain
	 */
	public TestMain getTestMain()
	{
		return testMain;
	}

	/**
	 * Method 'setTestMain'
	 * 
	 * @param testMain
	 */
	public void setTestMain(TestMain testMain)
	{
		this.testMain = testMain;
	}

}
