package com.wbl.base;

import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.wbl.helper.ConfigUtils;

public class BaseAPITest {
	
protected String endpoint;
@BeforeSuite
public void beforeSuite()
{

	Properties prop=ConfigUtils.loadproperties("config.properties");
	endpoint=prop.getProperty(("TSurl"));
	
}


}
