package pl.sda.zadaniaGrzegorz.weatherApproach;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherService {
    private WeatherRepository weatherRepository;

    public boolean getCurrentWeatherAndSave() {
        //tutaj cała logika dotycząca komunikacji z weather.api
        //i rozłożenia informacji zwrotnej na dane dot. daty, temperatury, warunków, wiatru, ...

        Weather weather = new Weather();

        //i wywołanie zapisania do bazy
        weatherRepository.save(weather);

        return true;
    }

    public String getCurrentConditions() {
        //tutaj wyciągnięcie z bazy najnowszego wpisu i zwrócenie go po przekształceniu na String
        return weatherRepository.findCurrentConditions().toString();
    }

    public String getAverageTemperature() {
        //tutaj wyciągnięcie
        // - albo wszystkich danych i wybranie temperatury
        List<Weather> weatherList = weatherRepository.findAll();
        weatherList.stream()
                .map(Weather::getTemperature)
                .collect(Collectors.toList());

        // - albo od razu tylko temperatury
        //i wyliczenie średniej z tej temperatury
        weatherRepository.getAvgTemperature();

        return "";
    }
}
