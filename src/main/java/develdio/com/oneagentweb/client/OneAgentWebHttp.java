package develdio.com.oneagentweb.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import develdio.com.oneagentweb.dao.ClientDataDao;
import develdio.com.oneagentweb.plataform.OneAgentWebService01;
import develdio.com.oneagentweb.servicelocator.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneAgentWebHttp extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final ServiceLocator sl = ServiceLocator.getInstance();
        final ClientDataDao clientDataDao = (ClientDataDao) sl.getBean("clientDataDao");

        try {
            ExecutorService pool = Executors.newFixedThreadPool(10);
            Future<OneAgentWebService01> future = pool.submit(() -> {
                return clientDataDao.fetchDataByPhoneNumber("551100000000");
            });

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Message was sending ...");
            out.println("Get telephone number: " + future.get().getInput().getPhone());

            pool.shutdown();
        }
        catch (InterruptedException ignored) { /* For explanatory purposes. Doesn't ignore it within real scenario ... */ }
        catch (ExecutionException ignored) { /* For explanatory purposes. Doesn't ignore it within real scenario ... */ }
    }
}
