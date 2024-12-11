package example.task3;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String pathToTests = "src/main/resources/files/task3/test.json";
    private final static String pathToValues = "src/main/resources/files/task3/values.json";
    private final static String pathToWrite = "src/main/resources/files/task3/report.json";
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        fillResultsInTests(pathToTests, pathToValues, pathToWrite);
    }

    private static void fillResultsInTests(String testsJson, String valuesJson, String writeJson) {
        List<Test> testsList = getTests(testsJson);
        List<Result> results = getResults(valuesJson);

        for (Result result : results) {
            int resultId = result.getId();
            String resultValue = result.getValue();

            for (Test test : testsList) {
                if (test.getId() == resultId) {
                    test.setValue(resultValue);
                    continue;
                }
                if (test.getValues() != null) {
                    for (int k = 0; k < test.getValues().size(); k++) {
                        if (test.getValues().get(k).getId() == resultId) {
                            test.getValues().get(k).setValue(resultValue);
                        }
                    }
                }
            }
        }

        String json = gson.toJson(testsList);

        writeJson(json, writeJson);
    }

    private static void writeJson(String json, String path) {
        try (FileWriter file = new FileWriter(path)) {
            file.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Test> getTests(String path) {

        List<Test> testsList = new ArrayList<>();
        try {

            JsonElement jsonElement = gson.fromJson(new FileReader(path), JsonElement.class);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray testsArray = jsonObject.getAsJsonArray("tests");

            for (JsonElement testElement : testsArray) {
                Test test = gson.fromJson(testElement, Test.class);
                testsList.add(test);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return testsList;
    }

    private static List<Result> getResults(String path) {
        List<Result> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(path);
            JsonElement element = JsonParser.parseReader(reader);
            JsonObject jsonObject = element.getAsJsonObject();
            JsonArray values = jsonObject.getAsJsonArray("values");


            for (JsonElement value : values) {
                int id = value.getAsJsonObject().get("id").getAsInt();
                String val = value.getAsJsonObject().get("value").getAsString();
                Result myClass = new Result(id, val);
                list.add(myClass);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


}

