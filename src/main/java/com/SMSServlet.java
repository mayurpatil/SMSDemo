package com;

import java.io.IOException;
import javax.servlet.http.*;
import java.io.*;
import java.security.*;
import java.net.*;

@SuppressWarnings("serial")
public class SMSServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");

		String reciepientnum = req.getParameter("mnum");
		String textmsg = req.getParameter("mtext").replaceAll(" ", "%20");

		try {
			
			String strUrl = "http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=mayursdmcse@gmail.com:123456&senderID=TEST%20SMS&receipientno="
					+ reciepientnum + "&msgtxt=" + textmsg + "&state=4";

			URL myURL = new URL(strUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					myURL.openStream()));

			String inputLine;

			while ((inputLine = in.readLine()) != null)
				resp.getWriter().println(inputLine);

			in.close();
		} catch (Exception e) {
			resp.getWriter().println("error" + e);

		}
	}
}
