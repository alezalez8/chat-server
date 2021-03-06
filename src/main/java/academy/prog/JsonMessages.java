package academy.prog;

import academy.prog.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonMessages {
    private  List<Message> list = new ArrayList<>();


    public JsonMessages(List<Message> sourceList, int fromIndex, String pass, int countOfMessages) {
        for (int i = fromIndex; i < sourceList.size(); i++) {

            if (sourceList.get(i).getTo() == null
                    || sourceList.get(i).getTo().equals(pass)
                    || sourceList.get(i).getFrom().equals(pass)) {
                Message message = sourceList.get(i);
                message.setCurrentCount(countOfMessages);
                list.add(message);
            }
        }
    }

    public JsonMessages(List<Message> sourceList) {
        DateUtil dateUtil = new DateUtil();
         list =  sourceList.stream().filter(o -> dateUtil.isUserPresent(o.getDate()))
                .distinct().collect(Collectors.toList());

    }


}
