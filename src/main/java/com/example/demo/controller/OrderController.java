package com.example.demo.controller;

import com.example.demo.dto.BookCart;
import com.example.demo.dto.KakaoAPI;
import com.example.demo.mapper.OrderMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class OrderController {

    @Autowired OrderMapper orderMapper;


    @GetMapping("cart/list")
    public String cartView(Model model) {
        List<BookCart> orderList = orderMapper.findAll();
        model.addAttribute("orderList", orderList);
        return "user/cart";
    }

    @GetMapping("order/cal")
    public String orderCalculate(Model model) {
        List<BookCart> orderList = orderMapper.findAll();
        int sum = 0;

        for (int i = 0; i < orderList.size(); ++i) {
            sum += (orderList.get(i).getPrice() * orderList.get(i).getNumber());
        }

        model.addAttribute("sum", sum);
        model.addAttribute("orderList", orderList);

        return "user/order";
    }

    @PostMapping("cart/add")
    public String cartAdd(Model model,
                          @RequestParam("isbn") String isbn,
                          @RequestParam("number") int number) {

        String[] fisbn = isbn.split(" ");
        String url = "https://dapi.kakao.com/v3/search/book?target=isbn&query=" + fisbn[0];

        JSONObject jsonObject = KakaoAPI.KakaoAPITest(url);

        // 배열을 가져옵니다.
        JSONArray bookList = jsonObject.getJSONArray("documents");
        JSONObject book = bookList.getJSONObject(0);
        orderMapper.BookInsert(fisbn[0], book.getString("title"), book.getInt("price"), book.getString("thumbnail"), number);

        List<BookCart> orderList = orderMapper.findAll();
        model.addAttribute("orderList", orderList);
        return "user/cart";
    }

    @GetMapping("cart/delete")
    public String cartDelete(@RequestParam("cartId") int cartId) {
        orderMapper.BookDelete(cartId);
        return "redirect:/cart/list";
    }

}
