package service;

public interface Service {
    void putModelToMap(Long number, Object model);

    void printModelsValueFromMap();

    void loadToMapObjectFromFile();

    void saveObjectMapToFile();

    void remove();
}
