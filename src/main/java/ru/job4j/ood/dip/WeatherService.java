package ru.job4j.ood.dip;

/**
 * WeatherService напрямую зависит от WeatherApi,
 * что делает его зависимым от конкретного внешнего сервиса.
 * Лучше использовать абстракцию или интерфейс для WeatherApi,
 * чтобы класс был более гибким и легко заменяемым.
 */

public class WeatherService {
    private WeatherApi weatherApi = new WeatherApi();

    public String getWeather(String city) {
        return weatherApi.getWeather(city);
    }

    class WeatherApi {

        public String getWeather(String city) {
            return null;
        }
    }
}

