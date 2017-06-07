package io.pivotal.microsamples.soapme;

import net.webservicex.GetCitiesByCountry;
import net.webservicex.GetCitiesByCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WeatherClient extends WebServiceGatewaySupport {

    public GetCitiesByCountryResponse getCitiesByCountry(String country) {

        GetCitiesByCountry request = new GetCitiesByCountry();
        request.setCountryName(country);

        GetCitiesByCountryResponse response = (GetCitiesByCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.com/globalweather.asmx",
                        request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetCitiesByCountry"));


        return response;
    }


}
