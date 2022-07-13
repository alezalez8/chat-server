package academy.prog.servlets;

import academy.prog.MessageList;
import academy.prog.service.AllPresentUsers;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GetUsersServlet extends HttpServlet {
    private MessageList msgList = MessageList.getInstance();
    private AllPresentUsers presentUsers = new AllPresentUsers();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // TODO

        resp.setContentType("application/json");

        String json = msgList.getPresentUsers();
        if (json != null) {
            OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
            os.write(buf);

        }
    }

}
