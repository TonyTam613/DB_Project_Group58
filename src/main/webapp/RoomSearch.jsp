<%--
  Created by IntelliJ IDEA.
  User: seepa
  Date: 4/9/2023
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.DB_Project.*" %>
<%@ page import="java.math.BigDecimal" %>

<%
    String hotelName = null;
    if (request.getParameter("search_hotel") != null && !request.getParameter("search_hotel").equals("")){
        hotelName = request.getParameter("search_hotel");
    }
    Double price = null;
    if (request.getParameter("search_price") != null && !request.getParameter("search_price").equals("")){
        price = Double.valueOf(request.getParameter("search_price"));
    }

    Integer capacity = null;
    if (request.getParameter("search_capacity") != null && !request.getParameter("search_capacity").equals("")){
        capacity = Integer.valueOf(request.getParameter("search_capacity"));
    }
    String view = null;
    if (request.getParameter("search_view") != null && !request.getParameter("search_view").equals("")){
        view = request.getParameter("search_view");
    }
    String area = null;
    if (request.getParameter("search_location") != null && !request.getParameter("search_location").equals("")){
        area = request.getParameter("search_location");
    }

    Message msg;
    boolean worked = false;

    try {
        worked = true;
        RoomService roomService = new RoomService();
        HotelService hotelService = new HotelService();
        ChainService chainService = new ChainService();
        List<Room> roomList = roomService.getRooms();

        System.out.println(hotelName + ":" + price + ":" + capacity + ":" + view + ":" + area);
        if (hotelName != null) {
            int i = 0;
            int length = roomList.size();
            while (i < length) {
                Hotel findHotel = hotelService.getHotel(roomList.get(i).getHotelId());
                Chain findChain = chainService.getChain(findHotel.getChainId());
                if (!hotelName.equals(findChain.getName())) {
                    roomList.remove(i);
                    i -= 1;
                    length -= 1;
                }
                i++;
            }
        }
        if (price != null) {
            int i = 0;
            int length = roomList.size();
            while (i < length) {
                if (roomList.get(i).getPrice().compareTo(BigDecimal.valueOf(price)) > 0) {
                    roomList.remove(i);
                    i -= 1;
                    length -= 1;
                }
                i++;
            }
        }
        if (capacity != null) {
            int i = 0;
            int length = roomList.size();
            while (i < length) {
                if (!roomList.get(i).getCapacity().equals(capacity)) {
                    roomList.remove(i);
                    i -= 1;
                    length -= 1;
                }
                i++;
            }
        }

        if (view != null) {
            int i = 0;
            int length = roomList.size();
            while (i < length) {
                if (!roomList.get(i).getView().equals(view)) {
                    roomList.remove(i);
                    i -= 1;
                    length -= 1;
                }
                i++;
            }
        }

        if (area != null) {
            int i = 0;
            int length = roomList.size();
            while (i < length) {
                Hotel findHotel = hotelService.getHotel(roomList.get(i).getHotelId());
                if (!findHotel.getCity().equals(area)) {
                    roomList.remove(i);
                    i -= 1;
                    length -= 1;
                }
                i++;
            }
        }

        msg = new Message("Success", "Rooms found");
        /*for ( Room room: roomList) {
            System.out.println(room);
            System.out.println(roomList.size());
        }*/
        session.setAttribute("filteredRooms", roomList);

    } catch (Exception e) {
        worked = false;
        e.printStackTrace();
        msg = new Message("Error", "Something went wrong with filtering the rooms");
    }

    ArrayList<Message> messages = new ArrayList<Message>();
    messages.add(msg);
    session.setAttribute("messages", messages);
    if (!worked) {
        response.sendRedirect("index.jsp");
    } else {
        response.sendRedirect("Selection.jsp");
    }
%>
