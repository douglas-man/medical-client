package com.demo;


//import gov.va.mdws.emrsvc.*;
import gov.va.medora.mdws.emrsvc.*;
//import net.webservicex.StockQuoteSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

/**
 * Created by dman on 8/8/16.
 */
public class App {
    private static final Logger LOGGER      = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"client-beans.xml"});
        EmrSvcSoap port = (EmrSvcSoap)context.getBean("emrSvc");


        RegionArray regionArray = port.getVHA();

        for (RegionTO regionTO: regionArray.getRegions().getRegionTO()) {
            LOGGER.debug("Name: "+regionTO.getName()+", ID: "+regionTO.getId());
        }


//        String quote = port.getQuote("AAPL");
//        DataSourceArray dataSourceArray = port.connect("688");
        LOGGER.debug("port: "+ port);

//        LOGGER.debug("port: "+ port);

//        String clinicId;
//        String clinicName;
//        String facilityName;
//        String status;
//        HospitalLocationTO location;
//
//        TaggedVisitArray vArray = port.getVisits("20150808.000000", "20160808.235959");
//        for (VisitTO visitTO : vArray.getVisits().getVisitTO()) {
//            status = visitTO.getStatus();
//            location = visitTO.getLocation();
//            clinicName = location.getName();
//
//            LOGGER.debug("visit status: {}%", status);
//            LOGGER.debug("location name: {}%", clinicName);
//        }
        // Iterator<VisitTO> iter = vArray.getVisitTO()

//        LOGGER.debug("getVisits result: "+ port.getVisits("20150808.000000", "20160808.235959"));
    }
}
