package org.imo.lrit.ide.test.model;

import org.imo.lrit.ide.common.model.Base;


@SuppressWarnings("serial")
public class Spr extends Base{
    /** 
     * This attribute maps to the column TEST_ID_FK1 in the SPR table.
     */
    protected Integer testid;   
	/** 
	 * This attribute maps to the column TEST _DESCRIPTION in the SPR table.
	 */
	protected String testDescription;

	/** 
	 * This attribute maps to the column MESSAGETYPE in the SPR table.
	 */
	protected Integer messagetype;

	/** 
	 * This attribute maps to the column LATITUDE in the SPR table.
	 */
	protected String latitude;

	/** 
	 * This attribute maps to the column LONGITUDE in the SPR table.
	 */
	protected String longitude;

	/** 
	 * This attribute maps to the column TIMESTAMP1 in the SPR table.
	 */
	protected String timestamp1;

	/** 
	 * This attribute maps to the column SHIPBOURNEEQUIPMENTID in the SPR table.
	 */
	protected String shipbourneequipmentid;

	/** 
	 * This attribute maps to the column ASPID in the SPR table.
	 */
	protected String aspid;

	/** 
	 * This attribute maps to the column CSPID in the SPR table.
	 */
	protected String cspid;

	/** 
	 * This attribute maps to the column MESSAGEID in the SPR table.
	 */
	protected String messageid;

	/** 
	 * This attribute maps to the column REFERENCEID in the SPR table.
	 */
	protected String referenceid;

	/** 
	 * This attribute maps to the column MMSINUM in the SPR table.
	 */
	protected String mmsinum;

	/** 
	 * This attribute maps to the column IMONUM in the SPR table.
	 */
	protected String imonum;

	/** 
	 * This attribute represents whether the primitive attribute imonum is null.
	 */
	protected boolean imonumNull = true;

	/** 
	 * This attribute maps to the column TIMESTAMP2 in the SPR table.
	 */
	protected String timestamp2;

	/** 
	 * This attribute maps to the column TIMESTAMP3 in the SPR table.
	 */
	protected String timestamp3;

	/** 
	 * This attribute maps to the column DCID in the SPR table.
	 */
	protected String dcid;

	/** 
	 * This attribute represents whether the primitive attribute dcid is null.
	 */
	protected boolean dcidNull = true;

	/** 
	 * This attribute maps to the column TIMESTAMP4 in the SPR table.
	 */
	protected String timestamp4;

	/** 
	 * This attribute maps to the column TIMESTAMP5 in the SPR table.
	 */
	protected String timestamp5;

	/** 
	 * This attribute maps to the column RESPONSETYPE in the SPR table.
	 */
	protected Integer responsetype;

	/** 
	 * This attribute represents whether the primitive attribute responsetype is null.
	 */
	protected boolean responsetypeNull = true;

	/** 
	 * This attribute maps to the column DATAUSERREQUESTOR in the SPR table.
	 */
	protected String datauserrequestor;

	/** 
	 * This attribute represents whether the primitive attribute datauserrequestor is null.
	 */
	protected boolean datauserrequestorNull = true;

	/** 
	 * This attribute maps to the column SHIPNAME in the SPR table.
	 */
	protected String shipname;

	/** 
	 * This attribute maps to the column DATAUSERPROVIDER in the SPR table.
	 */
	protected String datauserprovider;

	/** 
	 * This attribute represents whether the primitive attribute datauserprovider is null.
	 */
	protected boolean datauserproviderNull = true;

	/** 
	 * This attribute maps to the column DDPVERSIONNUM in the SPR table.
	 */
	protected String ddpversionnum;

	/** 
	 * This attribute represents the foreign key relationship to the TEST_MAIN table.
	 */
	protected TestMain testMain;

	/**
	 * Method 'Spr'
	 * 
	 */
	public Spr()
	{
	}
    /**
     * Method 'getTestId'
     * 
     * @return Integer
     */
	public Integer gettestid()
	{
	    return testid;
	}
	/**
	 * Method 'setTestIdFk1'
	 * 
	 * @param testIdFk1
	 */	
	public void settestid(Integer testid)
	{
	    this.testid = testid;
	}
	/**
	 * Method 'getTestDescription'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTestDescription()
	{
		return testDescription;
	}

	/**
	 * Method 'setTestDescription'
	 * 
	 * @param testDescription
	 */
	public void setTestDescription(java.lang.String testDescription)
	{
		this.testDescription = testDescription;
	}

	/**
	 * Method 'getMessagetype'
	 * 
	 * @return long
	 */
	public Integer getMessagetype()
	{
		return messagetype;
	}

	/**
	 * Method 'setMessagetype'
	 * 
	 * @param messagetype
	 */
	public void setMessagetype(Integer messagetype)
	{
		this.messagetype = messagetype;
	}

	/**
	 * Method 'getLatitude'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getLatitude()
	{
		return latitude;
	}

	/**
	 * Method 'setLatitude'
	 * 
	 * @param latitude
	 */
	public void setLatitude(java.lang.String latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * Method 'getLongitude'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getLongitude()
	{
		return longitude;
	}

	/**
	 * Method 'setLongitude'
	 * 
	 * @param longitude
	 */
	public void setLongitude(java.lang.String longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * Method 'getTimestamp1'
	 * 
	 * @return java.util.Date
	 */
	public String getTimestamp1()
	{
		return timestamp1;
	}

	/**
	 * Method 'setTimestamp1'
	 * 
	 * @param timestamp1
	 */
	public void setTimestamp1(String timestamp1)
	{
		this.timestamp1 = timestamp1;
	}

	/**
	 * Method 'getShipbourneequipmentid'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getShipbourneequipmentid()
	{
		return shipbourneequipmentid;
	}

	/**
	 * Method 'setShipbourneequipmentid'
	 * 
	 * @param shipbourneequipmentid
	 */
	public void setShipbourneequipmentid(java.lang.String shipbourneequipmentid)
	{
		this.shipbourneequipmentid = shipbourneequipmentid;
	}

	/**
	 * Method 'getAspid'
	 * 
	 * @return long
	 */
	public String getAspid()
	{
		return aspid;
	}

	/**
	 * Method 'setAspid'
	 * 
	 * @param aspid
	 */
	public void setAspid(String aspid)
	{
		this.aspid = aspid;
	}

	/**
	 * Method 'getCspid'
	 * 
	 * @return long
	 */
	public String getCspid()
	{
		return cspid;
	}

	/**
	 * Method 'setCspid'
	 * 
	 * @param cspid
	 */
	public void setCspid(String cspid)
	{
		this.cspid = cspid;
	}

	/**
	 * Method 'getMessageid'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMessageid()
	{
		return messageid;
	}

	/**
	 * Method 'setMessageid'
	 * 
	 * @param messageid
	 */
	public void setMessageid(java.lang.String messageid)
	{
		this.messageid = messageid;
	}

	/**
	 * Method 'getReferenceid'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getReferenceid()
	{
		return referenceid;
	}

	/**
	 * Method 'setReferenceid'
	 * 
	 * @param referenceid
	 */
	public void setReferenceid(java.lang.String referenceid)
	{
		this.referenceid = referenceid;
	}

	/**
	 * Method 'getMmsinum'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMmsinum()
	{
		return mmsinum;
	}

	/**
	 * Method 'setMmsinum'
	 * 
	 * @param mmsinum
	 */
	public void setMmsinum(java.lang.String mmsinum)
	{
		this.mmsinum = mmsinum;
	}

	/**
	 * Method 'getImonum'
	 * 
	 * @return long
	 */
	public String getImonum()
	{
		return imonum;
	}

	/**
	 * Method 'setImonum'
	 * 
	 * @param imonum
	 */
	public void setImonum(String imonum)
	{
		this.imonum = imonum;
		this.imonumNull = false;
	}

	/** 
	 * Sets the value of imonumNull
	 */
	public void setImonumNull(boolean imonumNull)
	{
		this.imonumNull = imonumNull;
	}

	/** 
	 * Gets the value of imonumNull
	 */
	public boolean isImonumNull()
	{
		return imonumNull;
	}

	/**
	 * Method 'getTimestamp2'
	 * 
	 * @return java.util.Date
	 */
	public String getTimestamp2()
	{
		return timestamp2;
	}

	/**
	 * Method 'setTimestamp2'
	 * 
	 * @param timestamp2
	 */
	public void setTimestamp2(String timestamp2)
	{
		this.timestamp2 = timestamp2;
	}

	/**
	 * Method 'getTimestamp3'
	 * 
	 * @return java.util.Date
	 */
	public String getTimestamp3()
	{
		return timestamp3;
	}

	/**
	 * Method 'setTimestamp3'
	 * 
	 * @param timestamp3
	 */
	public void setTimestamp3(String timestamp3)
	{
		this.timestamp3 = timestamp3;
	}

	/**
	 * Method 'getDcid'
	 * 
	 * @return long
	 */
	public String getDcid()
	{
		return dcid;
	}

	/**
	 * Method 'setDcid'
	 * 
	 * @param dcid
	 */
	public void setDcid(String dcid)
	{
		this.dcid = dcid;
		this.dcidNull = false;
	}

	/** 
	 * Sets the value of dcidNull
	 */
	public void setDcidNull(boolean dcidNull)
	{
		this.dcidNull = dcidNull;
	}

	/** 
	 * Gets the value of dcidNull
	 */
	public boolean isDcidNull()
	{
		return dcidNull;
	}

	/**
	 * Method 'getTimestamp4'
	 * 
	 * @return java.util.Date
	 */
	public String getTimestamp4()
	{
		return timestamp4;
	}

	/**
	 * Method 'setTimestamp4'
	 * 
	 * @param timestamp4
	 */
	public void setTimestamp4(String timestamp4)
	{
		this.timestamp4 = timestamp4;
	}

	/**
	 * Method 'getTimestamp5'
	 * 
	 * @return java.util.Date
	 */
	public String getTimestamp5()
	{
		return timestamp5;
	}

	/**
	 * Method 'setTimestamp5'
	 * 
	 * @param timestamp5
	 */
	public void setTimestamp5(String timestamp5)
	{
		this.timestamp5 = timestamp5;
	}

	/**
	 * Method 'getResponsetype'
	 * 
	 * @return long
	 */
	public Integer getResponsetype()
	{
		return responsetype;
	}

	/**
	 * Method 'setResponsetype'
	 * 
	 * @param responsetype
	 */
	public void setResponsetype(Integer responsetype)
	{
		this.responsetype = responsetype;
		this.responsetypeNull = false;
	}

	/** 
	 * Sets the value of responsetypeNull
	 */
	public void setResponsetypeNull(boolean responsetypeNull)
	{
		this.responsetypeNull = responsetypeNull;
	}

	/** 
	 * Gets the value of responsetypeNull
	 */
	public boolean isResponsetypeNull()
	{
		return responsetypeNull;
	}

	/**
	 * Method 'getDatauserrequestor'
	 * 
	 * @return long
	 */
	public String getDatauserrequestor()
	{
		return datauserrequestor;
	}

	/**
	 * Method 'setDatauserrequestor'
	 * 
	 * @param datauserrequestor
	 */
	public void setDatauserrequestor(String datauserrequestor)
	{
		this.datauserrequestor = datauserrequestor;
		this.datauserrequestorNull = false;
	}

	/** 
	 * Sets the value of datauserrequestorNull
	 */
	public void setDatauserrequestorNull(boolean datauserrequestorNull)
	{
		this.datauserrequestorNull = datauserrequestorNull;
	}

	/** 
	 * Gets the value of datauserrequestorNull
	 */
	public boolean isDatauserrequestorNull()
	{
		return datauserrequestorNull;
	}

	/**
	 * Method 'getShipname'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getShipname()
	{
		return shipname;
	}

	/**
	 * Method 'setShipname'
	 * 
	 * @param shipname
	 */
	public void setShipname(java.lang.String shipname)
	{
		this.shipname = shipname;
	}

	/**
	 * Method 'getDatauserprovider'
	 * 
	 * @return long
	 */
	public String getDatauserprovider()
	{
		return datauserprovider;
	}

	/**
	 * Method 'setDatauserprovider'
	 * 
	 * @param datauserprovider
	 */
	public void setDatauserprovider(String datauserprovider)
	{
		this.datauserprovider = datauserprovider;
		this.datauserproviderNull = false;
	}

	/** 
	 * Sets the value of datauserproviderNull
	 */
	public void setDatauserproviderNull(boolean datauserproviderNull)
	{
		this.datauserproviderNull = datauserproviderNull;
	}

	/** 
	 * Gets the value of datauserproviderNull
	 */
	public boolean isDatauserproviderNull()
	{
		return datauserproviderNull;
	}

	/**
	 * Method 'getDdpversionnum'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDdpversionnum()
	{
		return ddpversionnum;
	}

	/**
	 * Method 'setDdpversionnum'
	 * 
	 * @param ddpversionnum
	 */
	public void setDdpversionnum(java.lang.String ddpversionnum)
	{
		this.ddpversionnum = ddpversionnum;
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
