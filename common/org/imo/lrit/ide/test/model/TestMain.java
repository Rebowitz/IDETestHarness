package org.imo.lrit.ide.test.model;


import org.imo.lrit.ide.common.model.Base;

public class TestMain extends Base{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** 
	 * This attribute maps to the column TEST_ID in the TEST_MAIN table.
	 */
	protected long testid;

	/** 
	 * This attribute maps to the column MSG_TYPE in the TEST_MAIN table.
	 */
	protected String msgType;

	/** 
	 * This attribute maps to the column TEST_DESCRIPTION in the TEST_MAIN table.
	 */
	protected String testDescription;

	/** 
	 * This attribute maps to the column ACTIVE_TEST in the TEST_MAIN table.
	 */
	protected String activeTest;

	/** 
	 * This attribute maps to the column SUCCESSFAIL in the TEST_MAIN table.
	 */
	protected long successfail;

	/**
	 * Method 'TestMain'
	 * 
	 */
	public TestMain()
	{
	}

	/**
	 * Method 'getTestId'
	 * 
	 * @return long
	 */
	public long gettestid()
	{
		return testid;
	}

	/**
	 * Method 'setTestId'
	 * 
	 * @param testId
	 */
	public void settestid(long testId)
	{
		this.testid = testId;
	}

	/**
	 * Method 'getMsgType'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMsgType()
	{
		return msgType;
	}

	/**
	 * Method 'setMsgType'
	 * 
	 * @param msgType
	 */
	public void setMsgType(java.lang.String msgType)
	{
		this.msgType = msgType;
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
	 * Method 'getActiveTest'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getActiveTest()
	{
		return activeTest;
	}

	/**
	 * Method 'setActiveTest'
	 * 
	 * @param activeTest
	 */
	public void setActiveTest(java.lang.String activeTest)
	{
		this.activeTest = activeTest;
	}

	/**
	 * Method 'getSuccessfail'
	 * 
	 * @return long
	 */
	public long getSuccessfail()
	{
		return successfail;
	}

	/**
	 * Method 'setSuccessfail'
	 * 	 * 
	 * @param successfail
	 */
	public void setSuccessfail(long successfail)
	{
		this.successfail = successfail;

	}

}
