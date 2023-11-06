package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Intercom intercom = new Intercom(123, "BewardDKS", true, new HwFw("5.3.2.1.1", "3.1.5.5.5.46"),
                new String[] {"ул. Программистов", "д. 32"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(intercom));

        final String personJson =
                "{"
                        + "\"id\":303,"
                        + "\"model\": \"Sputnik.Odin\","
                        + "\"call\": true,"
                        + "\"hwFw\": {\"hw\":\"3.4.1.5\", \"fw\":\"3.4.1.5.3.1.111\"},"
                        + "\"statuses\": [\"online\",\"work\"]"
                        + "}";

        final Intercom personMod = gson.fromJson(personJson, Intercom.class);
        System.out.println(personMod);

        JSONObject jsonContact = new JSONObject("{\"hw\":\"3.4.1.5\", \"fw\":\"3.4.1.5.3.1.111\"}");

        List<String> list = new ArrayList<>();
        list.add("online");
        list.add("work");
        JSONArray jsonStatuses = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BewardDKS", intercom.getModel());
        jsonObject.put("id", intercom.getId());
        jsonObject.put("hwfw", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(intercom).toString());
    }
}