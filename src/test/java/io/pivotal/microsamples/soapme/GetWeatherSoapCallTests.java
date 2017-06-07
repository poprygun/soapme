package io.pivotal.microsamples.soapme;


import net.webservicex.GetCitiesByCountryResponse;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GetWeatherSoapCallTests {
    private JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
    private Client client;

    @Autowired
    private WeatherClient weatherClient;


    @Before
    public void initWeatherClient() throws Exception{
        client = dcf.createClient("http://www.webservicex.com/globalweather.asmx?wsdl");
    }


    @Test
    public void shouldRespondWithWeatherDynamic() throws Exception {
        Object[] res = client.invoke("GetCitiesByCountry", "Zimbabwe");
        assertTrue(res[0].toString().contains("Masvingo"));
    }

    @Test
    public void shouldCallGetWeatherDynamicWithParams() throws Exception {
        Object[] res = client.invoke("GetWeather", "Mutoko", "Zimbabwe");
        assertTrue(res[0].toString().contains("Data Not Found"));
    }

    @Test
    public void shouldCallGetWeatherUsingJaxB () {
        GetCitiesByCountryResponse response = weatherClient.getCitiesByCountry("Zimbabwe");
        assertTrue(response.getGetCitiesByCountryResult().contains("Masvingo"));
    }

    @Test
    public void shouldCallGetCitiesByCountryUsingGeneratedCode() throws Exception {

        GlobalWeather service = new GlobalWeather();
        GlobalWeatherSoap globalWeatherSoap = service.getGlobalWeatherSoap();
        String zimbabweCities = globalWeatherSoap.getCitiesByCountry("Zimbabwe");
        assertTrue(zimbabweCities.contains("Masvingo"));
    }
}
