package academy.prog.servlets;

import academy.prog.MessageList;
import academy.prog.service.AllPresentUsers;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GetListServlet extends HttpServlet {
	
	private MessageList msgList = MessageList.getInstance();
	private AllPresentUsers presentUsers = new AllPresentUsers();

    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String fromStr = req.getParameter("from");
		String toLogin = req.getParameter("log");

		int from = 0;
		try {
			from = Integer.parseInt(fromStr);
			if (from < 0) from = 0;
		} catch (Exception ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
		}

		presentUsers.getRequestFromUsers(toLogin);
		//presentUsers.printUser();
		//presentUsers.getPresentUsers();

		resp.setContentType("application/json");
		
		String json = msgList.toJSON(from, toLogin);
		if (json != null) {
			OutputStream os = resp.getOutputStream();
            byte[] buf = json.getBytes(StandardCharsets.UTF_8);
			os.write(buf);
			os.close();

			//PrintWriter pw = resp.getWriter();
			//pw.print(json);
		}
	}
}
