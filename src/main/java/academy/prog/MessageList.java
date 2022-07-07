package academy.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedList;
import java.util.List;

public class MessageList {
    private static final MessageList msgList = new MessageList();
    //private static final ShowList sL = new ShowList();
    private int countOfMessages;


    private final Gson gson;
    private final List<Message> list = new LinkedList<>();  // save incoming messages

    public static MessageList getInstance() {
        return msgList;
    }

    private MessageList() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public synchronized void add(Message m) {
        list.add(m);
    }

    public synchronized String toJSON(int n, String pass) {  // collect messages from n to end and wrap to gson (string line to client)
        if (n >= list.size()) return null;
        countOfMessages = list.size();
        return gson.toJson(new JsonMessages(list, n, pass, countOfMessages)); // serialized by json  list of object type of ArrayList<Message>
    }

    public synchronized String getPresentUsers() {
        return gson.toJson(new JsonMessages(list));
    }

}
