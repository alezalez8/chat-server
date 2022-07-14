package academy.prog.service;

import academy.prog.util.DateUtil;

import java.util.*;

public class AllPresentUsers {

    private static Map<String, Date> listOfAllUser = new HashMap<>();

    private  DateUtil dateUtil;


    public synchronized void getRequestFromUsers(String userLogin) {
        listOfAllUser.put(userLogin, new Date());
    }


    public synchronized List<String> getPresentUsers() {
        List<String> listOfPresentUsers = new ArrayList<>();
        dateUtil = new DateUtil();
        for (Map.Entry<String, Date> map: listOfAllUser.entrySet()
             ) {
            if (dateUtil.isUserPresent(map.getValue())) {
                listOfPresentUsers.add(map.getKey());
            }
        }
        System.out.println(listOfPresentUsers);
        return listOfPresentUsers;
    }


}
