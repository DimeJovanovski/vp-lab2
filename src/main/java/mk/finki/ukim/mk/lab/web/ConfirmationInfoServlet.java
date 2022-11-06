package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfirmationInfoServlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final BalloonService balloonService;
    private final OrderService orderService;
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(BalloonService balloonService, OrderService orderService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        // String balloonColor, String balloonSize, String clientName, String clientAddress
        this.orderService.addPendingOrder((String) req.getSession().getAttribute("color"),
                (String) req.getSession().getAttribute("size"),
                (String) req.getSession().getAttribute("name"),
                (String) req.getSession().getAttribute("address"));
        context.setVariable( "clientName", req.getSession().getAttribute("name") );
        context.setVariable( "clientAddress", req.getSession().getAttribute("address") );
        context.setVariable( "clientIP", req.getRemoteAddr() );
        context.setVariable( "clientAgent", req.getHeader("User-Agent") );
        context.setVariable( "balloonColor", req.getSession().getAttribute("color") );
        context.setVariable( "balloonSize", req.getSession().getAttribute("size") );
        this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter() );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
